package dev.by1337.fparticle;

import com.viaversion.viaversion.api.Via;
import dev.by1337.fparticle.handler.ParticleSender;
import dev.by1337.fparticle.particle.MutableParticleData;
import dev.by1337.fparticle.particle.ParticleIterable;
import dev.by1337.fparticle.particles.SingleParticleBatch;
import dev.by1337.fparticle.util.Version;
import io.netty.buffer.ByteBuf;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

public class FParticle extends JavaPlugin {
    private static FParticleHooker flusher;
    public static final NMSUtil NMS_UTIL = create();

    @Override
    public void onLoad() {
    }

    @Override
    public void onEnable() {
        flusher = new FParticleHooker(this, "fparticle");
    }

    @Override
    public void onDisable() {
        flusher.close();
        flusher = null;
    }

    public static MutableParticleData newParticle() {
        return NMS_UTIL.newParticle();
    }

    public static ParticleSender getReceiver(Player player) {
        return flusher.getReceiver(player);
    }
    private static void sendAll(ParticleIterable particle){
        sendParticle(Bukkit.getOnlinePlayers().stream().map(FParticle::getReceiver).toList(), particle);
    }
    public static void sendParticle(Collection<ParticleSender> receivers, ParticleIterable particles) {
        final int[] protocols = new int[32];
        int freeBuffIdx = 0;
        final ByteBuf[] bufs = new ByteBuf[32];
        try {
            for (ParticleSender receiver : receivers) {
                int protocol = receiver.protocolVersion();
                int idx = protocol % 32;
                int packed = protocols[idx];
                int storedProtocol = packed & 0xFFFFFF;
                if (packed == 0) {
                    ByteBuf buf = receiver.writeAndGetSlice(particles);
                    if (buf != null) {
                        bufs[freeBuffIdx] = buf;
                        protocols[idx] = ((freeBuffIdx & 0xFF) << 24) | (protocol & 0xFFFFFF);
                        freeBuffIdx++;
                    }
                } else if (storedProtocol == protocol) {
                    int bufIdx = (packed >>> 24) & 0xFF;
                    ByteBuf buf = bufs[bufIdx];
                    receiver.write(buf.retainedDuplicate());
                } else {
                    receiver.write(particles);
                }
            }
        } finally {
            for (int i = 0; i < freeBuffIdx; i++) {
                bufs[i].release();
            }
        }
    }

