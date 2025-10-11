package dev.by1337.fparticle.particle;

import dev.by1337.fparticle.FParticleUtil;
import io.netty.buffer.ByteBuf;
import org.bukkit.Particle;
import org.jetbrains.annotations.Nullable;

public abstract class ParticleData {
    public final float xDist;
    public final float yDist;
    public final float zDist;
    public final float maxSpeed;
    public final int count;
    public final boolean overrideLimiter;
    /// 1.21.4+
    public final boolean alwaysShow;
    public final Particle particle;
    public final @Nullable Object data;

    protected ParticleData(Builder builder) {
        this.xDist = builder.xDist;
        this.yDist = builder.yDist;
        this.zDist = builder.zDist;
        this.maxSpeed = builder.maxSpeed;
        this.count = builder.count;
        this.overrideLimiter = builder.overrideLimiter;
        this.alwaysShow = builder.alwaysShow;
        this.particle = builder.particle;
        this.data = builder.data;
    }

    public ParticleData.Builder copyAsBuilder() {
        return new Builder(this);
    }

    public static ParticleData.Builder builder() {
        return new ParticleData.Builder();
    }

    public abstract int particleId();

    protected static ParticleData build(ParticleData.Builder builder) {
        return FParticleUtil.newParticle(builder);
    }

    public abstract void write(ByteBuf buf, double x, double y, double z, float xDist, float yDist, float zDist);

    public float xDist() {
        return xDist;
    }

    public float yDist() {
        return yDist;
    }

    public float zDist() {
        return zDist;
    }

    public float maxSpeed() {
        return maxSpeed;
    }

    public int count() {
        return count;
    }

    public boolean overrideLimiter() {
        return overrideLimiter;
    }

    public boolean alwaysShow() {
        return alwaysShow;
    }

    public Particle particle() {
        return particle;
    }

    public @Nullable Object data() {
        return data;
    }

    public static class Builder {

        private float xDist;
        private float yDist;
        private float zDist;
        private float maxSpeed;
        private int count;
        private boolean overrideLimiter;
        private boolean alwaysShow;
        private Particle particle;
        private Object data;

        public Builder() {
        }

        public Builder(ParticleData particleData) {
            this.xDist = particleData.xDist;
            yDist = particleData.yDist;
            zDist = particleData.zDist;
            maxSpeed = particleData.maxSpeed;
            count = particleData.count;
            overrideLimiter = particleData.overrideLimiter;
            alwaysShow = particleData.alwaysShow;
            particle = particleData.particle;
            data = particleData.data;
        }

        Builder(float xDist, float yDist, float zDist, float maxSpeed, int count, boolean overrideLimiter, boolean alwaysShow, Particle particle, Object data) {
            this.xDist = xDist;
            this.yDist = yDist;
            this.zDist = zDist;
            this.maxSpeed = maxSpeed;
            this.count = count;
            this.overrideLimiter = overrideLimiter;
            this.alwaysShow = alwaysShow;
            this.particle = particle;
            this.data = data;
        }

        public Builder xDist(float xDist) {
            this.xDist = xDist;
            return Builder.this;
        }

        public Builder yDist(float yDist) {
            this.yDist = yDist;
            return Builder.this;
        }

        public Builder zDist(float zDist) {
            this.zDist = zDist;
            return Builder.this;
        }

        public Builder maxSpeed(float maxSpeed) {
            this.maxSpeed = maxSpeed;
            return Builder.this;
        }

        public Builder count(int count) {
            this.count = count;
            return Builder.this;
        }

        public Builder overrideLimiter(boolean overrideLimiter) {
            this.overrideLimiter = overrideLimiter;
            return Builder.this;
        }

        public Builder alwaysShow(boolean alwaysShow) {
            this.alwaysShow = alwaysShow;
            return Builder.this;
        }

        public Builder particle(Particle particle) {
            this.particle = particle;
            return Builder.this;
        }

        public Builder data(Object data) {
            this.data = data;
            return Builder.this;
        }

        public ParticleData build() {
            return ParticleData.build(this);
        }
    }


}
