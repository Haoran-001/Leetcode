package top.zhouhaoran.leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class MyHashMap {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 2);
        myHashMap.put(3, 4);
        myHashMap.put(3, 299);
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(3));
        System.out.println(myHashMap.get(100));
    }

    private int keySapce;
    private List<Bucket> hashTable;

    public MyHashMap() {
        this.keySapce = 2069;
        this.hashTable = new ArrayList<>();

        for (int i = 0; i < keySapce; i++) {
            this.hashTable.add(new Bucket());
        }
    }

    public void put(int key, int value) {
        int hashKey = key % this.keySapce;
        this.hashTable.get(hashKey).update(key, value);
    }

    public int get(int key) {
        int hashKey = key % this.keySapce;
        return this.hashTable.get(hashKey).get(key);
    }

    public void remove(int key) {
        int hashKey = key % this.keySapce;
        this.hashTable.get(hashKey).remove(key);
    }
}

class Pair<U, V> {
    public U first;
    public V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }
}

class Bucket {
    private List<Pair<Integer, Integer>> bucket;

    public Bucket() {
        this.bucket = new LinkedList<>();
    }

    public int get(Integer key) {
        for (Pair<Integer, Integer> pair : this.bucket) {
            if (pair.first.equals(key)) {
                return pair.second;
            }
        }

        return -1;
    }

    /**
     * include the function of adding and updation
     * @param key
     * @param value
     */
    public void update(Integer key, Integer value) {
        boolean found = false;
        for (Pair<Integer, Integer> pair : this.bucket) {
            if (pair.first.equals(key)) {
                pair.second = value;
                found = true;
            }
        }

        if (!found) {
            this.bucket.add(new Pair<>(key, value));
        }
    }

    public void remove(Integer key) {
        for (Pair<Integer, Integer> pair : this.bucket) {
            if (pair.first.equals(key)) {
                this.bucket.remove(pair);
                break;
            }
        }
    }
}