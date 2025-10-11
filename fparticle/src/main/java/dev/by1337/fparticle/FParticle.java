package dev.by1337.fparticle;

import dev.by1337.fparticle.particle.ParticleSource;
import org.bukkit.entity.Player;

import java.util.Collection;

public class FParticle {


    public static void send(Player receiver, ParticleSource particle,  double x, double y, double z) {
        FParticleUtil.send(receiver, particle.writerAt(x, y, z));
    }

    public static void send(Collection<Player> receivers, ParticleSource particle, double x, double y, double z) {
        receivers.forEach(p -> FParticleUtil.send(p, particle.writerAt(x, y, z)));
    }

   /* private static <T> void sendParticle(Collection<T> receivers, ParticleSource particles, Function<T, ParticleEncoder> mapper, double x, double y, double z) {
        final int[] protocols = new int[32];
        int freeBuffIdx = 0;
        final ByteBuf[] bufs = new ByteBuf[32];
        try {
            for (T receiver0 : receivers) {
                ParticleEncoder receiver = mapper.apply(receiver0);
                freeBuffIdx = ParticleSender.send(receiver, particles, protocols, freeBuffIdx, bufs, x, y, z);
            }
        } finally {
            for (int i = 0; i < freeBuffIdx; i++) {
                bufs[i].release();
            }
        }
    }*/
}
