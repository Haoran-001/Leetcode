package top.zhouhaoran.leetcode;

import java.util.TreeMap;

public class LongestSubarray {
    public static void main(String[] args) {
        LongestSubarray longestSubarray = new LongestSubarray();
        int[] nums = {8, 2, 4, 7};
        int limit = 4;
        System.out.println(longestSubarray.longestSubarray(nums, limit));
    }

    // 8 2 4 7

    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int left = 0, right = 0;
        int ans = 0;

        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }

        return ans;
    }
}
