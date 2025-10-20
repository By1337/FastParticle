package dev.by1337.fparticle.util;

import dev.by1337.fparticle.ParticleType;
import dev.by1337.fparticle.particle.PacketBuilder;
import dev.by1337.fparticle.particle.ParticleData;
import dev.by1337.fparticle.particle.ParticleSource;
import dev.by1337.fparticle.particle.PrecomputedParticleSource;
import dev.by1337.fparticle.particle.options.DustParticleOptions;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class McfunctionReader {

    public static PrecomputedParticleSource read(File file){
        return new ParticleSource() {
            @Override
            public void doWrite(PacketBuilder writer, double baseX, double baseY, double baseZ) {
                try {
                    Map<ParticleData, ParticleData> map = new HashMap<>();
                    Files.lines(file.toPath(), StandardCharsets.UTF_8).forEach(l -> {
                        if (!l.startsWith("particle minecraft:dust")) return;
                        String[] split = l.split(" ");
                        //r g b size x y z xd yd zd speed count
                        //particle[0] minecraft:dust[1] 1[2] 1[3] 1[4] 1[5] ~0[6] ~0[7] ~0[8] 0[9] 0[10] 0[11] 0[12] 1[13]
                        if (split.length < 14) return;
                        float r = Float.parseFloat(split[2]);
                        float g = Float.parseFloat(split[3]);
                        float b = Float.parseFloat(split[4]);
                        float size = Float.parseFloat(split[5]);
                        double x = Double.parseDouble(split[6].replace("~", ""));
                        double y = Double.parseDouble(split[7].replace("~", ""));
                        double z = Double.parseDouble(split[8].replace("~", ""));
                        float xd = Float.parseFloat(split[9]);
                        float yd = Float.parseFloat(split[10]);
                        float zd = Float.parseFloat(split[11]);
                        float speed = Float.parseFloat(split[12]);
                        int count = Integer.parseInt(split[13]);
                        ParticleData dat = ParticleData.builder()
                                .particle(ParticleType.DUST)
                                .data(new DustParticleOptions(r, g, b, size))
                                .xDist(xd)
                                .yDist(yd)
                                .zDist(zd)
                                .count(count)
                                .maxSpeed(speed)
                                .build();
                        dat = map.computeIfAbsent(dat, k -> k);
                        writer.append(dat, x + baseX, y + baseY, z + baseZ);
                    });
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
            }
        }.compute();
    }

}
