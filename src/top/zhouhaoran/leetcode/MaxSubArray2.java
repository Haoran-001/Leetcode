package top.zhouhaoran.leetcode;

public class MaxSubArray2 {
    public static void main(String[] args) {
        MaxSubArray2 maxSubArray2 = new MaxSubArray2();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray2.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];

        dp[0] = nums[0];

        for (int i = 1; i < dp.length; i++) {
            if (dp[i - 1] >= 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < dp.length; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }
        }

        return max;
    }
}
