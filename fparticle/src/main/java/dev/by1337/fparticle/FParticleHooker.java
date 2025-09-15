package dev.by1337.fparticle;

import dev.by1337.fparticle.handler.ParticleSender;
import io.netty.channel.Channel;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import java.io.Closeable;

public class FParticleHooker implements Listener, Closeable {
    private static final NMSUtil NMS_UTIL = FParticle.NMS_UTIL;
    private final Plugin plugin;
    private final String handlerName;

    public FParticleHooker(Plugin plugin, String handlerName) {
        this.plugin = plugin;
        this.handlerName = handlerName;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        Bukkit.getOnlinePlayers().forEach(this::hook);
    }

    public ParticleSender getReceiver(Player player) {
        return NMS_UTIL.getChannel(player).attr(ParticleSender.ATTRIBUTE).get();
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onJoin(PlayerJoinEvent event) {
        hook(event.getPlayer());
    }

    private void hook(Player player) {
        Channel channel = NMS_UTIL.getChannel(player);
        channel.pipeline().addBefore("prepender", handlerName, new ParticleSender(channel));
    }

    @Override
    public void close() {
        HandlerList.unregisterAll(this);
        Bukkit.getOnlinePlayers().forEach(player -> {
            Channel channel = NMS_UTIL.getChannel(player);
            channel.pipeline().remove(handlerName);
        });
    }
}
