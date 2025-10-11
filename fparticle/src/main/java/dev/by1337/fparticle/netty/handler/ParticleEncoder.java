package dev.by1337.fparticle.netty.handler;

import dev.by1337.fparticle.FParticleUtil;
import dev.by1337.fparticle.particle.ParticleOutputStream;
import dev.by1337.fparticle.via.ViaHook;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.AttributeKey;
import org.bukkit.entity.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class ParticleEncoder extends MessageToByteEncoder<ParticleOutputStream> {
    public static final int PACKET_ID = FParticleUtil.getLevelParticlesPacketId();
    private static final Logger log = LoggerFactory.getLogger("FParticle");

    public static final AttributeKey<ParticleEncoder>
            ATTRIBUTE = AttributeKey.valueOf(ParticleEncoder.class.getName() + ".attribute");

    private final Channel channel;
    private final int protocolVersion;
    private final ViaHook.ViaMutator viaMutator;
    private final UUID uuid;

    public ParticleEncoder(Channel channel, Player player) {
        this.channel = channel;
        viaMutator = ViaHook.getViaMutator(player, channel);
        protocolVersion = viaMutator.protocol();
        channel.attr(ATTRIBUTE).set(this);
        uuid = player.getUniqueId();
    }


    @Override
    protected void encode(ChannelHandlerContext ctx, ParticleOutputStream writer, ByteBuf byteBuf) throws Exception {
        long nanos = System.nanoTime();
        writer.accept(viaMutator, byteBuf);
        System.out.println((System.nanoTime() - nanos) / 1000D + "us");
    }

    public int protocolVersion() {
        return protocolVersion;
    }

    public ViaHook.ViaMutator viaMutator() {
        return viaMutator;
    }
}
