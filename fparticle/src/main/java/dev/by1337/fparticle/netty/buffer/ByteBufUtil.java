package dev.by1337.fparticle.netty.buffer;

import io.netty.buffer.ByteBuf;

public class ByteBufUtil {

    public static void writeVarInt1(ByteBuf buf, int value) {
        buf.writeByte(value);
    }

    public static void writeVarInt2(ByteBuf buf, int value) {
        buf.writeShort((value & 0x7F | 0x80) << 8 | (value >>> 7));
    }

    public static void setVarInt2(ByteBuf buf, int index, int value) {
        buf.setShort(index, (value & 0x7F | 0x80) << 8 | (value >>> 7));
    }

    public static void writeVarInt(ByteBuf buf, int value) {
        if ((value & (0xFFFFFFFF << 7)) == 0) {
            buf.writeByte(value);
        } else if ((value & (0xFFFFFFFF << 14)) == 0) {
            int w = (value & 0x7F | 0x80) << 8 | (value >>> 7);
            buf.writeShort(w);
        } else {
            ByteBufUtil.writeVarIntFull(buf, value);
        }
    }

    public static void writeVarIntFull(ByteBuf buf, int value) {
        if ((value & (0xFFFFFFFF << 7)) == 0) {
            buf.writeByte(value);
        } else if ((value & (0xFFFFFFFF << 14)) == 0) {
            int w = (value & 0x7F | 0x80) << 8 | (value >>> 7);
            buf.writeShort(w);
        } else if ((value & (0xFFFFFFFF << 21)) == 0) {
            int w = (value & 0x7F | 0x80) << 16 | ((value >>> 7) & 0x7F | 0x80) << 8 | (value >>> 14);
            buf.writeMedium(w);
        } else if ((value & (0xFFFFFFFF << 28)) == 0) {
            int w = (value & 0x7F | 0x80) << 24 | (((value >>> 7) & 0x7F | 0x80) << 16)
                    | ((value >>> 14) & 0x7F | 0x80) << 8 | (value >>> 21);
            buf.writeInt(w);
        } else {
            int w = (value & 0x7F | 0x80) << 24 | ((value >>> 7) & 0x7F | 0x80) << 16
                    | ((value >>> 14) & 0x7F | 0x80) << 8 | ((value >>> 21) & 0x7F | 0x80);
            buf.writeInt(w);
            buf.writeByte(value >>> 28);
        }
    }

    public static int varInt3Size(int value) {
        if ((value & (0xFFFFFFFF << 7)) == 0) {
            return 1;
        } else if ((value & (0xFFFFFFFF << 14)) == 0) {
            return 2;
        } else {
            return 3;
        }
    }
}
