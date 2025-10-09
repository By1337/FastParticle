package dev.by1337.fparticle;

import dev.by1337.fparticle.particle.ParticleSource;
import io.netty.buffer.ByteBuf;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.function.Function;

public class FParticle {

    public static ParticleReceiver getReceiver(Player player) {
        return FParticleUtil.getChannel(player).attr(ParticleReceiver.ATTRIBUTE).get();
    }

    public static void send(ParticleReceiver receiver, ParticleSource particle,  double x, double y, double z) {
        receiver.write(particle,  x, y, z);
    }

    public static void send(Player receiver, ParticleSource particle,  double x, double y, double z) {
        getReceiver(receiver).write(particle,  x, y, z);
    }

    public static void sendParticles(Collection<ParticleReceiver> receivers, ParticleSource particles,  double x, double y, double z) {
        sendParticle(receivers, particles, Function.identity(),  x, y, z);
    }

    public static void sendParticle(Collection<Player> receivers, ParticleSource particles, double x, double y, double z) {
        sendParticle(receivers, particles, FParticle::getReceiver,  x, y, z);
    }

    private static <T> void sendParticle(Collection<T> receivers, ParticleSource particles, Function<T, ParticleReceiver> mapper,  double x, double y, double z) {
        final int[] protocols = new int[32];
        int freeBuffIdx = 0;
        final ByteBuf[] bufs = new ByteBuf[32];
        try {
            for (T receiver0 : receivers) {
                ParticleReceiver receiver = mapper.apply(receiver0);
                freeBuffIdx = ParticleSender.send(receiver, particles, protocols, freeBuffIdx, bufs, x, y, z);
            }
        } finally {
            for (int i = 0; i < freeBuffIdx; i++) {
                bufs[i].release();
            }
        }
    }
}
