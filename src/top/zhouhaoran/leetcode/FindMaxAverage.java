package top.zhouhaoran.leetcode;

public class FindMaxAverage {
    public static void main(String[] args) {
        FindMaxAverage findMaxAverage = new FindMaxAverage();
        int[] nums = {4, 0, 4, 3, 3};
        int k = 5;
        double ans = findMaxAverage.findMaxAverage(nums, k);
        System.out.println(ans);
    }

    public double findMaxAverage(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];

        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

        double maxAverage = (double)sum[k-1] / k;
        for (int i = k; i <= sum.length - 1; i++) {
            double curAverage = (double)(sum[i] - sum[i - k]) / k;
            maxAverage = Math.max(maxAverage, curAverage);
        }

        return maxAverage;
    }
}
