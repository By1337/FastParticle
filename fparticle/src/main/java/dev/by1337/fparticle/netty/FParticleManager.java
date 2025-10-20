package dev.by1337.fparticle.netty;

import dev.by1337.fparticle.FParticleUtil;
import dev.by1337.fparticle.netty.handler.ParticleEncoder;
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

public class FParticleManager implements Listener, Closeable {
    private final String handlerName;

    public FParticleManager(Plugin plugin, String handlerName) {
        this.handlerName = handlerName;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        Bukkit.getOnlinePlayers().forEach(this::hook);
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onJoin(PlayerJoinEvent event) {
        hook(event.getPlayer());
    }

    private void hook(Player player) {
        Channel channel = FParticleUtil.getChannel(player);
        channel.pipeline().addBefore("prepender", handlerName, new ParticleEncoder(channel, player));
    }

    @Override
    public void close() {
        HandlerList.unregisterAll(this);
        Bukkit.getOnlinePlayers().forEach(player -> {
            Channel channel = FParticleUtil.getChannel(player);
            channel.pipeline().remove(handlerName);
        });
    }
}
