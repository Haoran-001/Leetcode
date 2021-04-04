package top.zhouhaoran.leetcode;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {10, 26, 30, 31, 47, 60};
        int target = 40;
        System.out.println(Arrays.toString(twoSum.twoSum(nums, target)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{target - nums[i], nums[i]};
            }
            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}
