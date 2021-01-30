package top.zhouhaoran.leetcode;

import java.util.Arrays;

public class MaxProduct {
    public static void main(String[] args) {
        int[] nums = {3, 7};
        MaxProduct maxProduct = new MaxProduct();
        int ans = maxProduct.maxProduct(nums);
        System.out.println(ans);
    }

    public int maxProduct(int[] nums) {
        Arrays.sort(nums);

        int i1 = nums.length - 1;
        int i2 = nums.length - 2;

        int ans = (nums[i1] - 1) * (nums[i2] - 1);

        return ans;
    }
}
