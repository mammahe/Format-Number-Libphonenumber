package com.sairamkrishna.formatnumber;

import java.util.LinkedHashMap;
import java.util.regex.Pattern;


public class RegexCache {
    private LRUCache<String, Pattern> cache;

    public RegexCache(int size) {
        cache = new LRUCache<String, Pattern>(size);
    }

    public Pattern getPatternForRegex(String regex) {
        Pattern pattern = cache.get(regex);
        if (pattern == null) {
            pattern = Pattern.compile(regex);
            cache.put(regex, pattern);
        }
        return pattern;
    }

    // @VisibleForTesting
    boolean containsRegex(String regex) {
        return cache.containsKey(regex);
    }

    private static class LRUCache<K, V> {
        // LinkedHashMap offers a straightforward implementation of LRU cache.
        private LinkedHashMap<K, V> map;
        private int size;

        @SuppressWarnings("serial")
        public LRUCache(int size) {
            this.size = size;
            // Using access-order instead of insertion-order.
            map = new LinkedHashMap<K, V>(size * 4 / 3 + 1, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Entry<K, V> eldest) {
                    return size() > LRUCache.this.size;
                }
            };
        }

        public synchronized V get(K key) {
            return map.get(key);
        }

        public synchronized void put(K key, V value) {
            map.put(key, value);
        }

        public synchronized boolean containsKey(K key) {
            return map.containsKey(key);
        }
    }
}
