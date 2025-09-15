package dev.by1337.fparticle;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

import java.io.Closeable;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class FParticleFlusher implements Listener, Closeable {
    private final Plugin plugin;
    private final BukkitTask flusher;
    private final Map<UUID, ParticleReceiver> receiverMap = new ConcurrentHashMap<>();

    public FParticleFlusher(Plugin plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        flusher = plugin.getServer().getScheduler().runTaskTimerAsynchronously(plugin, this::tick, 1, 1);
        Bukkit.getOnlinePlayers().forEach(this::onJoin);
    }

    private void tick() {
        for (Map.Entry<UUID, ParticleReceiver> entry : receiverMap.entrySet()) {
            try {
                entry.getValue().tick();
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }

    public ParticleReceiver getReceiver(Player player) {
        return receiverMap.get(player.getUniqueId());
    }

    public ParticleReceiver getReceiver(UUID uuid) {
        return receiverMap.get(uuid);
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onJoin(PlayerJoinEvent event) {
        onJoin(event.getPlayer());
    }
    private void onJoin(Player player) {
        var old = receiverMap.put(player.getUniqueId(), new ParticleReceiver(FParticle.NMS_UTIL.getChannel(player)));
        if (old != null) {
            old.close();
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        var old = receiverMap.remove(player.getUniqueId());
        if (old != null) {
            old.close();
        }
    }

    @Override
    public void close() {
        flusher.cancel();
        HandlerList.unregisterAll(this);
        receiverMap.values().forEach(ParticleReceiver::close);
        receiverMap.clear();
    }
}
