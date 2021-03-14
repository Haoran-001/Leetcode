package top.zhouhaoran.leetcode;

import java.util.PriorityQueue;

public class KthLargest2 {
    public static void main(String[] args) {
        KthLargest2 kthLargest = new KthLargest2(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));   // return 4
        System.out.println(kthLargest.add(5));   // return 5
        System.out.println(kthLargest.add(10));  // return 5
        System.out.println(kthLargest.add(9));   // return 8
        System.out.println(kthLargest.add(4));   // return 8
    }

    private PriorityQueue<Integer> priorityQueue;
    private int k;
    public KthLargest2(int k, int[] nums) {
        this.k = k;
        priorityQueue = new PriorityQueue<>();

        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        priorityQueue.offer(val);

        if (priorityQueue.size() > k) {
            priorityQueue.poll();
        }

        return priorityQueue.peek();
    }
}
