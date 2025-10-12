package dev.by1337.fparticle.netty.handler;

import dev.by1337.fparticle.FParticleUtil;
import dev.by1337.fparticle.particle.ParticlePacketBuilder;
import dev.by1337.fparticle.via.ViaHook;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.AttributeKey;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

public class ParticleEncoder extends MessageToByteEncoder<ParticlePacketBuilder> {

    public static final AttributeKey<ParticleEncoder>
            ATTRIBUTE = AttributeKey.valueOf(ParticleEncoder.class.getName() + ".attribute");

    private final int protocolVersion;
    private final ViaHook.ViaMutator viaMutator;
    private final UUID uuid;
    private volatile boolean isPlayState;

    public ParticleEncoder(Channel channel, Player player) {
        viaMutator = ViaHook.getViaMutator(player, channel);
        protocolVersion = viaMutator.protocol();
        channel.attr(ATTRIBUTE).set(this);
        uuid = player.getUniqueId();
    }


    @Override
    protected void encode(ChannelHandlerContext ctx, ParticlePacketBuilder writer, ByteBuf byteBuf) throws Exception {
        if (!isPlayState) {
            isPlayState = FParticleUtil.isPlayState(Bukkit.getPlayer(uuid));
        }
        if (isPlayState) {
            writer.accept(viaMutator, byteBuf);
        }
    }

    public int protocolVersion() {
        return protocolVersion;
    }

    public ViaHook.ViaMutator viaMutator() {
        return viaMutator;
    }
}
