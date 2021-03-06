package top.zhouhaoran.leetcode;

import java.util.*;

public class MyHashSet {
    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet);
        boolean flag1 = myHashSet.contains(1); // 返回 True
        boolean flag2 = myHashSet.contains(3); // 返回 False ，（未找到）
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.add(3);
        boolean flag3 = myHashSet.contains(2); // 返回 True
        myHashSet.remove(2);   // set = [1]
        boolean flag4 = myHashSet.contains(2); // 返回 False ，（已移除）
        System.out.println(myHashSet);
        myHashSet.add(1000000);
        boolean flag5 = myHashSet.contains(1000000);
        System.out.println(flag5);
    }

    private int keySpace = 2069;
    private List<SetBucket> hashSet;
    /** Initialize your data structure here. */
    public MyHashSet() {
        hashSet = new ArrayList<>();
        for (int i = 0; i < this.keySpace; i++) {
            hashSet.add(new SetBucket());
        }
    }

    public void add(int key) {
        int hashKey = key % this.keySpace;
        hashSet.get(hashKey).add(key);
    }

    public void remove(int key) {
        int hashKey = key % this.keySpace;
        hashSet.get(hashKey).remove(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hashKey = key % this.keySpace;
        return hashSet.get(hashKey).contains(key);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (SetBucket setBucket : this.hashSet) {
            if (setBucket.toString() == null) {
                continue;
            }
            sb.append(setBucket);
        }
        sb.append("]");

        return sb.toString();
    }
}

class SetBucket {
    List<Integer> bucket;

    public SetBucket() {
        bucket = new LinkedList<>();
    }

    public void add(Integer key) {
        if (bucket.contains(key)) {
            return;
        }
        bucket.add(key);
    }

    public void remove(Integer key) {
        if (!bucket.contains(key)) {
            return;
        }

        for (Integer bucketKey : bucket) {
            if (bucketKey.equals(key)) {
                bucket.remove(bucketKey);
                return;
            }
        }
    }

    public boolean contains(Integer key) {
        return bucket.contains(key);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        int length = bucket.size();

        if (length == 0) {
            return null;
        }

        for (int i = 0; i < length - 1; i++) {
            sb.append(bucket.get(i) + ", ");
        }
        sb.append(bucket.get(length - 1) + ")");

        return sb.toString();
    }
}