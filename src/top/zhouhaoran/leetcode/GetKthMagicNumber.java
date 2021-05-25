package top.zhouhaoran.leetcode;

import java.util.*;

public class GetKthMagicNumber {
    public static void main(String[] args) {
        GetKthMagicNumber getKthMagicNumber = new GetKthMagicNumber();
        System.out.println(getKthMagicNumber.getKthMagicNumber2(10));
    }

    public int getKthMagicNumber(int k) {
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        priorityQueue.add(1L);

        while (true) {
            Long num = priorityQueue.poll();

            if (!set.contains(num)) {
                set.add(num);
                priorityQueue.add(num * 3);
                priorityQueue.add(num * 5);
                priorityQueue.add(num * 7);
            }

            if (set.size() == k) {
                return num.intValue();
            }
        }
    }

    public int getKthMagicNumber2(int k) {
        int[] dp = new int[k];
        dp[0] = 1;
        int i3 = 0, i5 = 0, i7 = 0;

        for (int i = 1; i < k; i++) {
            dp[i] = Math.min(dp[i3] * 3, Math.min(dp[i5] * 5, dp[i7] * 7));
            if (dp[i] == dp[i3] * 3) i3++;
            if (dp[i] == dp[i5] * 5) i5++;
            if (dp[i] == dp[i7] * 7) i7++;
        }

        return dp[k - 1];
    }
}
