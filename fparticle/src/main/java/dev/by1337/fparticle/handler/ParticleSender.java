package dev.by1337.fparticle.handler;

import dev.by1337.fparticle.particle.ParticleIterable;
import dev.by1337.fparticle.util.ByteBufUtil;
import dev.by1337.fparticle.util.ByteBufPool;
import dev.by1337.fparticle.util.Version;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.AttributeKey;

import java.util.concurrent.TimeUnit;

public class ParticleSender extends MessageToByteEncoder<ByteBuf> {
    private static final long FLUSH_DELAY = TimeUnit.MILLISECONDS.toNanos(50);

    public static final AttributeKey<ParticleSender> ATTRIBUTE = AttributeKey.valueOf("fparticle_attr");

    private final Channel channel;
    private final int protocolVersion;
    private long lastFlushTime;
    private ChannelHandlerContext ctx;
    private final ByteBufPool pool;

    public ParticleSender(Channel channel) {
        this.channel = channel;
        protocolVersion = Version.VERSION.protocolVersion();//todo
        channel.attr(ATTRIBUTE).set(this);
        pool = new ByteBufPool(channel.alloc(),1024, 50, 8, this::write);
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        super.handlerAdded(ctx);
        this.ctx = ctx;
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        super.handlerRemoved(ctx);
        this.ctx = null;
        close();
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, ByteBuf byteBuf, ByteBuf byteBuf2) {
    }

    public boolean acceptOutboundMessage(Object msg) {
        flushIfDue();
        return false;
    }

    @Override
    public void close(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
        super.close(ctx, promise);
        close();
    }

    public void flushIfDue() {
        if (System.nanoTime() - lastFlushTime > FLUSH_DELAY) {
            flush();
        }
    }

    public void write(ByteBuf buf) {
        if (ctx == null){
            buf.release();
            return;
        }
        ctx.write(buf);
        flushIfDue();
    }

    public ByteBuf writeAndGetSlice(ParticleIterable particles) {
        var pooled = pool.acquire();
        try {
            return writeAndGetSlice(particles, pooled.buf());
        } finally {
            pool.release(pooled);
            flushIfDue();
        }
    }

    public void write(ParticleIterable particles) {
        var pooled = pool.acquire();
        try {
            write(particles, pooled.buf());
        } finally {
            pool.release(pooled);
        }
    }

    private ByteBuf writeAndGetSlice(ParticleIterable particles, ByteBuf out) {
        int start = out.writerIndex();
        write(particles, out);
        int end = out.writerIndex();
        return start == end ? null : out.retainedSlice(start, end - start);
    }

    private void write(ParticleIterable particles, ByteBuf out) {
        ByteBufUtil.writeParticle(out, particles);
    }

    public void flush() {
        lastFlushTime = System.nanoTime();
        pool.flushExpired();
        if (ctx != null) {
            ctx.flush();
        }
    }

    public void close() {
    }

    public int protocolVersion() {
        return protocolVersion;
    }

}
