package dev.by1337.fparticle;

import com.destroystokyo.paper.event.server.ServerTickEndEvent;
import com.destroystokyo.paper.event.server.ServerTickStartEvent;
import dev.by1337.fparticle.netty.FParticleHooker;
import dev.by1337.fparticle.particle.ParticleData;
import dev.by1337.fparticle.particle.ParticleOutputStream;
import dev.by1337.fparticle.particle.ParticleSource;
import dev.by1337.fparticle.util.Version;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.Random;


public class FParticlePlugin extends JavaPlugin implements Listener {
    private static FParticleHooker flusher;
    private static FParticleUtil.NmsAccessor nms = FParticleUtil.instance = create();

    private static final ParticleSource SPHERE = new ParticleSource() {
        private final Random random = new Random();
        private final ParticleData particle = ParticleData.builder()
                .maxSpeed(0.2f)
                .data(new Particle.DustOptions(Color.AQUA, 1f))
                .particle(Particle.REDSTONE)
                .build();

        @Override
        public void write(ParticleOutputStream writer, double baseX, double baseY, double baseZ) {
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
        flusher = new FParticleHooker(this, "fparticle");
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        flusher.close();
        flusher = null;
    }

    private long prevUsed;
    private int tick;
    private long allocPerSec;

    @EventHandler
    public void tickStart(ServerTickStartEvent e) {
        prevUsed = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    @EventHandler
    public void tickEnd(ServerTickEndEvent e) {
        long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long alloc = used - prevUsed;
        if (alloc > 0) allocPerSec += alloc;
        prevUsed = used;

        if (++tick >= 20) {
            double mb = allocPerSec / 1024.0 / 1024.0;
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage(Component.text(String.format("§e%.3f MB/sec allocated", mb)));
            }
            tick = 0;
            allocPerSec = 0;
        }
    }


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        new BukkitRunnable() {
            final ParticleSource data = SPHERE.and(SPHERE.shift(0, 10, 0));
            @Override
            public void run() {
                var loc = player.getLocation();
                FParticle.send(player, data, loc.getX(), loc.getY(), loc.getZ());
            }
        }.runTaskTimerAsynchronously(FParticlePlugin.this, 0, 1);
        return true;
    }


    private static FParticleUtil.NmsAccessor create() {
        return switch (Version.VERSION.ver()) {
            case "1.16.5" -> new NMSUtilV1165();
            default -> throw new IllegalStateException("Unknown NMS Version");
        };
    }
}