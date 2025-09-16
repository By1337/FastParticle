package dev.by1337.fparticle.particle;

import dev.by1337.fparticle.NMSUtil;
import io.netty.buffer.ByteBuf;
import org.bukkit.Particle;
import org.jetbrains.annotations.Nullable;

import java.util.NoSuchElementException;

public abstract class MutableParticleData implements ParticleIterable {
    private static final NMSUtil NMS_UTIL;
    protected double x;
    protected double y;
    protected double z;
    protected float xDist;
    protected float yDist;
    protected float zDist;
    protected float maxSpeed;
    protected int count;
    protected boolean overrideLimiter;
    /// 1.21.4+
    protected boolean alwaysShow;
    protected Particle particle = Particle.REDSTONE;
    protected @Nullable Object data;

    public static MutableParticleData createNew() {
        return NMS_UTIL.newParticle();
    }

    static {
        try {
            Class<?> cl = Class.forName("dev.by1337.fparticle.FParticle");
            NMS_UTIL = (NMSUtil) cl.getField("NMS_UTIL").get(null);
        } catch (ClassNotFoundException | NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public abstract void write(ByteBuf buf);

    public MutableParticleData pos(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    public MutableParticleData addPos(double x, double y, double z) {
        this.x += x;
        this.y += y;
        this.z += z;
        return this;
    }

    public MutableParticleData dist(float xDist, float yDist, float zDist) {
        this.xDist = xDist;
        this.yDist = yDist;
        this.zDist = zDist;
        return this;
    }

    @Override
    public ParticleIterator iterator() {
        return new ParticleIterator() {
            boolean read;

            @Override
            public void write(ByteBuf buf) {
                if (read) throw new NoSuchElementException();
                MutableParticleData.this.write(buf);
                read = true;
            }

            @Override
            public boolean hasNext() {
                return !read;
            }
        };
    }

    @Override
    public int size() {
        return 1;
    }

    public double x() {
        return x;
    }

    public MutableParticleData x(double x) {
        this.x = x;
        return this;
    }

    public double y() {
        return y;
    }

    public MutableParticleData y(double y) {
        this.y = y;
        return this;
    }

    public double z() {
        return z;
    }

    public MutableParticleData z(double z) {
        this.z = z;
        return this;
    }

    public float xDist() {
        return xDist;
    }

    public MutableParticleData xDist(float xDist) {
        this.xDist = xDist;
        return this;
    }

    public float yDist() {
        return yDist;
    }

    public MutableParticleData yDist(float yDist) {
        this.yDist = yDist;
        return this;
    }

    public float zDist() {
        return zDist;
    }

    public MutableParticleData zDist(float zDist) {
        this.zDist = zDist;
        return this;
    }

    public float maxSpeed() {
        return maxSpeed;
    }

    public MutableParticleData maxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
        return this;
    }

    public int count() {
        return count;
    }

    public MutableParticleData count(int count) {
        this.count = count;
        return this;
    }

    public boolean overrideLimiter() {
        return overrideLimiter;
    }

    public MutableParticleData overrideLimiter(boolean overrideLimiter) {
        this.overrideLimiter = overrideLimiter;
        return this;
    }

    /// 1.21.4+
    public boolean alwaysShow() {
        return alwaysShow;
    }

    /// 1.21.4+
    public MutableParticleData alwaysShow(boolean alwaysShow) {
        this.alwaysShow = alwaysShow;
        return this;
    }

    public Particle particle() {
        return particle;
    }

    public MutableParticleData particle(Particle particle) {
        this.particle = particle;
        return this;
    }

    public @Nullable Object data() {
        return data;
    }

    public MutableParticleData data(@Nullable Object data) {
        this.data = data;
        return this;
    }
}
