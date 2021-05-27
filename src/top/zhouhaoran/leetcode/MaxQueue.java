package top.zhouhaoran.leetcode;

import java.util.Deque;
import java.util.Queue;
import java.util.LinkedList;

public class MaxQueue {
    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(5);
        maxQueue.push_back(2);
        maxQueue.push_back(3);
        maxQueue.push_back(4);

        System.out.println(maxQueue.max_value());


    }

    Queue<Integer> queue;
    Deque<Integer> deque;
    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        if (deque.isEmpty()) {
            return -1;
        }

        return deque.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);

        if (deque.isEmpty()) {
            deque.offerLast(value);
            return;
        }

        while (!deque.isEmpty() && value > deque.peekLast()) {
            deque.pollLast();
        }

        deque.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }

        int value = queue.poll();

        if (value == deque.peekFirst()) {
            deque.pollFirst();
        }

        return value;
    }
}
