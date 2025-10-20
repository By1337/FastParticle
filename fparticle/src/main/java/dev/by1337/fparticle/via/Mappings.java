package dev.by1337.fparticle.via;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import dev.by1337.fparticle.BlockType;
import dev.by1337.fparticle.ParticleType;
import dev.by1337.fparticle.particle.ParticleOptionType;
import dev.by1337.fparticle.util.Version;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * The Mappings class provides a centralized utility to map data such as blocks,
 * particles, and packets to protocol versions, allowing for efficient cross-version
 * compatibility functionality. The class initializes mappings data and provides
 * methods to retrieve IDs based on specified protocol versions for various
 * Minecraft components.
 * <p>
 * The class uses static initialization blocks to load and parse mappings data
 * from JSON files and populate arrays for block, particle, and packet mappings.
 * These mappings facilitate the retrieval of protocol-specific IDs.
 * <p>
 * Key constants define the protocol version bounds and the size of mappings arrays.
 */
public class Mappings {
    public static final int NATIVE_PROTOCOL = Version.VERSION.protocolVersion();
    public static final int MIN_VERSION = 754;
    public static final int MAX_VERSION = 773;
    public static final int VERSION_COUNT = MAX_VERSION - MIN_VERSION + 1;
    private static final int[] BLOCKS;
    private static final int[] PARTICLES;
    private static final int[] PACKETS;
    private static final Logger log = LoggerFactory.getLogger(Mappings.class);

    /**
     * Retrieves the block ID for the given block type and protocol version.
     *
     * @param b        the block type for which the ID is to be retrieved
     * @param protocol the protocol version to use for determining the block ID
     * @return the block ID corresponding to the block type and protocol version
     * @throws IllegalArgumentException if the protocol version is unsupported
     */
    public static int getBlockId(BlockType b, int protocol) {
        int versionIndex = protocol - MIN_VERSION;
        if (versionIndex < 0 || versionIndex >= VERSION_COUNT) {
            throw new IllegalArgumentException("Unsupported protocol version: " + protocol);
        }
        int index = b.ordinal() * VERSION_COUNT + versionIndex;
        return BLOCKS[index];
    }

    /**
     * Retrieves the particle ID for the given particle type and protocol version.
     *
     * @param p        the particle type for which the ID is to be retrieved
     * @param protocol the protocol version to use for determining the particle ID
     * @return the particle ID corresponding to the particle type and protocol version
     * @throws IllegalArgumentException if the protocol version is unsupported
     */
    public static int getParticleId(ParticleType p, int protocol) {
        int versionIndex = protocol - MIN_VERSION;
        if (versionIndex < 0 || versionIndex >= VERSION_COUNT) {
            throw new IllegalArgumentException("Unsupported protocol version: " + protocol);
        }
        int index = p.ordinal() * VERSION_COUNT + versionIndex;
        return PARTICLES[index];
    }

    /**
     * Retrieves the packet ID associated with the specified protocol version.
     *
     * @param protocol the protocol version for which the packet ID is to be retrieved
     * @return the packet ID corresponding to the given protocol version
     * @throws IllegalArgumentException if the protocol version is unsupported
     */
    public static int getPacketId(int protocol) {
        int versionIndex = protocol - MIN_VERSION;
        if (versionIndex < 0 || versionIndex >= VERSION_COUNT) {
            throw new IllegalArgumentException("Unsupported protocol version: " + protocol);
        }
        return PACKETS[versionIndex];
    }

    static {
        if (Mappings.NATIVE_PROTOCOL > MAX_VERSION || Mappings.NATIVE_PROTOCOL < MIN_VERSION) {
            throw new IllegalArgumentException("Unsupported protocol version: " + Mappings.NATIVE_PROTOCOL);
        }
        BLOCKS = new int[VERSION_COUNT * BlockType.SIZE];
        Gson gson = new Gson();
        try (InputStreamReader in = new InputStreamReader(getMappingsInputStream("fparticle/blocks.json"))) {

            Map<String, Map<Integer, Integer>> map = new HashMap<>();
            JsonObject o = gson.fromJson(in, JsonObject.class);
            for (Map.Entry<String, JsonElement> block : o.entrySet()) {
                Map<Integer, Integer> protocol2id = new HashMap<>();
                for (Map.Entry<String, JsonElement> version : block.getValue().getAsJsonObject().entrySet()) {
                    protocol2id.put(Integer.parseInt(version.getKey()), version.getValue().getAsInt());
                }
                map.put(block.getKey(), protocol2id);
            }

            Map<Integer, Integer> fallback = map.get("minecraft:barrier");

            for (String block : map.keySet()) {
                Map<Integer, Integer> protocol2id = map.get(block);
                BlockType b = BlockType.getById(block);
                if (b == null) {
                    log.error("Unknown block: {}", block);
                    continue;
                }
                for (int i = MIN_VERSION; i <= MAX_VERSION; i++) {
                    Integer blockId = protocol2id.get(i);
                    if (blockId == null || blockId == -1) {
                        blockId = fallback.get(i);
                    }
                    int index = b.ordinal() * VERSION_COUNT + (i - MIN_VERSION);
                    BLOCKS[index] = blockId;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        PARTICLES = new int[VERSION_COUNT * ParticleType.SIZE];
        Arrays.fill(PARTICLES, -1);

        try (InputStreamReader in = new InputStreamReader(getMappingsInputStream("fparticle/particles.json"))) {
            Map<String, Map<Integer, Map<String, String>>> map = gson.fromJson(in, new TypeToken<Map<String, Map<Integer, Map<String, String>>>>() {
            }.getType());

            for (String particle : map.keySet()) {
                Map<Integer, Map<String, String>> protocol2data = map.get(particle);
                ParticleType particleType = ParticleType.byId(particle);

                if (particleType == null) {
                    log.error("Unknown particle: {}", particle);
                    continue;
                }
                for (int i = MIN_VERSION; i <= MAX_VERSION; i++) {
                    Map<String, String> data = protocol2data.get(i);
                    if (data == null) continue;

                    int protocolId = Integer.parseInt(data.get("protocol_id"));
                    String extra = data.get("extra");
                    if (extra == null) extra = "~";

                    final int extraId;
                    if (extra.equals("~")) {
                        extraId = 0xFFFF;
                    } else {
                        var type = ParticleOptionType.byName(extra);
                        if (type == null) {
                            log.error("Unknown extra: {} for particle: {}", extra, particle);
                            continue;
                        }
                        extraId = type.ordinal();
                    }
                    int value = (protocolId << 16) | (extraId & 0xFFFF);

                    int index = particleType.ordinal() * VERSION_COUNT + (i - MIN_VERSION);
                    PARTICLES[index] = value;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        PACKETS = new int[VERSION_COUNT];
        Arrays.fill(PACKETS, -1);
        try (InputStreamReader in = new InputStreamReader(getMappingsInputStream("fparticle/packets.json"))) {
            Map<Integer, Integer> map = gson.fromJson(in, new TypeToken<Map<Integer, Integer>>() {
            }.getType());
            map.forEach((key, value) -> {
                if (key < MIN_VERSION || key > MAX_VERSION) {
                    log.error("Unsupported protocol version: {}", key);
                    return;
                }
                PACKETS[key - MIN_VERSION] = value;
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @NotNull
    private static InputStream getMappingsInputStream(String s) {
        ClassLoader loader = ParticleWriter.class.getClassLoader();
        URL url = loader.getResource(s);
        if (url == null) {
            throw new RuntimeException(s + " not found");
        }
        try {
            URLConnection connection = url.openConnection();
            connection.setUseCaches(false);
            return connection.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
