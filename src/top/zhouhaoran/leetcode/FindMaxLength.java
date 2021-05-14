package top.zhouhaoran.leetcode;

import java.util.*;

public class FindMaxLength {
    public static void main(String[] args) {
        FindMaxLength findMaxLength = new FindMaxLength();
        int[] nums = {1, 1, 1};
        System.out.println(findMaxLength.findMaxLength2(nums));
    }

    public int findMaxLength(int[] nums) {
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            int ones = 0, zeros = 0;

            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 1) {
                    ones++;
                } else if (nums[j] == 0) {
                    zeros++;
                }

                if (ones == zeros) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    public int findMaxLength2(int[] nums) {
        int[] temp = new int[2 * nums.length + 1];
        Arrays.fill(temp, -2);
        temp[nums.length] = -1;
        int count = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (temp[count + nums.length] >= -1) {
                maxLen = Math.max(maxLen, i - temp[count + nums.length]);
            } else {
                temp[count + nums.length] = i;
            }
        }

        return maxLen;
    }
}
