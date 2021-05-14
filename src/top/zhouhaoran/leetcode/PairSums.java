package top.zhouhaoran.leetcode;

import java.util.*;

public class PairSums {
    public static void main(String[] args) {
        PairSums pairSums = new PairSums();
        int[] nums = {6, 6, 6};
        int target = 12;
        List<List<Integer>> ans = pairSums.pairSums2(nums, target);
        System.out.println(ans);
    }

    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        if (nums == null || nums.length <= 1) {
            return ans;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num1 : nums) {
            int num2 = target - num1;

            if (!map.containsKey(num2)) {
                continue;
            }

            int count1 = map.get(num1);

            if (count1 <= 0) {
                continue;
            }
            count1--;
            map.put(num1, count1);

            int count2 = map.get(num2);
            if (count2 <= 0) {
                continue;
            }
            count2--;
            map.put(num2, count2);

            ans.add(Arrays.asList(num1, num2));
        }

        return ans;
    }

    public List<List<Integer>> pairSums2(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        if (nums == null || nums.length <= 1) {
            return ans;
        }

        Arrays.sort(nums);

        int left = 0, right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                ans.add(Arrays.asList(nums[left], nums[right]));
                left++;
                right--;
            } else if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            }
        }

        return ans;
    }
}
