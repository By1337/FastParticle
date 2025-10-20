package dev.by1337.fparticle;

import dev.by1337.fparticle.netty.FParticleManager;
import dev.by1337.fparticle.particle.ParticleData;
import dev.by1337.fparticle.particle.ParticlePacketBuilder;
import dev.by1337.fparticle.particle.ParticleSource;
import dev.by1337.fparticle.particle.options.BlockParticleOption;
import dev.by1337.fparticle.particle.options.DustParticleOptions;
import io.netty.channel.Channel;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;


public class FParticlePlugin extends JavaPlugin {
    private static FParticleManager flusher;

    private static final ParticleSource SPHERE = new ParticleSource() {
        private final Random random = new Random();
        private final ParticleData particle = ParticleData.builder()
                .maxSpeed(0.2f)
                .data(new DustParticleOptions(Color.AQUA.asRGB(), 1.f))
                .particle(ParticleType.DUST)
                .build();

        @Override
        public void doWrite(ParticlePacketBuilder writer, double baseX, double baseY, double baseZ) {
            final double radius = 5;
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
                writer.write(particle,
                        x + baseX,
                        y + baseY,
                        z + baseZ
                        , offsetX, offsetY, offsetZ);
            }
        }
    };


    @Override
    public void onLoad() {
    }

    @Override
    public void onEnable() {
        flusher = new FParticleManager(this, "fparticle");
    }

    @Override
    public void onDisable() {
        flusher.close();
        flusher = null;
    }


    // @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        if (args.length == 0) {
            new BukkitRunnable() {
                final ParticleSource data = SPHERE.and(SPHERE.shift(0, 10, 0));

                @Override
                public void run() {
                    var loc = player.getLocation();
                    for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                        FParticle.send(onlinePlayer, SPHERE, loc.getX(), loc.getY(), loc.getZ());
                    }

                }
            }.runTaskTimerAsynchronously(FParticlePlugin.this, 0, 1);
        } else {
            try {
                ParticleType type = ParticleType.byId("minecraft:" + args[0]);
                var loc = player.getLocation();
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        Channel c = FParticleUtil.getChannel(player);
                        var b = ParticleData.builder().yDist(1);
                        if (args.length == 2) {
                            BlockType blockType = BlockType.getById("minecraft:" + args[1]);
                            if (blockType != null){
                                b.data(new BlockParticleOption(blockType));
                            }
                        }
                        try {
                            c.writeAndFlush(b.particle(type).build().writerAt(loc.getX(), loc.getY(), loc.getZ()))
                                    .sync();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }.runTaskAsynchronously(this);
            } catch (IllegalArgumentException e) {
                sender.sendMessage("Invalid particle type!");
            }
        }

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if (args.length == 1) {
            return Stream.of(ParticleType.values())
                    .map(p -> p.getKey().getKey())
                    .filter(s -> s.toLowerCase().startsWith(args[0].toLowerCase()))
                    .toList();
        }else if(args.length == 2){
            return Stream.of(BlockType.values())
                    .map(p -> p.getKey().getKey())
                    .filter(s -> s.toLowerCase().startsWith(args[1].toLowerCase()))
                    .toList();
        }
        return List.of();
    }
}