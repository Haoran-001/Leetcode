package top.zhouhaoran.leetcode;

import java.util.Arrays;

public class RunningSum {
    public static void main(String[] args) {
        RunningSum runningSum = new RunningSum();
        int[] nums = {1,2,3,4};
        int[] ans = runningSum.runningSum(nums);
        System.out.println(Arrays.toString(ans));
    }

    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i-1];
        }

        return nums;
    }
}
