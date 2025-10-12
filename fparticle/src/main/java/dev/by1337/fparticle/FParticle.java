package dev.by1337.fparticle;

import dev.by1337.fparticle.particle.ParticleSource;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Main API entry point for sending particle effects to players.
 * <p>
 * This class provides static methods for sending {@link ParticleSource} patterns to one or more players.
 * All particles from a single source are batched into a single network packet per player for optimal performance.
 * <p>
 * Example usage:
 * <pre>{@code
 * ParticleSource effect = new ParticleSource() {
 *     @Override
 *     public void doWrite(ParticlePacketBuilder writer, double baseX, double baseY, double baseZ) {
 *         // Define particle pattern
 *         writer.write(particleData, baseX, baseY, baseZ);
 *     }
 * };
 *
 * // Send to single player
 * FParticle.send(player, effect, x, y, z);
 *
 * // Send to multiple players
 * FParticle.send(players, effect, x, y, z);
 *
 * // Use in Stream API
 * players.stream()
 *     .filter(Player::isOnline)
 *     .forEach(FParticle.send(effect, x, y, z));
 * }</pre>
 *
 * @see ParticleSource
 * @see dev.by1337.fparticle.particle.ParticlePacketBuilder
 */
public class FParticle {

    /**
     * Sends a particle effect to a single player.
     * <p>
     * The particle pattern will be rendered at the specified world coordinates.
     * All particles from the source are batched into a single network packet.
     *
     * @param receiver the player who will see the particles
     * @param particle the particle pattern to render
     * @param x the X world coordinate
     * @param y the Y world coordinate
     * @param z the Z world coordinate
     * @throws NullPointerException if receiver or particle is null
     */
    public static void send(@NotNull Player receiver, @NotNull ParticleSource particle, double x, double y, double z) {
        FParticleUtil.send(receiver, particle.writerAt(x, y, z));
    }

    /**
     * Sends a particle effect to multiple players.
     * <p>
     * @param receivers the collection of players who will see the particles
     * @param particle the particle pattern to render
     * @param x the X world coordinate
     * @param y the Y world coordinate
     * @param z the Z world coordinate
     * @throws NullPointerException if receivers or particle is null
     */
    public static void send(@NotNull Collection<Player> receivers, @NotNull ParticleSource particle, double x, double y, double z) {
        receivers.forEach(p -> FParticleUtil.send(p, particle.writerAt(x, y, z)));
    }

    /**
     * Sends a particle effect to players from a stream.
     * <p>
     * This method is designed for use with Java Stream API. Each player receives
     * their own packet with all particles batched together.
     * <p>
     * Example:
     * <pre>{@code
     * Bukkit.getOnlinePlayers().stream()
     *     .filter(p -> p.getWorld().equals(world))
     *     .forEach(FParticle.send(effect, x, y, z));
     * }</pre>
     *
     * @param receivers the stream of players who will see the particles
     * @param particle the particle pattern to render
     * @param x the X world coordinate
     * @param y the Y world coordinate
     * @param z the Z world coordinate
     * @throws NullPointerException if receivers or particle is null
     */
    public static void send(@NotNull Stream<Player> receivers, @NotNull ParticleSource particle, double x, double y, double z) {
        receivers.forEach(p -> FParticleUtil.send(p, particle.writerAt(x, y, z)));
    }

    /**
     * Creates a {@link Consumer} that sends particles to a player.
     * <p>
     * This method is useful for functional programming patterns, particularly
     * with Stream API. The returned consumer can be passed to {@code forEach()}
     * or other higher-order functions.
     * <p>
     * Example:
     * <pre>{@code
     * Consumer<Player> sendEffect = FParticle.send(particle, x, y, z);
     *
     * // Use with stream
     * players.stream()
     *     .filter(Player::isOnline)
     *     .forEach(sendEffect);
     *
     * // Or directly
     * players.forEach(sendEffect);
     * }</pre>
     *
     * @param particle the particle pattern to render
     * @param x the X world coordinate
     * @param y the Y world coordinate
     * @param z the Z world coordinate
     * @return a consumer that sends the particle effect to a player
     * @throws NullPointerException if particle is null
     */
    public static @NotNull Consumer<Player> send(@NotNull ParticleSource particle, double x, double y, double z) {
        return p -> FParticleUtil.send(p, particle.writerAt(x, y, z));
    }
}
