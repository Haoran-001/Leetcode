package top.zhouhaoran.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NumIdenticalPairs {
    public static void main(String[] args) {
        NumIdenticalPairs numIdenticalPairs = new NumIdenticalPairs();
        int[] nums = {1, 2, 3};
        System.out.println(numIdenticalPairs.numIdenticalPairs(nums));
    }

    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            int value = entry.getValue();
            if (value > 1) {
                count += (value * (value - 1)) / 2;
            }
        }

        return count;
    }
}
