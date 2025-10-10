package dev.by1337.fparticle.particle;

import dev.by1337.fparticle.FParticleUtil;
import io.netty.buffer.ByteBuf;
import org.bukkit.Particle;
import org.jetbrains.annotations.Nullable;

import java.util.NoSuchElementException;

public abstract class MutableParticleData {
    public float xDist;
    public float yDist;
    public float zDist;
    public float maxSpeed;
    public int count;
    public boolean overrideLimiter;
    /// 1.21.4+
    public boolean alwaysShow;
    protected Particle particle = Particle.REDSTONE;
    protected @Nullable Object data;

    public MutableParticleData copy() {
        return createNew()
                .dist(xDist, yDist, zDist)
                .maxSpeed(maxSpeed)
                .count(count)
                .overrideLimiter(overrideLimiter)
                .alwaysShow(alwaysShow)
                .particle(particle)
                .data(data)
                ;
    }

    public abstract int particleId();

    public static MutableParticleData createNew() {
        return FParticleUtil.newParticle();
    }

    public abstract void write(ByteBuf buf, double x, double y, double z, float xDist, float yDist, float zDist);


    public MutableParticleData resetDist() {
        xDist = 0;
        yDist = 0;
        zDist = 0;
        return this;
    }

    public MutableParticleData dist(float xDist, float yDist, float zDist) {
        this.xDist = xDist;
        this.yDist = yDist;
        this.zDist = zDist;
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
