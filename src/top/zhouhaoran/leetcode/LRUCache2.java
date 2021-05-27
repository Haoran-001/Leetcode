package top.zhouhaoran.leetcode;

import java.util.*;

public class LRUCache2 {
    public static void main(String[] args) {
        LRUCache2 cache = new LRUCache2(2);

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

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache2(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }

        // 如果哈希表存在, 先通过哈希表定位, 再移动到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 若key不存在, 则创建一个新结点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加进双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }

        } else {
            // 如果key存在, 则通过哈希表定位, 再修改value, 并移动到头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
//        tail.prev = tail.prev.prev;
//        tail.prev.prev.next = tail;
        DLinkedNode node = tail.prev;
        removeNode(node);

        return node;
    }
}
