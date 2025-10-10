package dev.by1337.fparticle;

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
import org.jetbrains.annotations.Nullable;

import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ParticleReceiver extends MessageToByteEncoder<ByteBuf> {
    private static final long FLUSH_DELAY = TimeUnit.MILLISECONDS.toNanos(50);

    public static final AttributeKey<ParticleReceiver>
            ATTRIBUTE = AttributeKey.valueOf(ParticleReceiver.class.getName() + ".attribute");

    private final Channel channel;
    private final int protocolVersion;
    private long lastFlushTime;
    private @Nullable ChannelHandlerContext ctx;
    private final ViaHook.ViaMutator viaMutator;
    private boolean ready;
    private final UUID uuid;
    private @Nullable ByteBuf buf;
    private final ReentrantLock lock = new ReentrantLock();

    public ParticleReceiver(Channel channel, Player player) {
        this.channel = channel;
        viaMutator = ViaHook.getViaMutator(player, channel);
        protocolVersion = viaMutator.protocol();
        channel.attr(ATTRIBUTE).set(this);
        ready = FParticleUtil.canReceiveParticles(player);
        uuid = player.getUniqueId();
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
        lock.lock();
        if (buf != null) {
            buf.release();
            buf = null;
        }
        lock.unlock();
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
    }

    public ByteBuf writeAndGetRetainedSlice(ParticleSource particles, double x, double y, double z) {
        if (!ready()) return null;
        lock.lock();
        try {
            return ByteBufUtil.writeAndGetRetainedSlice(getBuf(), particles, viaMutator, x, y, z);
        } finally {
            lock.unlock();
        }
    }

    public void write(ParticleSource particles, double x, double y, double z) {
        if (!ready()) return;
        lock.lock();
        try {
            ByteBufUtil.writeParticle(getBuf(), particles, viaMutator, x, y, z);
        } finally {
            lock.unlock();
        }
    }

    private ByteBuf getBuf() {
        if (!lock.isHeldByCurrentThread()) throw new IllegalStateException("Not held by current thread");
        if (buf == null) {
            buf = channel.alloc().buffer();
        }
        return buf;
    }


    public void flush() {
        lastFlushTime = System.nanoTime();
        lock.lock();
        try {
            if (buf != null && buf.isReadable()) {
                if (ctx != null) {
                    ctx.write(buf);
                } else {
                    buf.release();
                }
                buf = null;
            }
        } finally {
            lock.unlock();
        }

        if (ctx != null) {
            ctx.flush();
        }
    }

    public void close() {
    }

    public int protocolVersion() {
        return protocolVersion;
    }

    public ViaHook.ViaMutator viaMutator() {
        return viaMutator;
    }
}
