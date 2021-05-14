package top.zhouhaoran.leetcode;

public class MinOperations3 {
    public static void main(String[] args) {
        MinOperations3 minOperations = new MinOperations3();
        int[] nums = {1, 5, 2, 4, 1};
        System.out.println(minOperations.minOperations2(nums));
    }

    public int minOperations(int[] nums) {
        int max = nums[0];
        int ans = 0;

        for (int i = 1; i < nums.length; i++) {
            if (max >= nums[i]) {
                max++;
            } else {
                max = nums[i];
            }
            ans += (max - nums[i]);
        }

        return ans;
    }

    public int minOperations2(int[] nums) {
        int temp = nums[0];
        int ans = 0;

        for (int i = 1; i < nums.length; i++) {
            if (temp < nums[i]) {
                temp = nums[i];
            } else if (temp >= nums[i]) {
                temp++;
                ans += (temp - nums[i]);
            }
        }

        return ans;
    }
}
