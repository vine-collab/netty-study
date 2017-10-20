package com.hoteach.guava.example;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author hekai
 * @create 2017-10-20 下午2:01
 */

public class Counter {
    static LoadingCache<Long, AtomicLong> count = CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.SECONDS).build(new CacheLoader<Long, AtomicLong>() {
        @Override
        public AtomicLong load(Long o) throws Exception {
            System.out.println("Load call!");
            return new AtomicLong(0L);
        }
    });
    static long limits = 10;
    static int counter = 0;

    public static synchronized int getCounter() throws Exception {
        while (true) {
            //获取当前的时间戳作为key
            Long currentSeconds = System.currentTimeMillis() / 1000;
            if (count.get(currentSeconds).getAndIncrement() > limits) {
                continue;
            }
            return counter++;
        }
    }
}
