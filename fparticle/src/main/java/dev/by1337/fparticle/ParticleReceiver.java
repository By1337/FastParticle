package dev.by1337.fparticle;

import dev.by1337.fparticle.netty.buffer.ByteBufPool;
import dev.by1337.fparticle.netty.buffer.ByteBufUtil;
import dev.by1337.fparticle.particle.ParticleSource;
import dev.by1337.fparticle.via.ViaHook;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.AttributeKey;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ParticleReceiver extends MessageToByteEncoder<ByteBuf> {
    private static final long FLUSH_DELAY = TimeUnit.MILLISECONDS.toNanos(50);

    public static final AttributeKey<ParticleReceiver>
            ATTRIBUTE = AttributeKey.valueOf(ParticleReceiver.class.getName() + ".attribute");

    private final Channel channel;
    private final int protocolVersion;
    private long lastFlushTime;
    private ChannelHandlerContext ctx;
    private final ByteBufPool pool;
    private final ViaHook.ViaMutator viaMutator;
    private boolean ready;
    private final UUID uuid;

    public ParticleReceiver(Channel channel, Player player) {
        this.channel = channel;
        viaMutator = ViaHook.getViaMutator(player, channel);
        protocolVersion = viaMutator.protocol();
        channel.attr(ATTRIBUTE).set(this);
        ready = FParticleUtil.canReceiveParticles(player);
        uuid = player.getUniqueId();
        pool = new ByteBufPool(channel.alloc(), 1024, 50, 8, this::write);
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        super.handlerAdded(ctx);
        this.ctx = ctx;
        pool.setClosed(false);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        super.handlerRemoved(ctx);
        this.ctx = null;
        pool.setClosed(true);
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

    public boolean ready() {
        if (!ready) {
            ready = FParticleUtil.canReceiveParticles(Bukkit.getPlayer(uuid));
        }
        return ready && ctx != null;
    }

    public void flushIfDue() {
        if (System.nanoTime() - lastFlushTime > FLUSH_DELAY) {
            flush();
        }
    }

    public void write(ByteBuf buf) {
        if (!ready()) {
            buf.release();
            return;
        }
        ctx.write(buf);
        flushIfDue();
    }

    public ByteBuf writeAndGetSlice(ParticleSource particles) {
        if (!ready()) return null;
        var pooled = pool.acquire();
        try {
            return ByteBufUtil.writeAndGetSlice(pooled.buf(), particles, viaMutator);
        } finally {
            pool.release(pooled);
            flushIfDue();
        }
    }

    public void write(ParticleSource particles) {
        if (!ready()) return;
        var pooled = pool.acquire();
        try {
            ByteBufUtil.writeParticle(pooled.buf(), particles, viaMutator);
        } finally {
            pool.release(pooled);
        }
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
