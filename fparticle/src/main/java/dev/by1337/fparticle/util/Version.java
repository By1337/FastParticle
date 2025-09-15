package dev.by1337.fparticle.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.NotNull;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;

public class Version {

    @NotNull
    private final String ver;
    private final int protocolVersion;

    public static final Version VERSION;

    Version(@NotNull String version, int protocolVersion) {
        this.ver = version;
        this.protocolVersion = protocolVersion;
    }

    static {
        try (InputStream stream = Bukkit.getServer().getClass().getResourceAsStream("/version.json")) {
            if (stream == null) {
                throw new FileNotFoundException("not found version.json file!");
            } else {
                try (InputStreamReader reader = new InputStreamReader(stream, StandardCharsets.UTF_8)) {
                    Gson gson = new Gson();
                    JsonReader jsonReader = new JsonReader(reader);
                    JsonObject object = gson.getAdapter(JsonObject.class).read(jsonReader);
                    VERSION = new Version(
                            object.get("id").getAsString(),
                            object.get("protocol_version").getAsInt()
                    );
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public @NotNull String ver() {
        return ver;
    }

    public int protocolVersion() {
        return protocolVersion;
    }
}
