package dev.by1337.fparticle.handler;

import dev.by1337.fparticle.FParticle;
import dev.by1337.fparticle.particle.ParticleIterable;
import dev.by1337.fparticle.util.ByteBufUtil;
import dev.by1337.fparticle.util.Version;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.AttributeKey;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ParticleSender extends MessageToByteEncoder<ByteBuf> {
    private static final long FLUSH_DELAY = TimeUnit.MILLISECONDS.toNanos(50);
    private static final int PACKET_ID = FParticle.NMS_UTIL.getLevelParticlesPacketId();

    public static final AttributeKey<ParticleSender> ATTRIBUTE = AttributeKey.valueOf("fparticle_attr");
    private static final int MAX_EXPECTED_SIZE = 16 * 1024;

    private final Channel channel;
    private ByteBuf out;
    private ByteBuf tmp;
    private final Lock lock = new ReentrantLock();
    private int particles;
    private final int protocolVersion;
    private long lastFlushTime;
    private ChannelHandlerContext ctx;

    public ParticleSender(Channel channel) {
        this.channel = channel;
        // channel.closeFuture().addListener((future) -> this.close());
        protocolVersion = Version.VERSION.protocolVersion();//todo
        out = channel.alloc().buffer();
        tmp = channel.alloc().buffer();
        channel.attr(ATTRIBUTE).set(this);
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

    public void addSpawnedParticles(int count) {
        lock.lock();
        particles += count;
        lock.unlock();
    }

    public void write(ByteBuf buf) {
        lock.lock();
        try {
            write(buf, out);
        } finally {
            flushIfDue();
            lock.unlock();
        }
    }

    public ByteBuf writeAndGetSlice(ParticleIterable particles) {
        lock.lock();
        try {
            return writeAndGetSlice(particles, out);
        } finally {
            flushIfDue();
            lock.unlock();
        }
    }

    public void write(ParticleIterable particles) {
        lock.lock();
        try {
            write(particles, out);
        } finally {
            flushIfDue();
            lock.unlock();
        }
    }

    private void write(ByteBuf buf, ByteBuf out) {
        if (out == null) return; //closed
        out.writeBytes(buf);
    }

    private ByteBuf writeAndGetSlice(ParticleIterable particles, ByteBuf out) {
        if (out == null) return null; //closed
        int start = out.writerIndex();
        write(particles, out);
        int end = out.writerIndex();
        return start == end ? null : out.retainedSlice(start, end - start);
    }

    private void write(ParticleIterable particles, ByteBuf out) {
        if (out == null) return; //closed
        this.particles += particles.size();
        var iterator = particles.iterator();

        ByteBufUtil.writeVarInt(tmp, PACKET_ID);
        while (iterator.writeNext(tmp)) {
            int compressSize;
            if (tmp.readableBytes() > 256) {
                compressSize = -1;
                //todo
            } else {
                compressSize = 0;
            }
            ByteBufUtil.writeVarInt(out, tmp.readableBytes() + ByteBufUtil.warIntSize(compressSize));
            ByteBufUtil.writeVarInt(out, compressSize);
            out.writeBytes(tmp);
            tmp.clear();
            ByteBufUtil.writeVarInt(tmp, PACKET_ID);
        }
        tmp.clear();
    }

    public void flush() {
        if (out == null) return; //closed
        lock.lock();
        lastFlushTime = System.nanoTime();
        ByteBuf toFlush;
        try {
            if (out.readableBytes() == 0) return;
            //todo debug
            Bukkit.getOnlinePlayers().forEach(player ->
                    player.sendActionBar(Component.text("spawn particles: " + particles).color(NamedTextColor.YELLOW)));
            particles = 0;
            toFlush = out;
            out = channel.alloc().buffer();
            if (tmp.capacity() >= MAX_EXPECTED_SIZE) {
                tmp.release();
                tmp = channel.alloc().buffer();
            }
        } finally {
            lock.unlock();
        }
        if (ctx != null) {
            ctx.writeAndFlush(toFlush);
        } else {
            toFlush.release();
        }
    }

    public void close() {
        if (out == null) return;
        System.out.println("ParticleSender.close");
        lock.lock();
        try {
            out.release();
            out = null;
            tmp.release();
            tmp = null;
        } finally {
            lock.unlock();
        }
    }

    public int protocolVersion() {
        return protocolVersion;
    }

}
