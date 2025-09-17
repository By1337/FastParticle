package dev.by1337.fparticle.particle.impl;

import dev.by1337.fparticle.particle.ParticleSource;
import dev.by1337.fparticle.particle.ParticleWriter;
import io.netty.buffer.ByteBuf;

import java.util.NoSuchElementException;

public class ParticleGroup implements ParticleSource {
    private final ParticleSource[] group;
    private final int size;

    public ParticleGroup(ParticleSource... group) {
        this.group = group;
        int s = 0;
        for (ParticleSource particleSource : group) {
            s += particleSource.size();
        }
        this.size = s;
    }

    public static ParticleGroup of(ParticleSource... group) {
        return new ParticleGroup(group);
    }

    @Override
    public ParticleWriter writer() {
        return new ParticleWriter() {
            final int count = group.length;
            int idx = 0;
            ParticleWriter last = null;

            @Override
            public void write(ByteBuf buf) {
                if (last == null || !last.hasNext()) {
                    if (idx == count) throw new NoSuchElementException();
                    last = group[idx++].writer();
                }
                last.write(buf);
            }

            @Override
            public boolean hasNext() {
                return idx < count || (last != null && last.hasNext());
            }
        };
    }

    @Override
    public int size() {
        return size;
    }
}
