package dev.by1337.fparticle.netty.buffer;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import java.util.function.Consumer;

public class ByteBufPool {
    private final AtomicReferenceArray<PooledBuf> slots;
    private final ByteBufAllocator allocator;
    private final int bufSize;
    private final long ttlNanos;
    private final int maxLive;
    private final Consumer<ByteBuf> onExpire;
    private final AtomicInteger live = new AtomicInteger();

    public ByteBufPool(ByteBufAllocator allocator, int bufSize, long ttlMillis, int maxLiveBuffers, Consumer<ByteBuf> onExpire) {
        this.allocator = allocator;
        this.bufSize = bufSize;
        this.ttlNanos = ttlMillis * 1_000_000L;
        this.slots = new AtomicReferenceArray<>(maxLiveBuffers);
        this.maxLive = maxLiveBuffers;
        this.onExpire = onExpire;
    }

    public PooledBuf acquire() {
        for (; ; ) {
            long now = System.nanoTime();

            for (int i = 0; i < slots.length(); i++) {
                PooledBuf buf = slots.get(i);
                if (buf != null) {
                    if (buf.isExpired(now)) {
                        if (slots.compareAndSet(i, buf, null)) {
                            expire(buf);
                        }
                        continue;
                    }
                    if (slots.compareAndSet(i, buf, null)) {
                        return buf;
                    }
                }
            }

            int current = live.get();
            if (current < maxLive && live.compareAndSet(current, current + 1)) {
                return new PooledBuf(allocator.buffer(bufSize), now + ttlNanos);
            }

            LockSupport.parkNanos(1_000);
            Thread.onSpinWait();
        }
    }

    public void release(PooledBuf buf) {
        long now = System.nanoTime();
        if (buf.isExpired(now)) {
            expire(buf);
            return;
        }

        for (int tries = 0; tries < 16; tries++) {
            for (int i = 0; i < slots.length(); i++) {
                if (slots.compareAndSet(i, null, buf)) {
                    return;
                }
            }
            LockSupport.parkNanos(500);
            Thread.onSpinWait();
        }

        expire(buf);
    }

    public void flushExpired() {
        long now = System.nanoTime();
        for (int i = 0; i < slots.length(); i++) {
            PooledBuf buf = slots.get(i);
            if (buf != null && buf.isExpired(now)) {
                if (slots.compareAndSet(i, buf, null)) {
                    expire(buf);
                }
            }
        }
    }

    private void expire(PooledBuf buf) {
        try {
            onExpire.accept(buf.buf);
        } finally {
            live.decrementAndGet();
        }
    }

    public record PooledBuf(ByteBuf buf, long expireTime) {

        boolean isExpired(long now) {
            return now > expireTime;
        }

        public void release(ByteBufPool pool) {
            pool.release(this);
        }
    }
}
