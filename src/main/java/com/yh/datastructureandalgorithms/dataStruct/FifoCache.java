package com.yh.datastructureandalgorithms.dataStruct;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 基于linkedHashMap的FIFO队列
 */
public class FifoCache<K,V> {
    private int maxSize;
    private HashMap<K, V> delegate;

    public FifoCache(final int maxSize) {
        this.maxSize = maxSize;
        this.delegate = new LinkedHashMap<K, V>() {
            private static final long serialVersionUID = 4267176411845948333L;

            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > maxSize;
            }
        };
    }

    public synchronized void put(K key, V value) {
        delegate.put(key, value);
    }

    public synchronized V get(K key) {
        return delegate.get(key);
    }

    public synchronized void remove(K key) {
        delegate.remove(key);
    }

    public synchronized Set<Map.Entry<K, V>> getAll() {
        return delegate.entrySet();
    }

    public synchronized int size() {
        return delegate.size();
    }

    public synchronized void clear() {
        delegate.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : delegate.entrySet()) {
            sb.append(String.format("%s:%s ", entry.getKey(), entry.getValue()));
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        FifoCache<Integer, String> integerStringLruCache = new FifoCache<>(4);
        for (int i = 0; i < 10; i++) {
            integerStringLruCache.put(i, "第" + i + "个");
            System.out.println(integerStringLruCache.toString());
        }
    }
}
