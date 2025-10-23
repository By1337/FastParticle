package dev.by1337.fparticle;

import dev.by1337.fparticle.util.reflect.ChannelGetter;
import dev.by1337.fparticle.util.reflect.ChannelGetterCreator;
import io.netty.channel.Channel;
import org.bukkit.entity.Player;

public class FParticleUtil {
    private static ChannelGetter channel;

    public static Channel getChannel(Player player) {
        if (channel == null) {
            channel = ChannelGetterCreator.create(player);
        }
        return channel.getChannel(player);
    }
}
