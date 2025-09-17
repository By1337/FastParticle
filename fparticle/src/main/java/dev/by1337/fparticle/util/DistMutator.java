package dev.by1337.fparticle.util;

public interface DistMutator {
    void mutate(Vec3f vector);

    default DistMutator and(DistMutator other) {
        return vec3f -> {
            mutate(vec3f);
            other.mutate(vec3f);
        };
    }
}
