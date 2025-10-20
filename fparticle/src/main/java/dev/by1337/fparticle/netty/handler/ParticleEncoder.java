package dev.by1337.fparticle.netty.handler;

import dev.by1337.fparticle.particle.ParticlePacketBuilder;
import dev.by1337.fparticle.via.ViaHook;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.bukkit.entity.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParticleEncoder extends MessageToByteEncoder<ParticlePacketBuilder> {

    private static final Logger log = LoggerFactory.getLogger("ParticleEncoder");

    private final ViaHook.ViaMutator viaMutator;

    public ParticleEncoder(Channel channel, Player player) {
        viaMutator = ViaHook.getViaMutator(player, channel);
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, ParticlePacketBuilder writer, ByteBuf byteBuf) throws Exception {
        long l = System.nanoTime();
        writer.accept(viaMutator, byteBuf);
        log.info("Sent {} bytes... {}us", byteBuf.readableBytes(), ((System.nanoTime() - l) / 1000D));
    }
}
