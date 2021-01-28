package top.zhouhaoran.leetcode;

import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();
        int[] nums = {0, 1};
        System.out.println(missingNumber.missingNumber2(nums));
    }

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        return nums.length;
    }

    public int missingNumber2(int[] nums) {
        int[] ans = new int[nums.length + 1];
        for (int num: nums) {
            ans[num] = 1;
        }

        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == 0) {
                return i;
            }
        }

        return 0;
    }
}
