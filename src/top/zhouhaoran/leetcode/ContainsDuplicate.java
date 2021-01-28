package top.zhouhaoran.leetcode;

import java.util.*;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = 0; i < map.size(); i++) {
            if (map.get(nums[i]) > 1) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
          if (!set.add(num)) {
              return true;
          }
        }
        return false;
    }

    public boolean containsDuplicate3(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        int[] nums = {1, 2, 3, 91};
        System.out.println(containsDuplicate.containsDuplicate(nums));
    }
}
