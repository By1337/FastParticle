package dev.by1337.fparticle.via;

import dev.by1337.fparticle.netty.buffer.ByteBufUtil;
import dev.by1337.fparticle.particle.MutableParticleData;
import dev.by1337.fparticle.util.Version;
import io.netty.buffer.ByteBuf;

public class FastVia {
    private static final int CURRENT_VERSION = Version.VERSION.protocolVersion();
    public static boolean is1_16_5 = CURRENT_VERSION == 754;

    public static boolean write(int likeA, ByteBuf out, MutableParticleData particle, double x, double y, double z, float xDist, float yDist, float zDist) {
        if (is1_16_5) {
            return switch (likeA) {
                case 765 -> writeLikeA765(out, particle, x, y, z, xDist, yDist, zDist);
                default -> false;
            };
        }
        return false;
    }

    private static boolean writeLikeA765(ByteBuf out, MutableParticleData particle, double x, double y, double z, float xDist, float yDist, float zDist) {
        if (!is1_16_5) return false;
        if (particle.data() != null) return false;
        int id = _754upTo765(particle.particleId());
        if (id == -1) return false;

        ByteBufUtil.writeVarInt1(out, 0x27);
        ByteBufUtil.writeVarInt(out, id);
        out.writeBoolean(particle.overrideLimiter());
        out.writeDouble(x);
        out.writeDouble(y);
        out.writeDouble(z);
        out.writeFloat(xDist);
        out.writeFloat(yDist);
        out.writeFloat(zDist);
        out.writeFloat(particle.maxSpeed());
        out.writeInt(particle.count());
        //this.particle.writeToNetwork(friendlyByteBuf); //has no data
        return true;
    }


    private static int _754upTo765(int particle) {
        if (particle == 2) {
            return -1; // minecraft:barrier не могу так обновить
        }
        if (particle == 3) return 2;
        if (particle >= 15 && particle <= 22) {
            return particle + 1;
        }
        if (particle >= 23 && particle <= 26) {
            return particle + 4;
        }
        if (particle >= 27 && particle <= 34) {
            return particle + 8;
        }
        if (particle >= 35 && particle <= 44) {
            return particle + 9;
        }
        if (particle >= 45 && particle <= 63) {
            return particle + 10;
        }
        if (particle >= 64 && particle <= 66) {
            return particle + 11;
        }
        if (particle >= 67 && particle <= 71) {
            return particle + 12;
        }
        return particle;
    }

}
