package top.zhouhaoran.leetcode;

public class MinStartValue {
    public static void main(String[] args) {
        MinStartValue minStartValue = new MinStartValue();
        int[] nums = {1, 2};
        System.out.println(minStartValue.minStartValue(nums));
    }

    public int minStartValue(int[] nums) {
        int ans = 1, sum;
        while (true) {
            int delta = ans;
            boolean failure = false;
            for (int i = 0; i < nums.length; i++) {
                sum = nums[i] + delta;
                delta = sum;
                if (sum <= 0) {
                    failure = true;
                    break;
                }
            }
            if (failure) {
                ans++;
            } else {
                return ans;
            }
        }
    }
}