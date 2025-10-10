package dev.by1337.fparticle.via;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.exception.CancelEncoderException;
import dev.by1337.fparticle.util.Version;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import org.bukkit.entity.Player;

import java.util.function.Consumer;

public class ViaHook {
    private static final boolean HAS_VIA;

    public static ViaMutator getViaMutator(Player player, Channel channel) {
        if (!HAS_VIA) return ViaMutator.NATIVE;
        UserConnection connection = Via.getAPI().getConnection(player.getUniqueId());
        if (connection == null) return ViaMutator.NATIVE;
        if (!connection.shouldTransformPacket()) return ViaMutator.NATIVE;

        return new ViaMutator(
                connection.getProtocolInfo().protocolVersion().getVersion(),
                b -> {
                    if (channel.isOpen()) connection.transformClientbound(b, CancelEncoderException::generate);
                }
        );
    }

    static {
        boolean hasVia;
        try {
            Class.forName("com.viaversion.viaversion.api.Via");
            hasVia = true;
        } catch (ClassNotFoundException e) {
            hasVia = false;
        }
        HAS_VIA = hasVia;
    }

    public record ViaMutator(int protocol, Consumer<ByteBuf> mutator) {
        private static final int NATIVE_PROTOCOL = Version.VERSION.protocolVersion();
        public static ViaMutator NATIVE = new ViaMutator(NATIVE_PROTOCOL, b -> {
        });

        public boolean shouldTransformPacket() {
            return NATIVE_PROTOCOL != protocol;
        }
    }
}
