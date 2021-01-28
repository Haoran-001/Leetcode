package top.zhouhaoran.leetcode;

import java.util.HashSet;
import java.util.Set;

public class FindRepeatNumber {
    public static void main(String[] args) {
        FindRepeatNumber findRepeatNumber = new FindRepeatNumber();
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber.findRepeatNumber(nums));
    }

    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }

        return -1;
    }
}
