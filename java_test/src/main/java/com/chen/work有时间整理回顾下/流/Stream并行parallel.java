package com.chen.work有时间整理回顾下.流;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Stream并行parallel {
    public static void main(String[] args) {
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }
        //
        long t0 = System.nanoTime();

        long count = values.stream().sorted().count();
        System.out.println(count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));

        // sequential sort took: 899 ms

        long t0p = System.nanoTime();

        long countp = values.parallelStream().sorted().count();
        System.out.println(countp);

        long t1p = System.nanoTime();

        long millisp = TimeUnit.NANOSECONDS.toMillis(t1p - t0p);
        System.out.println(String.format("parallel sort took: %d ms", millisp));

        // parallel sort took: 472 ms
    }
}
