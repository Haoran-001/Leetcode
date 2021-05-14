package top.zhouhaoran.leetcode;

import java.util.*;

public class LargestDivisibleSubset {
    public static void main(String[] args) {
        LargestDivisibleSubset largestDivisibleSubset = new LargestDivisibleSubset();
        int[] nums = {3, 17};
        List<Integer> ans = largestDivisibleSubset.largestDivisibleSubset2(nums);
        System.out.println(ans);
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        // dp数组代表包含该整数作为最大的整数子数组可以拥有的整除子集的元素个数
        int[] dp = new int[len];

        Arrays.sort(nums);
        Arrays.fill(dp, 1);

        int maxSize = 1, maxVal = nums[0];

        for (int i = 1; i <= len - 1; i++) {
            for (int j = 0; j <= i - 1; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // 找出最大的dp[i], 代表最大整除子集
        for (int i = len - 1; i >= 1; i--) {
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxVal = nums[i];
            }
        }

        // 根据maxSize和maxVal找出自大整除子集中的每个元素
        List<Integer> ans = new ArrayList<>();

        for (int i = len - 1; i >= 0; i--) {
            if (dp[i] == maxSize && maxVal % nums[i] == 0) {
                ans.add(nums[i]);
                maxVal = nums[i];
                maxSize--;
            }
        }

        return ans;
    }

    public List<Integer> largestDivisibleSubset2(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];

        Arrays.sort(nums);
        Arrays.fill(dp, 1);

        int maxSize = 1;
        int maxVal = nums[0];

        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= i - 1; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            if (maxSize < dp[i]) {
                maxSize = dp[i];
                maxVal = nums[i];
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = len - 1; i >= 0; i--) {
            if (dp[i] == maxSize && maxVal % nums[i] == 0) {
                ans.add(nums[i]);
                maxVal = nums[i];
                maxSize--;
            }
        }

        return ans;
    }
}
