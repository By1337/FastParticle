package dev.by1337.fparticle.netty;

import dev.by1337.fparticle.FParticleUtil;
import dev.by1337.fparticle.util.Version;
import org.bukkit.plugin.java.PluginClassLoader;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.Unsafe;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;
import java.util.NoSuchElementException;
import java.util.Objects;

@ApiStatus.Internal
public class NMSLoader {
    private static final String LAST_SUPPORTED_VERSION = "1.16.5";
    private static final Logger log = LoggerFactory.getLogger("FParticle");

    public static void load(URLClassLoader who) {
        try (InputStream in = getNms()) {
            if (in == null) {
                throw new NoSuchElementException("NMS not found for " + Version.VERSION.id());
            }
            File nmsDir = new File("./libraries/fparticle/nms");
            nmsDir.mkdirs();
            File jar = new File(nmsDir, Version.VERSION.id() + ".jar");
            if (jar.exists()) {
                addToClassPath(who, jar);
            } else {
                try (FileOutputStream out = new FileOutputStream(jar)) {
                    in.transferTo(out);
                }
                addToClassPath(who, jar);
            }
            Class<?> cl = Class.forName(new String(
                    new byte[]{'d','e','v','.','b','y','1','3','3','7','.','f','p','a','r','t','i','c','l','e','.','I','n','i','t','i','a','t','o','r'}
            ), true, who);
            Field field = cl.getField("NMS");
            FParticleUtil.setInstance((FParticleUtil.NmsAccessor) field.get(null));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void addToClassPath(URLClassLoader who, File jar) {
        try {
            var lookup = unsafeLookup();
            Class<?> urlClassType = Class.forName("java.net.URLClassLoader");

            var mn = lookup.findVirtual(urlClassType, "addURL", MethodType.methodType(Void.TYPE, URL.class));
            mn.invoke(who, jar.toURI().toURL());
        } catch (Error e) {
            throw e;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static InputStream getNms() {
        return Objects.requireNonNullElseGet(
                getInputStream(Version.VERSION.id()),
                () -> {
                    log.warn("NMS for version {} not found — falling back to {}",
                            Version.VERSION.id(), LAST_SUPPORTED_VERSION);
                    return getInputStream(LAST_SUPPORTED_VERSION);
                }
        );
    }

    @Nullable
    private static InputStream getInputStream(String version) {
        ClassLoader loader = NMSLoader.class.getClassLoader();
        URL url = loader.getResource("nms/v" + version.replace(".", "_") + ".jar");
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

    private static MethodHandles.Lookup unsafeLookup() {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            Unsafe unsafe = (Unsafe) theUnsafe.get(null);
            Field implLookup = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");

            return (MethodHandles.Lookup) unsafe.getObject(unsafe.staticFieldBase(implLookup), unsafe.staticFieldOffset(implLookup));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Unsafe theUnsafe() {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            return (Unsafe) theUnsafe.get(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
