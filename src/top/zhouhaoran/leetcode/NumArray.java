package top.zhouhaoran.leetcode;


public class NumArray {
    int[] nums;
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange2(0, 1));
        System.out.println(numArray.sumRange2(1, 4));
    }

//    public NumArray(int[] nums) {
//        this.nums = nums;
//    }

    public int sumRange(int i, int j) {
        int ans = 0;
        for (int index = i; i <= j; i++) {
            ans += nums[i];
        }

        return ans;
    }

    private int[] sum;
    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
    }

    public int sumRange2(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}
