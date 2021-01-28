package top.zhouhaoran.leetcode;

public class MaxSubArray {
    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int res = maxSubArray.maxSubArray(nums);
        System.out.println(res);
    }

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];

        int[] dp = new int[len];
        int max = dp[0] = nums[0];

        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
