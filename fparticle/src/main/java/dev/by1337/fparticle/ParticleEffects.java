package dev.by1337.fparticle;

import dev.by1337.fparticle.particle.*;

public class ParticleEffects {
    public static PrecomputedParticleSource CIRCLE = circle(256, 6, ParticleData.of(ParticleType.FLAME)).compute();

    private void test(){
        final ParticleSource data = new RandomParticleSource(
                CIRCLE.ofParticle(ParticleData.of(ParticleType.SOUL_FIRE_FLAME)),
                CIRCLE.ofParticle(ParticleData.of(ParticleType.CLOUD)),
                CIRCLE.ofParticle(ParticleData.of(ParticleType.FLAME))
        );
    }
    public static ParticleSource circle(int points, double radius, ParticleData particle){
        return new ParticleSource() {
            @Override
            public void doWrite(PacketBuilder writer, double cx, double cy, double cz) {
                for (int i = 0; i < points; i++) {
                    double angle = 2 * Math.PI * i / points;
                    double x = cx + radius * Math.cos(angle);
                    double z = cz + radius * Math.sin(angle);
                    writer.append(particle, x, cy, z);
                }
            }
        };
    }
}
