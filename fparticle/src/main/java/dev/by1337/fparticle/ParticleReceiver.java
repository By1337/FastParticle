package dev.by1337.fparticle;


import dev.by1337.fparticle.particle.ParticleIterable;
import dev.by1337.fparticle.util.ByteBufUtil;
import dev.by1337.fparticle.util.Version;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ParticleReceiver {
    private static final int MAX_EXPECTED_SIZE = 16*1024;
    private final Channel channel;
    private final int packetId;
    private final ChannelHandlerContext forward;
    private ByteBuf out;
    private ByteBuf tmp;
    private final Lock lock = new ReentrantLock();
    int particles;
    private final int protocolVersion;

    public ParticleReceiver(Channel channel) {
        protocolVersion = Version.VERSION.protocolVersion();
        this.channel = channel;
        out = channel.alloc().buffer();
        tmp = channel.alloc().buffer();
        this.packetId = FParticle.NMS_UTIL.getLevelParticlesPacketId();
        if (channel.pipeline().get("bnms_nop") == null) {
            channel.pipeline().addBefore("prepender", "bnms_nop", new MessageToByteEncoder<ByteBuf>() {
                @Override
                protected void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ByteBuf byteBuf2) {
                }

                public boolean acceptOutboundMessage(Object msg) {
                    return false;
                }
            });
        }
        forward = channel.pipeline().context("bnms_nop");
    }


    public void addSpawnedParticles(int count) {
        lock.lock();
        particles += count;
        lock.unlock();
    }

    public void write(ByteBuf buf) {
        if (out == null) return; //closed
        lock.lock();
        out.writeBytes(buf);
        lock.unlock();
    }

    public ByteBuf writeAndGetSlice(ParticleIterable particles) {
        if (out == null) return null; //closed
        lock.lock();
        try {
            int start = out.writerIndex();
            write(particles);
            int end = out.writerIndex();
            return start == end ? null : out.retainedSlice(start, end - start);
        } finally {
            lock.unlock();
        }
    }

    public void write(ParticleIterable particles) {
        if (out == null) return; //closed
        lock.lock();
        this.particles += particles.size();
        try {
            var iterator = particles.iterator();

            ByteBufUtil.writeVarInt(tmp, packetId);
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
                ByteBufUtil.writeVarInt(tmp, packetId);
            }
        } finally {
            tmp.clear();
            lock.unlock();
        }
    }

    public void tick() {
        flush();
    }

    public void flush() {
        if (out == null) return; //closed
        lock.lock();
        try {
            if (out.readableBytes() == 0) return;
            //todo debug
            Bukkit.getOnlinePlayers().forEach(player ->
                    player.sendActionBar(Component.text("spawn particles: " + particles).color(NamedTextColor.YELLOW)));
            particles = 0;
            forward.writeAndFlush(out);

            out = channel.alloc().buffer();
            if (tmp.capacity() >= MAX_EXPECTED_SIZE) {
                tmp.release();
                tmp = channel.alloc().buffer();
            }
        } finally {
            lock.unlock();
        }
    }

    public void close() {
        if (out == null) return; //closed
        lock.lock();
        try {
            if (channel.pipeline().get("bnms_nop") != null) {
                channel.pipeline().remove("bnms_nop");
            }
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
