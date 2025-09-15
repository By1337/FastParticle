package dev.by1337.fparticle.util;

import org.bukkit.util.Vector;

public interface PosMutator {
    void mutate(Vector vector);

    default PosMutator and(PosMutator other) {
        return vector -> {
            mutate(vector);
            other.mutate(vector);
        };
    }
}
