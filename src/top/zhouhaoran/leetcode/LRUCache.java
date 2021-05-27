package top.zhouhaoran.leetcode;

import java.util.*;

class LRUCache extends LinkedHashMap{
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        int ans = cache.get(1);
        System.out.println(ans);

        cache.put(3, 3);
        ans = cache.get(2);
        System.out.println(ans);

        cache.put(4, 4);
        ans = cache.get(1);
        System.out.println(ans);
        ans = cache.get(3);
        System.out.println(ans);
        ans = cache.get(4);
        System.out.println(ans);
    }

    private int capacity;
    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return (int)super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > capacity;
    }
}
