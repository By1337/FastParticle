package dev.by1337.fparticle.particle;

import org.jetbrains.annotations.Contract;

/**
 * Abstract base class for defining reusable particle effect patterns.
 * <p>
 * ParticleSource provides a composable pattern-based approach to particle generation.
 * Instead of manually spawning particles repeatedly, you define a pattern once and reuse it
 * across multiple locations and contexts.
 * <p>
 * Implementations must override {@link #doWrite(ParticlePacketBuilder, double, double, double)}
 * to define the particle generation logic. The pattern can then be sent to players using
 * {@code FParticle.send(player, particleSource, x, y, z)}.
 * <p>
 * Example usage:
 * <pre>{@code
 * ParticleSource sphere = new ParticleSource() {
 *     private final ParticleData particle = ParticleData.builder()
 *         .particle(Particle.REDSTONE)
 *         .data(new Particle.DustOptions(Color.AQUA, 1f))
 *         .build();
 *
 *     @Override
 *     public void doWrite(ParticlePacketBuilder writer, double baseX, double baseY, double baseZ) {
 *         for (int i = 0; i < 100; i++) {
 *             // Generate sphere coordinates
 *             writer.write(particle, baseX + x, baseY + y, baseZ + z);
 *         }
 *     }
 * };
 *
 * // Send to player
 * FParticle.send(player, sphere, location.getX(), location.getY(), location.getZ());
 * }</pre>
 *
 * @see ParticlePacketBuilder
 * @see dev.by1337.fparticle.FParticle
 */
public abstract class ParticleSource {

    /**
     * Creates a {@link ParticlePacketBuilder} positioned at the specified coordinates.
     * <p>
     * This method is primarily used internally by the FParticle API. When the builder
     * is encoded, it will invoke {@link #doWrite(ParticlePacketBuilder, double, double, double)}
     * with the provided coordinates.
     *
     * @param x the X coordinate
     * @param y the Y coordinate
     * @param z the Z coordinate
     * @return a new ParticlePacketBuilder instance
     */
    @Contract(pure = true)
    public ParticlePacketBuilder writerAt(double x, double y, double z) {
        return new ParticlePacketBuilder() {
            @Override
            protected void onWrite() {
                doWrite(this, x, y, z);
            }
        };
    }

    /**
     * Defines the particle generation pattern for this source.
     * <p>
     * Implementations should use {@code writer.write()} to spawn individual particles
     * at positions relative to the base coordinates. All particles written to the same
     * builder will be batched into a single network packet for optimal performance.
     *
     * @param writer the packet builder to write particles to
     * @param baseX the base X coordinate
     * @param baseY the base Y coordinate
     * @param baseZ the base Z coordinate
     */
    public abstract void doWrite(ParticlePacketBuilder writer, double baseX, double baseY, double baseZ);

    /**
     * Creates a new ParticleSource with positional offset applied.
     * <p>
     * The returned source will generate the same particle pattern, but shifted by
     * the specified offset. This is useful for creating multiple instances of the
     * same pattern at different locations.
     * <p>
     * Example:
     * <pre>{@code
     * ParticleSource sphere = ...;
     * ParticleSource shiftedSphere = sphere.shift(0, 10, 0); // 10 blocks higher
     * }</pre>
     *
     * @param x the X offset
     * @param y the Y offset
     * @param z the Z offset
     * @return a new ParticleSource with the offset applied
     */
    @Contract(pure = true, value = "_, _, _ -> new")
    public ParticleSource shift(double x, double y, double z) {
        ParticleSource sub = this;
        return new ParticleSource() {
            @Override
            public void doWrite(ParticlePacketBuilder writer, double baseX, double baseY, double baseZ) {
                sub.doWrite(writer, x + baseX, y + baseY, z + baseZ);
            }
        };
    }

    /**
     * Combines this source with other sources into a composite pattern.
     * <p>
     * The returned source will execute all patterns sequentially at the same base
     * coordinates. All particles from all sources will be batched into a single
     * network packet.
     * <p>
     * Example:
     * <pre>{@code
     * ParticleSource sphere = ...;
     * ParticleSource circle = ...;
     * ParticleSource combined = sphere.and(circle); // Both patterns at same location
     * ParticleSource twoSpheres = sphere.and(sphere.shift(0, 10, 0)); // Two spheres
     * }</pre>
     *
     * @param other additional sources to combine with this one
     * @return a new composite ParticleSource
     */
    @Contract(pure = true, value = "_ -> new")
    public ParticleSource and(ParticleSource... other) {
        if (other.length == 0) return this;
        if (other.length == 1) return of(this, other[0]);

        ParticleSource[] arr = new ParticleSource[other.length + 1];
        arr[0] = this;
        System.arraycopy(other, 0, arr, 1, other.length);
        return of(arr);
    }

    /**
     * Creates a composite ParticleSource from multiple sources.
     * <p>
     * The returned source will execute all provided sources sequentially at the
     * same base coordinates. This is equivalent to chaining multiple {@link #and(ParticleSource...)}
     * calls but more efficient for large numbers of sources.
     * <p>
     * Example:
     * <pre>{@code
     * ParticleSource multi = ParticleSource.of(source1, source2, source3);
     * }</pre>
     *
     * @param particleSources the sources to combine
     * @return a new composite ParticleSource
     */
    @Contract(pure = true)
    public static ParticleSource of(ParticleSource... particleSources) {
        return new ParticleSource() {
            @Override
            public void doWrite(ParticlePacketBuilder writer, double baseX, double baseY, double baseZ) {
                for (ParticleSource particleSource : particleSources) {
                    particleSource.doWrite(writer, baseX, baseY, baseZ);
                }
            }
        };
    }
}
