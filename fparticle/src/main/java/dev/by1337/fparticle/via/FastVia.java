package dev.by1337.fparticle.via;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dev.by1337.fparticle.netty.buffer.ByteBufUtil;
import dev.by1337.fparticle.particle.MutableParticleData;
import dev.by1337.fparticle.util.Version;
import io.netty.buffer.ByteBuf;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Map;

public class FastVia {
    private static final int CURRENT_VERSION = Version.VERSION.protocolVersion();
    private static final int MIN_VERSION = 755;
    private static final int MAX_VERSION = 773;
    private static final Upper[] uppers = new Upper[MAX_VERSION - MIN_VERSION + 1];
    private static final Logger log = LoggerFactory.getLogger(FastVia.class);

    public static boolean write(int likeA, ByteBuf out, MutableParticleData particle, double x, double y, double z, float xDist, float yDist, float zDist) {
        if (likeA < MIN_VERSION || likeA > MAX_VERSION) return false;
        int i = likeA - MIN_VERSION;
        Upper upper = uppers[i];
        if (upper == null) return false;
        int id = upper.up(particle.particleId());
        if (id == -1) return false;
        writeLike(likeA, id, upper.packetId, out, particle, x, y, z, xDist, yDist, zDist);
        return true;
    }

    private static void writeLike(int version, int particleID, int packetId, ByteBuf out, MutableParticleData particle, double x, double y, double z, float xDist, float yDist, float zDist) {
        ByteBufUtil.writeVarInt1(out, packetId);

        final boolean b;
        if (version >= 769) {
            out.writeBoolean(particle.overrideLimiter());
            b = particle.alwaysShow();
        } else {
            b = particle.overrideLimiter();
        }

        if (version < 759) {
            out.writeInt(particle.particleId());
        } else if (version < 766) {
            ByteBufUtil.writeVarInt(out, particleID);
        }

        writeBody755To768(out, particle, b, x, y, z, xDist, yDist, zDist);

        if (version >= 766) {
            ByteBufUtil.writeVarInt(out, particleID);
        }
    }

    private static void writeBody755To768(ByteBuf out, MutableParticleData particle, boolean b, double x, double y, double z, float xDist, float yDist, float zDist) {
        out.writeBoolean(b);
        out.writeDouble(x);
        out.writeDouble(y);
        out.writeDouble(z);
        out.writeFloat(xDist);
        out.writeFloat(yDist);
        out.writeFloat(zDist);
        out.writeFloat(particle.maxSpeed());
        out.writeInt(particle.count());
    }

    static {
        try {
            final InputStream in = getMappingsInputStream(CURRENT_VERSION);
            if (in != null) {
                Gson gson = new Gson();
                JsonObject object = gson.fromJson(new InputStreamReader(in), JsonObject.class);
                for (Map.Entry<String, JsonElement> entry : object.entrySet()) {
                    String key = entry.getKey();
                    if (key.startsWith("minecraft:")) continue;
                    int protocol = Integer.parseInt(key);
                    if (protocol > MAX_VERSION || protocol < MIN_VERSION) {
                        log.error("Unsupported protocol: {}", protocol);
                    }
                    JsonObject data = entry.getValue().getAsJsonObject();
                    int packetId = data.get("minecraft:level_particles").getAsInt();
                    JsonObject particles = data.get("particles").getAsJsonObject();
                    int[] arr = new int[particles.size()];
                    for (Map.Entry<String, JsonElement> map : particles.entrySet()) {
                        arr[Integer.parseInt(map.getKey())] = map.getValue().getAsInt();
                    }
                    uppers[protocol - MIN_VERSION] = new Upper(packetId, arr);
                }

                try {
                    in.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
        System.out.println(Arrays.toString(uppers));
    }

    @Nullable
    public static InputStream getMappingsInputStream(int version) {
        ClassLoader loader = FastVia.class.getClassLoader();
        URL url = loader.getResource("fparticle/particles_" + version + ".json");
        if (url == null) {
            return null;
        }
        try {
            URLConnection connection = url.openConnection();
            connection.setUseCaches(false);
            return connection.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private record Upper(int packetId, int[] mappings) {
        public int up(int x) {
            return (x >= mappings.length || x < 0) ? -1 : mappings[x];
        }
    }
}