    private void timer(Runnable task) {
        getServer().getScheduler().runTaskTimerAsynchronously(this, task, 1, 1);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        if (args.length == 0) {
            var particle = NMS_UTIL.newParticle();
            particle.particle(Particle.DRAGON_BREATH);

            var location = player.getLocation().clone();
            if (true){
                for (int i = 0; i < 30; i++) {
                    double minX = location.getX() - 5;
                    double minY = location.getY() - 5;
                    double minZ = location.getZ() - 5;

                    double maxX = location.getX() + 5;
                    double maxY = location.getY() + 5;
                    double maxZ = location.getZ() + 5;

                    long nanos = System.nanoTime();
                    for (double y = minY; y <= maxY; y++) {
                        double finalY = y;
                        timer(() -> sendAll(particle.pos(minX, finalY, minZ)));
                        timer(() -> sendAll(particle.pos(maxX, finalY, minZ)));
                        timer(() -> sendAll(particle.pos(minX, finalY, maxZ)));
                        timer(() -> sendAll(particle.pos(maxX, finalY, maxZ)));
                    }
                    for (double x = minX; x <= maxX; x++) {
                        double finalX = x;
                        timer(() -> sendAll(particle.pos(finalX, maxY, minZ)));
                        timer(() -> sendAll(particle.pos(finalX, minY, minZ)));
                        timer(() -> sendAll(particle.pos(finalX, maxY, maxZ)));
                        timer(() -> sendAll(particle.pos(finalX, minY, maxZ)));
                    }
                    for (double z = minZ; z <= maxZ; z++) {
                        double finalZ = z;
                        timer(() -> sendAll(particle.pos(minX, minY, finalZ)));
                        timer(() -> sendAll(particle.pos(maxX, minY, finalZ)));
                        timer(() -> sendAll(particle.pos(minX, maxY, finalZ)));
                        timer(() -> sendAll(particle.pos(maxX, maxY, finalZ)));
                    }
                }

                return true;
            }
            //ParticleSender receiver = getReceiver(player);
            new BukkitRunnable() {
                double r = 1;

                @Override
                public void run() {
                    for (int i = 0; i < 30; i++) {
                        double minX = location.getX() - r;
                        double minY = location.getY() - r;
                        double minZ = location.getZ() - r;

                        double maxX = location.getX() + r;
                        double maxY = location.getY() + r;
                        double maxZ = location.getZ() + r;
                        r += 0.25;
                        if (r > 15) {
                            r = 1;
                        }
                        long nanos = System.nanoTime();
                        for (double y = minY; y <= maxY; y++) {
                            sendAll(particle.pos(minX, y, minZ));
                            sendAll(particle.pos(maxX, y, minZ));
                            sendAll(particle.pos(minX, y, maxZ));
                            sendAll(particle.pos(maxX, y, maxZ));
                        }
                        for (double x = minX; x <= maxX; x++) {
                            sendAll(particle.pos(x, maxY, minZ));
                            sendAll(particle.pos(x, minY, minZ));
                            sendAll(particle.pos(x, maxY, maxZ));
                            sendAll(particle.pos(x, minY, maxZ));
                        }
                        for (double z = minZ; z <= maxZ; z++) {
                            sendAll(particle.pos(minX, minY, z));
                            sendAll(particle.pos(maxX, minY, z));
                            sendAll(particle.pos(minX, maxY, z));
                            sendAll(particle.pos(maxX, maxY, z));
                        }
                    }
                    // System.out.println(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanos));
                }
            }.runTaskTimerAsynchronously(this, 1, 1);
        } else {
            //  System.out.println("START OLD");

//            ParticleList particles = ParticleList.builder().write((particle, writer) -> {
//                particle.particle(Particle.DRAGON_BREATH);
//                double radius = 3.5;
//                double yOffset = 3;
//                int points = 256;
//                for (int i = 0; i < points; i++) {
//                    double angle = 2 * Math.PI * i / points;
//                    double x = radius * Math.cos(angle);
//                    double z = radius * Math.sin(angle);
//                    writer.accept(particle.pos(x, yOffset, z));
//                }
//            }).posMutator(vec -> vec.add(player.getLocation().toVector())).build();
            SingleParticleBatch particles = SingleParticleBatch.create(newParticle().particle(Particle.DRAGON_BREATH), spawn -> {
                double radius = 3.5;
                double yOffset = 3;
                int points = 256;
                for (int i = 0; i < points; i++) {
                    double angle = 2 * Math.PI * i / points;
                    double x = radius * Math.cos(angle);
                    double z = radius * Math.sin(angle);
                    spawn.at(x, yOffset, z);
                }
            }).posMutator(vec -> vec.add(player.getLocation().toVector()));
           /* SingleDistParticleBatch particles = SingleDistParticleBatch.create(MutableParticleData.createNew().particle(Particle.SOUL).maxSpeed(0.2f), spawner -> {
                var random = new Random();
                double radius = 6;
                for (int i = 0; i < 256; i++) {
                    double phi = random.nextDouble() * Math.PI * 2;
                    double theta = Math.acos(2 * random.nextDouble() - 1);

                    double sinTheta = Math.sin(theta);

                    double x = radius * sinTheta * Math.cos(phi);
                    double y = radius * sinTheta * Math.sin(phi);
                    double z = radius * Math.cos(theta);

                    float offsetX = (float) (-x / radius);
                    float offsetY = (float) (-y / radius);
                    float offsetZ = (float) (-z / radius);

                    spawner.at(x, y, z, offsetX, offsetY, offsetZ);
                }
            }).posMutator(vec -> vec.add(player.getLocation().toVector()));*/
          //  ParticleSender receiver = getReceiver(player);
            // receiver.write(particles);
            // System.out.println(particles.size());
            // System.out.println(particles.sizeBytes());
           // var particle = MutableParticleData.createNew().particle(Particle.SOUL).maxSpeed(0.2f);
            new BukkitRunnable() {
                @Override
                public void run() {
                    sendAll(particles);
                }
            }.runTaskTimerAsynchronously(this, 1, 1);
        }

        return true;
    }


    private static NMSUtil create() {
        return switch (Version.VERSION.ver()) {
            case "1.16.5" -> new NMSUtilV1165();
            default -> throw new IllegalStateException("Unknown NMS Version");
        };
    }
}
//             new BukkitRunnable() {
//                double r = 1;
//
//                @Override
//                public void run() {
//                    for (int i = 0; i < 30; i++) {
//                        double minX = location.getX() - r;
//                        double minY = location.getY() - r;
//                        double minZ = location.getZ() - r;
//
//                        double maxX = location.getX() + r;
//                        double maxY = location.getY() + r;
//                        double maxZ = location.getZ() + r;
//                        r += 0.25;
//                        if (r > 15) {
//                            r = 1;
//                        }
//                        long nanos = System.nanoTime();
//                        for (double y = minY; y <= maxY; y++) {
//                            player.spawnParticle(Particle.DRAGON_BREATH, minX, y, minZ, 0);
//                            player.spawnParticle(Particle.DRAGON_BREATH, maxX, y, minZ, 0);
//                            player.spawnParticle(Particle.DRAGON_BREATH, minX, y, maxZ, 0);
//                            player.spawnParticle(Particle.DRAGON_BREATH, maxX, y, maxZ, 0);
//                        }
//                        for (double x = minX; x <= maxX; x++) {
//                            player.spawnParticle(Particle.DRAGON_BREATH, x, maxY, minZ, 0);
//                            player.spawnParticle(Particle.DRAGON_BREATH, x, minY, minZ, 0);
//                            player.spawnParticle(Particle.DRAGON_BREATH, x, maxY, maxZ, 0);
//                            player.spawnParticle(Particle.DRAGON_BREATH, x, minY, maxZ, 0);
//                        }
//                        for (double z = minZ; z <= maxZ; z++) {
//                            player.spawnParticle(Particle.DRAGON_BREATH, minX, minY, z, 0);
//                            player.spawnParticle(Particle.DRAGON_BREATH, maxX, minY, z, 0);
//                            player.spawnParticle(Particle.DRAGON_BREATH, minX, maxY, z, 0);
//                            player.spawnParticle(Particle.DRAGON_BREATH, maxX, maxY, z, 0);
//                        }
//                    }
//                    //  System.out.println(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanos));
//                }
//            }.runTaskTimerAsynchronously(this, 1, 1)