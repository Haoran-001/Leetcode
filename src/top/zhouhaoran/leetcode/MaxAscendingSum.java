package top.zhouhaoran.leetcode;

public class MaxAscendingSum {
    public static void main(String[] args) {
        MaxAscendingSum maxAscendingSum = new MaxAscendingSum();
        int[] nums = new int[]{10, 20, 30,  5, 10, 50};
        System.out.println(maxAscendingSum.maxAscendingSum(nums));
    }

    public int maxAscendingSum(int[] nums) {
        int dp[] = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }

        int maxNum = 0;

        for (int i = 0; i < dp.length; i++) {
            if (maxNum < dp[i]) {
                maxNum = dp[i];
            }
        }

        return maxNum;
    }
}
