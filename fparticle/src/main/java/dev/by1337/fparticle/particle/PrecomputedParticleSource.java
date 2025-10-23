package dev.by1337.fparticle.particle;

import it.unimi.dsi.fastutil.floats.FloatArrayList;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PrecomputedParticleSource extends ParticleSource {
    private final float[] positions;
    private @Nullable
    final ParticleData[] particles;
    private final int size;
    private final ParticleData single;

    public PrecomputedParticleSource(float[] positions, ParticleData single) {
        this.positions = positions;
        this.single = single;
        particles = null;
        size = positions.length / 7;
    }

    public PrecomputedParticleSource(ParticleSource upped, @Nullable ParticleData single) {
        this.single = single;
        FloatArrayList floats = new FloatArrayList((1 + 3 + 3) * 1024);
        List<ParticleData> particles = new ArrayList<>(32);

        upped.doWrite(new PacketBuilder() {
            @Override
            public void append(ParticleData particle, double x, double y, double z, float xDist, float yDist, float zDist) {
                int index = particles.indexOf(particle);
                if (index == -1) {
                    index = particles.size();
                    particles.add(particle);
                }
                floats.add(index);
                floats.add((float) x);
                floats.add((float) y);
                floats.add((float) z);
                floats.add(xDist);
                floats.add(yDist);
                floats.add(zDist);
            }
        }, 0, 0, 0);

        if (single == null) {
            this.particles = particles.toArray(new ParticleData[0]);
        } else {
            this.particles = null;
        }
        this.positions = floats.toFloatArray();
        size = positions.length / 7;
    }

    @Override
    public void doWrite(PacketBuilder writer, double baseX, double baseY, double baseZ) {
        for (int i = 0; i < size; i++) {
            int offset = i * 7;
            ParticleData particle;
            if (single != null) {
                particle = single;
            } else {
                int particleIndex = (int) positions[offset];
                particle = particles[particleIndex];
            }
            writer.append(
                    particle,
                    (double) positions[offset + 1] + baseX,
                    (double) positions[offset + 2] + baseY,
                    (double) positions[offset + 3] + baseZ,
                    positions[offset + 4],
                    positions[offset + 5],
                    positions[offset + 6]
            );
        }
    }

    @Contract(pure = true, value = "_, -> new")
    public PrecomputedParticleSource ofParticle(ParticleData particle) {
        return new PrecomputedParticleSource(positions, particle);
    }

    @Override
    public PrecomputedParticleSource compute() {
        return this;
    }
}
