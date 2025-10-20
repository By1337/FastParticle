package dev.by1337.fparticle.via;

import dev.by1337.fparticle.netty.buffer.ByteBufUtil;
import dev.by1337.fparticle.particle.ParticleData;
import dev.by1337.fparticle.particle.ParticleOption;
import dev.by1337.fparticle.particle.ParticleOptionType;
import io.netty.buffer.ByteBuf;
import org.jetbrains.annotations.Nullable;

/**
 * The {@code ParticleWriter} class provides functionality for serializing particle effect data
 * into a network-friendly format. It supports generating particle data packets for different protocol versions
 * and ensures compatibility by using appropriate mappings and fallback mechanisms.
 * <p>
 * The primary function of this class is to encode a particle effect's properties such as its type, location,
 * velocity, count, and associated options into a form that can be transmitted over the network to render in a game world.
 * <p>
 * Supported protocol versions and particle data structures determine how the particle effect data is serialized.
 * The class handles the complexities of particle mappings, including fallback particle types and their options
 * if the original type is unavailable or unsupported.
 */
public class ParticleWriter {

    /**
     * Writes particle data to the given {@code ByteBuf} output buffer.
     * This method handles determining the correct particle ID and packet ID,
     * applying any necessary mappings and ensuring compatibility with the provided version.
     * It also writes the particle data based on its attributes, such as position and distance.
     *
     * @param version the protocol version to be used for determining particle and packet IDs
     * @param out the output buffer to which particle data will be written
     * @param particle the input particle data containing details such as type and additional options
     * @param x the x-coordinate of the particle's position
     * @param y the y-coordinate of the particle's position
     * @param z the z-coordinate of the particle's position
     * @param xDist the spread or distance along the x-axis
     * @param yDist the spread or distance along the y-axis
     * @param zDist the spread or distance along the z-axis
     * @return the protocol version used for writing, or -1 if the particle data could not be written
     */
    public static int write(int version, ByteBuf out, ParticleData particle, double x, double y, double z, float xDist, float yDist, float zDist) {
        if (version < Mappings.MIN_VERSION || version > Mappings.MAX_VERSION) {
            version = Mappings.NATIVE_PROTOCOL;
        }
        int particleData = Mappings.getParticleId(particle.particle, version);
        ParticleOption option = particle.data;
        if (particleData == -1) {
            var fallback = particle.particle.fallback();
            if (fallback != null) {
                particleData = Mappings.getParticleId(fallback.particle(), version);
                if (particleData == -1) {
                    return -1;
                }
                option = fallback.option();
            } else {
                return -1;
            }
        }
        int particleId = (particleData >> 16) & 0xFFFF;
        int extraId = particleData & 0xFFFF;
        if (extraId == 0xFFFF) {
            option = null;
        } else if (option == null || option.getType().ordinal() != extraId) {
            var type = ParticleOptionType.byId(extraId);
            if (type == null) return -1;
            option = type.def();
        }
        if (option != null && !option.writable(version)) return -1;
        int packetId = Mappings.getPacketId(version);
        if (packetId == -1) return -1;

        writeLike(version, particleId, packetId, out, particle, x, y, z, xDist, yDist, zDist, option);
        return version;
    }

    /**
     * Writes particle data into the provided output buffer following protocol requirements for the given version.
     * This method handles compatibility by setting appropriate particle and packet IDs, applying legacy mappings as needed,
     * and writing the full particle data, including optional attributes, to the buffer.
     *
     * @param version the protocol version used to determine compatibility rules and mappings
     * @param particleID the unique ID of the particle type
     * @param packetId the ID of the packet being written
     * @param out the output buffer where the particle data will be written
     * @param particle the particle data containing details such as type, distance, speed, and count
     * @param x the x-coordinate of the particle's position
     * @param y the y-coordinate of the particle's position
     * @param z the z-coordinate of the particle's position
     * @param xDist the distance or spread along the x-axis
     * @param yDist the distance or spread along the y-axis
     * @param zDist the distance or spread along the z-axis
     * @param option an optional {@link ParticleOption} object that includes additional configuration for the particle
     */
    private static void writeLike(int version, int particleID, int packetId, ByteBuf out, ParticleData particle, double x, double y, double z, float xDist, float yDist, float zDist, @Nullable ParticleOption option) {
        ByteBufUtil.writeVarInt1(out, packetId);

        final boolean b;
        if (version >= 769) {
            out.writeBoolean(particle.overrideLimiter);
            b = particle.alwaysShow;
        } else {
            b = particle.overrideLimiter;
        }

        if (version <= 758) {
            out.writeInt(particleID);
        } else if (version <= 765) {
            ByteBufUtil.writeVarInt(out, particleID);
        }

        out.writeBoolean(b);
        out.writeDouble(x);
        out.writeDouble(y);
        out.writeDouble(z);
        out.writeFloat(xDist);
        out.writeFloat(yDist);
        out.writeFloat(zDist);
        out.writeFloat(particle.maxSpeed);
        out.writeInt(particle.count);

        if (version >= 766) {
            ByteBufUtil.writeVarInt(out, particleID);
        }
        if (option != null) {
            option.write(out, version);
        }
    }

    /// | Версии  | particle ID   | overrideLimiter | alwaysShow | x/y/z (double) | xDist/yDist/zDist (float) | maxSpeed | count | particle StreamCodec |
    /// | ------- | ------------- | --------------- | ---------- | -------------- | ------------------------- | -------- | ----- | -------------------- |
    /// | 754–758 | `writeInt`    | ✅              | —          | ✅              | ✅                       | ✅      | ✅     | ✅                  |
    /// | 759–765 | `writeVarInt` | ✅              | —          | ✅              | ✅                       | ✅      | ✅     | ✅                  |
    /// | 766–768 | —             | ✅              | —          | ✅              | ✅                       | ✅      | ✅     | ✅                  |
    /// | 769–773 | —             | ✅              | ✅         | ✅              | ✅                       | ✅      | ✅     | ✅                  |
}
