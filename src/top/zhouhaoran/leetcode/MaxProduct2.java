package top.zhouhaoran.leetcode;

public class MaxProduct2 {
    public static void main(String[] args) {
        MaxProduct2 maxProduct = new MaxProduct2();
        int[] nums = {2, 3, -2, 4};
        System.out.println(maxProduct.maxProduct(nums));
    }

    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] minF = new int[n], maxF = new int[n];

        System.arraycopy(nums, 0, minF, 0, n);
        System.arraycopy(nums, 0, maxF, 0, n);

        for (int i = 1; i < n; i++) {
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
        }

        int ans = maxF[0];
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, maxF[i]);
        }

        return ans;
    }
}
