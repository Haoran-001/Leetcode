package top.zhouhaoran.leetcode;

import java.util.*;

/**
 * 定义一个哈希表和一个双向链表
 * 哈希表的键值对定义为输入的一个键和一个双向链表结点
 * 每次使用get方法获取给定的键时, 判断该键是否包含在哈希表中, 如果不包含, 直接返回-1
 * 如果包含, 则返回哈希表对应键的值, 该值是一个双向链表结点, 将其放在双向链表的头部,
 * 将结点放在双向链表的头部, 具体做法是将当前结点删除, 接着在双向链表头部插入该结点
 * 每次使用put方法获取给定键的值, 判断该键是否包含在哈希表中, 如果不包含, 直接将键加入哈希表, 并new一个双向链表结点作为值
 *      再把当前新new出来的双向链表结点放在双向链表的头部
 *      若当前哈希表长度大于容量, 则将双向链表中的最后一个结点删除掉
 * 如果put获取给定键的值，判断该键包含在哈希表中, 则直接获取到该键的值, 为一个双向链表结点, 并且修改其中的值
 *      再把当前修改后的结点放入双向链表头部
 */

public class LRUCache3 {
    public static void main(String[] args) {
        LRUCache3 cache = new LRUCache3(2);

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

    private Map<Integer, DLinkedNode> map;
    private DLinkedNode head, tail;
    private int capacity;
    private int size;

    public LRUCache3(int capacity) {
        this.map = new HashMap<>();
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        this.capacity = capacity;
        this.size = 0;
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        DLinkedNode node = map.get(key);

        if (node == null) {
            return -1;
        } else {
            moveToHead(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        DLinkedNode node = map.get(key);

        if (node == null) {
            DLinkedNode newNode = new DLinkedNode(key, value);
            addToHead(newNode);
            map.put(key, newNode);
            size++;

            if (size > capacity) {
                DLinkedNode tailNode = removeTailNode();
                map.remove(tailNode.key);
                size--;
            }

        } else {
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

    private DLinkedNode removeTailNode() {
        DLinkedNode tailNode = tail.prev;
//        tail.prev = tailNode.prev;
//        tailNode.prev.next = tail;
        removeNode(tailNode);

        return tailNode;
    }
}

class DLinkedNode {
    public int key, value;
    public DLinkedNode prev, next;

    public DLinkedNode() {}

    public DLinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
