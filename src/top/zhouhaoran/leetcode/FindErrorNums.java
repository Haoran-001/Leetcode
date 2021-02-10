package top.zhouhaoran.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindErrorNums {
    public static void main(String[] args) {
        FindErrorNums findErrorNums = new FindErrorNums();
        int[] nums = {2, 2};
        System.out.println(Arrays.toString(findErrorNums.findErrorNums(nums)));
    }

    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int[] ans = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                ans[0] = nums[i];
            }
        }

        for (int i = 1; i <= nums.length; i++) {
            if (set.add(i)) {
                ans[1] = i;
            }
        }

        return ans;
    }
}
