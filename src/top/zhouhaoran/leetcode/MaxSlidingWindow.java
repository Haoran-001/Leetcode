package top.zhouhaoran.leetcode;

import java.util.*;

public class MaxSlidingWindow {
    public static void main(String[] args) {
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow.maxSlidingWindow2(nums, k)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for (int i = 0; i < n - k + 1; i++) {
            int maxValue = nums[i];
            for (int j = i + 1; j < i + k; j++) {
                if (maxValue < nums[j]) {
                    maxValue = nums[j];
                }
            }
            ans[i] = maxValue;
        }

        return ans;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        // 该双端队列是一个单调不增的队列, 即第i个元素值一定大于等于第i+1个元素的值
        // 当区间[i, j]向右滑动变为[i+1, j+1]时, 判断如果单调队列中的最大元素就是nums[i], 则需要删除, 即删除单调队列队首元素
        // 单调队列的队尾元素如果小于当前元素, 则出队, 直到队列为空或者队尾元素大于等于当前元素
        // 将当前元素加入队列尾部, 构成一个新的单调队列
        // 每一次循环, 将队首元素加入结果数组中
        for (int i = 1 - k, j = 0; i < ans.length && j < nums.length; i++, j++) {
            if (i > 0 && deque.peekFirst() == nums[i - 1]) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.removeLast();
            }
            deque.add(nums[j]);

            if (i >= 0) {
                ans[i] = deque.peekFirst();
            }
        }

        return ans;
    }
}
