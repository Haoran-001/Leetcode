package top.zhouhaoran.leetcode;

import java.util.*;

public class ThirdMax {
    public static void main(String[] args) {
        ThirdMax thirdMax = new ThirdMax();
        int[] nums = {0, 1,1, 1,1, 2, 2, 2, 2};
        System.out.println(thirdMax.thirdMax2(nums));
    }

    public int thirdMax(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        if (map.size() < 3) {
            return list.get(0).getKey();
        }

        return list.get(2).getKey();
    }
    // 1 2 3 4
    public int thirdMax2(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;

        if (len < 3) {
            return nums[len - 1];
        }

        int maxIndex = 1;

        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                maxIndex++;
            } else if (nums[i] == nums[i+1]) {
                continue;
            }

            if (maxIndex == 3) {
                return nums[i];
            }
        }

        return nums[len - 1];
    }
}
