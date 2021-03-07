package top.zhouhaoran.leetcode;

import java.util.*;

public class FindLHS {
    public static void main(String[] args) {
        FindLHS findLHS = new FindLHS();
        int[] nums = {1,3,2,2,5,2,3,7};
        System.out.println(findLHS.findLHS2(nums));
    }

    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                ans = Math.max(ans, map.get(key) + map.get(key + 1));
            }
        }

        return ans;
    }

    public int findLHS2(int[] nums) {
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            boolean flag = false;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                } else if (nums[i] + 1 == nums[j]) {
                    count++;
                    flag = true;
                }
            }

            if (flag) {
                ans = Math.max(ans, count);
            }
        }

        return ans;
    }
}
