package dev.by1337.fparticle;

import dev.by1337.fparticle.netty.FParticleManager;
import dev.by1337.fparticle.particle.PacketBuilder;
import dev.by1337.fparticle.particle.ParticleData;
import dev.by1337.fparticle.particle.ParticleSource;
import dev.by1337.fparticle.particle.options.BlockParticleOption;
import dev.by1337.fparticle.particle.options.DustColorTransitionOptions;
import dev.by1337.fparticle.particle.options.DustParticleOptions;
import dev.by1337.fparticle.particle.options.ItemParticleOption;
import dev.by1337.fparticle.via.Mappings;
import io.netty.channel.Channel;
import org.bukkit.Bukkit;
import org.bukkit.Color;
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
        public void doWrite(PacketBuilder writer, double baseX, double baseY, double baseZ) {
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
                writer.append(particle,
                        x + baseX,
                        y + baseY,
                        z + baseZ
                        , offsetX, offsetY, offsetZ);
            }
        }
    };
    private static final ParticleSource TEST = new ParticleSource() {
        private final Random random = new Random();
        private final ParticleData particle = ParticleData.builder()
                .maxSpeed(0f)
                .particle(ParticleType.FIREWORK)
                .count(50)
                .build();

        @Override
        public void doWrite(PacketBuilder writer, double baseX, double baseY, double baseZ) {
            writer.append(
                    particle,
                    baseX,
                    baseY,
                    baseZ,
                    10,
                    10,
                    10
            );
        }
    };


    @Override
    public void onLoad() {
        int ignored = ItemType.BARRIER.getProtocolId(Mappings.NATIVE_PROTOCOL); //preload
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
                final ParticleSource data =
                        SPHERE.compute()
                                .ofParticle(ParticleData.of(
                                        ParticleType.ITEM,
                                        new ItemParticleOption(
                                                ItemType.ENDER_PEARL
                                        )
                                )); // McfunctionReader.read(new File(getDataFolder(), "test.mcfunction"));
                double angleRad = 0;

                @Override
                public void run() {
                    var loc = player.getLocation();
                    double x = loc.getX();
                    double y = loc.getY();
                    double z = loc.getZ();
                    Bukkit.getOnlinePlayers().forEach(FParticle.send(data, x, y, z));
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
                        if (args.length == 2 && type == ParticleType.ITEM) {
                            ItemType itemType = ItemType.getById("minecraft:" + args[1]);
                            if (itemType != null) {
                                b.data(new ItemParticleOption(itemType));
                            }
                        } else if (args.length == 2) {
                            BlockType blockType = BlockType.getById("minecraft:" + args[1]);
                            if (blockType != null) {
                                b.data(new BlockParticleOption(blockType));
                            }
                        }
                        try {
                            c.writeAndFlush(b.particle(type).build().shift(loc.getX(), loc.getY(), loc.getZ()))
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
        } else if (args.length == 2 && args[0].contains("item")) {
            return Stream.of(ItemType.values())
                    .map(p -> p.getKey().getKey())
                    .filter(s -> s.toLowerCase().startsWith(args[1].toLowerCase()))
                    .toList();
        } else if (args.length == 2) {
            return Stream.of(BlockType.values())
                    .map(p -> p.getKey().getKey())
                    .filter(s -> s.toLowerCase().startsWith(args[1].toLowerCase()))
                    .toList();
        }
        return List.of();
    }
}