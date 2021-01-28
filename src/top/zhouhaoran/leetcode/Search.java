package top.zhouhaoran.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Search {
    public static void main(String[] args) {
        Search search = new Search();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(search.search2(nums, target));
        double d = 3.0 / 4;
        System.out.println(Math.round((d * 10)) / 10.0);
        double d2 = 10.0 / 7;
        System.out.println(d2);
        System.out.println(Math.round(d2 * Math.pow(10, 4)) / Math.pow(10, 4));
    }

    public int search(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return map.getOrDefault(target, 0);
    }

    public int search2(int[] nums, int target) {
        int count = 0;
        int startIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                startIndex = i;
                count++;
                break;
            }
        }

        if (startIndex == -1) {
            return 0;
        }

        for (int i = startIndex; i < nums.length - 1; i++) {
            if (nums[i] != nums[i+1]) {
                break;
            }
            count++;
        }

        return count;
    }
}
