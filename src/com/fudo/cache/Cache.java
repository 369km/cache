package com.fudo.cache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Cache<K, V> {
    private final float DEFUALT_LOAD_FACTORY = 0.75f;
    private LinkedHashMap<K, V> map;

    public Cache(int cacheSize, CacheType type) {
        int capacity = (int) (Math.ceil(cacheSize / DEFUALT_LOAD_FACTORY) + 1);
        map = new LinkedHashMap<K, V>(capacity, DEFUALT_LOAD_FACTORY, CacheType.LRU.equals(type)) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > cacheSize;
            }
        };
    }

    public synchronized void put(K key, V value) {
        map.put(key, value);
    }

    public synchronized V get(K key) {
        return map.get(key);
    }

    public synchronized void remove(K key) {
        map.remove(key);
    }

    public synchronized Set<Map.Entry<K, V>> getAll() {
        return map.entrySet();
    }
}
