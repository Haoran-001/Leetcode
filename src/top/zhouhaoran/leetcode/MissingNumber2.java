package top.zhouhaoran.leetcode;

import java.util.Arrays;

public class MissingNumber2 {
    public static void main(String[] args) {
        MissingNumber2 missingNumber2 = new MissingNumber2();
        int[] nums = {3, 0, 1};
        System.out.println(missingNumber2.missingNumber(nums));
    }

    public int missingNumber(int[] nums) {
        int len = nums.length;
        int expectedSum = ((len + 1) * (len)) / 2;
        int sum = Arrays.stream(nums).sum();
        int expectedNum = expectedSum - sum;

        return expectedNum;
    }
}
