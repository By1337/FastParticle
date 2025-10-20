package dev.by1337.fparticle.util;

import dev.by1337.fparticle.FParticleUtil;
import org.jetbrains.annotations.ApiStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;

@ApiStatus.Internal
public class NMSLoader {
    private static final String LAST_SUPPORTED_VERSION = "1.21.10";
    private static final Logger log = LoggerFactory.getLogger("FParticle");

    public static FParticleUtil.NmsAccessor load() {

        String version = Version.VERSION.id().replace(".", "_");
        //dev.by1337.fparticle.NMSUtilV1_17_1
        Class<?> cl;
        try {
            cl = Class.forName(String.format("dev.by1337.fparticle.NMSUtilV%s", version), true, NMSLoader.class.getClassLoader());
        } catch (Exception e) {
            log.warn("Failed to load nms for {}. {}", version, e.getMessage());
            try {
                cl = Class.forName(String.format("dev.by1337.fparticle.NMSUtilV%s", LAST_SUPPORTED_VERSION.replace(".", "_")), true, NMSLoader.class.getClassLoader());
            } catch (Exception ex) {
                throw new RuntimeException("Failed to load nms for " + Version.VERSION.id(), ex);
            }
        }
        try {
            var v = cl.getDeclaredConstructor();
            v.setAccessible(true);
            return (FParticleUtil.NmsAccessor) v.newInstance();
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
