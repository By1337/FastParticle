package dev.by1337.fparticle.via;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import dev.by1337.fparticle.netty.buffer.ByteBufUtil;
import dev.by1337.fparticle.particle.ParticleData;
import dev.by1337.fparticle.util.Version;
import io.netty.buffer.ByteBuf;
import org.bukkit.Color;
import org.bukkit.Particle;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FastVia {
    private static final int MIN_VERSION = 754;
    private static final int MAX_VERSION = 773;
    private static final ProtocolAdapter[] PROTOCOL_ADAPTERS = new ProtocolAdapter[MAX_VERSION - MIN_VERSION + 1];
    private static final Logger log = LoggerFactory.getLogger(FastVia.class);

    public static boolean write(int version, ByteBuf out, ParticleData particle, double x, double y, double z, float xDist, float yDist, float zDist) {
        Object data = particle.data;
        if (data != null && !(data instanceof Particle.DustOptions)) return false;
        if (version < MIN_VERSION || version > MAX_VERSION) return false;
        int i = version - MIN_VERSION;
        ProtocolAdapter adapter = PROTOCOL_ADAPTERS[i];
        if (adapter == null) return false;
        int id = adapter.adaptParticle(particle.particleId());
        if (id == -1) return false;
        writeLike(version, id, adapter.packetId, out, particle, x, y, z, xDist, yDist, zDist);
        return true;
    }

    /// | Версии  | particle ID   | overrideLimiter | alwaysShow | x/y/z (double) | xDist/yDist/zDist (float) | maxSpeed | count | particle StreamCodec |
    /// | ------- | ------------- | --------------- | ---------- | -------------- | ------------------------- | -------- | ----- | -------------------- |
    /// | 754–758 | `writeInt`    | ✅              | —          | ✅              | ✅                       | ✅      | ✅     | ✅                  |
    /// | 759–765 | `writeVarInt` | ✅              | —          | ✅              | ✅                       | ✅      | ✅     | ✅                  |
    /// | 766–768 | —             | ✅              | —          | ✅              | ✅                       | ✅      | ✅     | ✅                  |
    /// | 769–773 | —             | ✅              | ✅         | ✅              | ✅                       | ✅      | ✅     | ✅                  |
    private static void writeLike(int version, int particleID, int packetId, ByteBuf out, ParticleData particle, double x, double y, double z, float xDist, float yDist, float zDist) {
        ByteBufUtil.writeVarInt1(out, packetId);

        final boolean b;
        if (version >= 769) {
            out.writeBoolean(particle.overrideLimiter);
            b = particle.alwaysShow;
        } else {
            b = particle.overrideLimiter;
        }

        if (version < 759) {
            out.writeInt(particle.particleId());
        } else if (version < 766) {
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
        if (particle.data instanceof Particle.DustOptions dust) {
            if (version <= 767) {
                Color color = dust.getColor();
                out.writeFloat(color.getRed() / 255f);
                out.writeFloat(color.getGreen() / 255f);
                out.writeFloat(color.getBlue() / 255f);
                out.writeFloat(dust.getSize());
            } else if (version <= 773) {//warn: не забыть обновить при обновлении
                out.writeInt(dust.getColor().asRGB());
                out.writeFloat(dust.getSize());
            }
        }
    }

    static {
        try (InputStream in = getMappingsInputStream()) {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(MappingEntry.class, MappingEntry.TYPE_ADAPTER)
                    .create();
            Map<Integer, MappingEntry> mappings = new HashMap<>();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    MappingEntry mappingEntry = gson.fromJson(line, MappingEntry.class);
                    mappings.put(mappingEntry.protocol, mappingEntry);
                }
            }
            MappingEntry current = mappings.get(Version.VERSION.protocolVersion());
            if (current == null) {
                throw new IllegalStateException("no current version found");
            }

            for (MappingEntry value : mappings.values()) {
                int protocol = value.protocol;
                if (protocol > MAX_VERSION || protocol < MIN_VERSION) {
                    log.error("Unsupported protocol: {}", protocol);
                    continue;
                }
                PROTOCOL_ADAPTERS[protocol - MIN_VERSION] = current.createAdapter(value);
            }
            try {
                in.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            Arrays.fill(PROTOCOL_ADAPTERS, null);
        }
    }

    @NotNull
    public static InputStream getMappingsInputStream() {
        ClassLoader loader = FastVia.class.getClassLoader();
        URL url = loader.getResource("fparticle/particles.jsonl");
        if (url == null) {
            throw new RuntimeException("fparticle/particles.jsonl not found");
        }
        try {
            URLConnection connection = url.openConnection();
            connection.setUseCaches(false);
            return connection.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private record ProtocolAdapter(int packetId, int[] mappings) {
        public int adaptParticle(int x) {
            return (x >= mappings.length || x < 0) ? -1 : mappings[x];
        }
    }

    private record MappingEntry(int packetId, int protocol, BiMap<Integer, String> particles) {
        public static final TypeAdapter<MappingEntry> TYPE_ADAPTER = new TypeAdapter<>() {
            @Override
            public void write(JsonWriter out, MappingEntry value) throws IOException {
                out.beginObject();
                out.name("minecraft:level_particles:protocol_id").value(value.packetId());
                out.name("protocol_version").value(value.protocol());
                out.name("entries");
                out.beginObject();
                for (Map.Entry<Integer, String> e : value.particles().entrySet()) {
                    out.name(e.getValue());
                    out.beginObject();
                    out.name("protocol_id").value(e.getKey());
                    out.endObject();
                }
                out.endObject();
                out.endObject();
            }

            @Override
            public MappingEntry read(JsonReader in) throws IOException {
                int packetId = -1;
                int protocol = -1;
                BiMap<Integer, String> particles = HashBiMap.create();

                in.beginObject();
                while (in.hasNext()) {
                    String name = in.nextName();
                    switch (name) {
                        case "protocol_version" -> protocol = in.nextInt();
                        case "minecraft:level_particles:protocol_id" -> packetId = in.nextInt();
                        case "entries" -> {
                            in.beginObject();
                            while (in.hasNext()) {
                                String key = in.nextName();
                                in.beginObject();
                                int id = -1;
                                while (in.hasNext()) {
                                    String sub = in.nextName();
                                    if (sub.equals("protocol_id")) {
                                        id = in.nextInt();
                                    } else {
                                        in.skipValue();
                                    }
                                }
                                in.endObject();
                                if (id != -1) {
                                    particles.put(id, key);
                                }
                            }
                            in.endObject();
                        }
                        default -> in.skipValue();
                    }
                }
                in.endObject();
                return new MappingEntry(packetId, protocol, particles);
            }
        };

        public ProtocolAdapter createAdapter(MappingEntry other) {
            int[] mappings = new int[particles.size()];
            Arrays.fill(mappings, -1);
            for (Integer id : particles.keySet()) {
                String key = particles.get(id);
                mappings[id] = other.particles.inverse().getOrDefault(key, -1);
            }
            return new ProtocolAdapter(other.packetId, mappings);
        }
    }

    // Generates a JSON mapping for particles and protocol IDs.
    // The resulting JSON can later be used to create MappingEntry objects for different protocol versions.
    //
    // IMPORTANT:
    // - The 'generated' parameter must point **exactly to the 'generated' folder** produced by the Minecraft data generator.
    // - The "protocol_version" property is **not automatically added** by this method and must be manually inserted into the JSON.
    //
    // Usage:
    // 1. Run the Minecraft data generator:
    //      java -DbundlerMainClass=net.minecraft.data.Main -jar minecraft_server.jar -all
    // 2. The output files are located in the "generated" folder:
    //    - generated/reports/registries.json -> contains particle type entries
    //    - generated/reports/packets.json -> contains clientbound packet mappings (1.21+)
    //
    // Example of resulting JSON structure (you need to add "protocol_version" manually):
    // {
    //   "minecraft:level_particles:protocol_id": 34,
    //   "protocol_version": 754,  // <-- manually add this
    //   "entries": {
    //     "minecraft:ambient_entity_effect": { "protocol_id": 0 },
    //     "minecraft:angry_villager": { "protocol_id": 1 },
    //     ...
    //   }
    // }
    private static JsonObject export(File generated) throws Exception {
        Gson gson = new Gson();
        JsonObject outJson = new JsonObject();

        JsonObject registries = gson.fromJson(new FileReader(new File(generated, "reports/registries.json")), JsonObject.class);
        File packetsFile = new File(generated, "reports/packets.json");
        if (packetsFile.exists()) {//1.21+
            JsonObject packets = gson.fromJson(new FileReader(new File(generated, "reports/packets.json")), JsonObject.class);
            outJson.add(
                    "minecraft:level_particles:protocol_id", packets
                            .get("play").getAsJsonObject()
                            .get("clientbound").getAsJsonObject()
                            .get("minecraft:level_particles").getAsJsonObject()
                            .get("protocol_id")
            );
        } else {
            outJson.addProperty("minecraft:level_particles:protocol_id", -1);
        }
        outJson.add("entries", registries.get("minecraft:particle_type").getAsJsonObject().get("entries"));

        return outJson;
    }
}
