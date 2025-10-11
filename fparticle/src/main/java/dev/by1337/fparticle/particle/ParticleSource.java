package dev.by1337.fparticle.particle;

import org.jetbrains.annotations.Contract;

public abstract class ParticleSource {


    public ParticleOutputStream writerAt(double x, double y, double z) {
        return new ParticleOutputStream(x, y, z, w -> write(w, 0, 0, 0));
    }

    public abstract void write(ParticleOutputStream writer, double baseX, double baseY, double baseZ);

    @Contract(pure = true, value = "_, _, _ -> new")
    public ParticleSource shift(double x, double y, double z) {
        ParticleSource sub = this;
        return new ParticleSource() {
            @Override
            public void write(ParticleOutputStream writer, double baseX, double baseY, double baseZ) {
                sub.write(writer, x + baseX, y + baseY, z + baseZ);
            }
        };
    }

    @Contract(pure = true, value = "_ -> new")
    public ParticleSource and(ParticleSource... other) {
        ParticleSource[] arr = new ParticleSource[other.length + 1];
        arr[0] = this;
        System.arraycopy(other, 0, arr, 1, other.length);
        return of(arr);
    }

    public static ParticleSource of(ParticleSource... particleSources) {
        return new ParticleSource() {
            @Override
            public ParticleOutputStream writerAt(double x, double y, double z) {
                return new ParticleOutputStream(x, y, z, w -> write(w, 0, 0, 0));
            }

            @Override
            public void write(ParticleOutputStream writer, double baseX, double baseY, double baseZ) {
                for (ParticleSource particleSource : particleSources) {
                    particleSource.write(writer, baseX, baseY, baseZ);
                }
            }
        };
    }
}
