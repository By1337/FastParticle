package dev.by1337.fparticle.netty;

import dev.by1337.fparticle.FParticleUtil;
import dev.by1337.fparticle.ParticleReceiver;
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
    private final Plugin plugin;
    private final String handlerName;

    public FParticleHooker(Plugin plugin, String handlerName) {
        this.plugin = plugin;
        this.handlerName = handlerName;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        Bukkit.getOnlinePlayers().forEach(this::hook);
    }

    public ParticleReceiver getReceiver(Player player) {
        return FParticleUtil.getChannel(player).attr(ParticleReceiver.ATTRIBUTE).get();
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onJoin(PlayerJoinEvent event) {
        hook(event.getPlayer());
    }

    private void hook(Player player) {
        Channel channel = FParticleUtil.getChannel(player);
        channel.pipeline().addBefore("prepender", handlerName, new ParticleReceiver(channel, player));
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
