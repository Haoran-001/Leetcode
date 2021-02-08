package top.zhouhaoran.leetcode;

public class Massage {
    public static void main(String[] args) {
        Massage massage = new Massage();
        int[] nums = {2,1,4,5,3,1,1,3};
        System.out.println(massage.massage2(nums));
    }

    public int massage(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        return dp[nums.length - 1];
    }

    public int massage2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        int before2Sum = nums[0], before1Sum = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int curSum = Math.max(before1Sum, before2Sum + nums[i]);
            before2Sum = before1Sum;
            before1Sum = curSum;
        }

        return before1Sum;
    }
}
