package dev.by1337.fparticle.particle;

import dev.by1337.fparticle.ParticleType;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class ParticleData extends ParticleSource{
    public final float xDist;
    public final float yDist;
    public final float zDist;
    public final float maxSpeed;
    public final int count;
    public final boolean overrideLimiter;
    /// 1.21.4+
    public final boolean alwaysShow;
    public final ParticleType particle;
    public final @Nullable ParticleOption data;

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

    public static ParticleData of(ParticleType particle) {
        return of(particle , null);
    }

    public static ParticleData of(ParticleType particle, ParticleOption data) {
        return builder().particle(particle).data(data).build();
    }

    public static ParticleData.Builder builder() {
        return new ParticleData.Builder();
    }

  //  public int particleId(){
  //      return Mappings.getParticleId()
  //  }

    protected static ParticleData build(ParticleData.Builder builder) {
        return new ParticleData(builder);
      //  return FParticleUtil.newParticle(builder);
    }

  //  public abstract void write(ByteBuf buf, double x, double y, double z, float xDist, float yDist, float zDist);

    @Override
    public void doWrite(PacketBuilder writer, double baseX, double baseY, double baseZ) {
        writer.append(this,  baseX, baseY, baseZ);
    }

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

    public ParticleType particle() {
        return particle;
    }

    public @Nullable ParticleOption data() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ParticleData data1 = (ParticleData) o;
        return Float.compare(xDist, data1.xDist) == 0 && Float.compare(yDist, data1.yDist) == 0 && Float.compare(zDist, data1.zDist) == 0 && Float.compare(maxSpeed, data1.maxSpeed) == 0 && count == data1.count && overrideLimiter == data1.overrideLimiter && alwaysShow == data1.alwaysShow && particle == data1.particle && Objects.equals(data, data1.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xDist, yDist, zDist, maxSpeed, count, overrideLimiter, alwaysShow, particle, data);
    }

    public static class Builder {

        public float xDist;
        public float yDist;
        public float zDist;
        public float maxSpeed;
        public int count;
        public boolean overrideLimiter;
        public boolean alwaysShow;
        public ParticleType particle;
        public ParticleOption data;

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

        public Builder particle(ParticleType particle) {
            this.particle = particle;
            return Builder.this;
        }

        public Builder data(ParticleOption data) {
            this.data = data;
            return Builder.this;
        }

        public ParticleData build() {
            return ParticleData.build(this);
        }

    }


}
