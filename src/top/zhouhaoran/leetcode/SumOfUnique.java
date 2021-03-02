package top.zhouhaoran.leetcode;

import java.util.*;

public class SumOfUnique {
    public static void main(String[] args) {
        SumOfUnique sumOfUnique = new SumOfUnique();
        int[] nums = {1, 2, 3, 2};
        System.out.println(sumOfUnique.sumOfUnique(nums));
    }

    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                sum += entry.getKey();
            }
        }

        return sum;
    }
}
