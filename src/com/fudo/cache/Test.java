package com.fudo.cache;

import java.util.Map;

public class Test {

    public static void main(String[] args) {
        Cache<Integer, String> cache = new Cache<>(5, CacheType.LRU);
        cache.put(1, "val");
        cache.put(2, "val");
        cache.put(3, "val");
        cache.put(4, "val");
        cache.put(5, "val");
        cache.get(4);
        cache.put(6, "val");
        for (Map.Entry<Integer, String> entry : cache.getAll()) {
            System.out.println(entry.getKey() + entry.getValue());
        }

    }
}
