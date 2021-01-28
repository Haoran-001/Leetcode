package top.zhouhaoran.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDisappearedNumbers {
    public static void main(String[] args) {
        FindDisappearedNumbers findDisappearedNumbers = new FindDisappearedNumbers();
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers.findDisappearedNumbers(nums));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int[] map = new int[nums.length + 1];

        for (int num : nums) {
            map[num]++;
        }

        for (int i = 1; i < map.length; i++) {
            if (map[i] == 0) {
                ans.add(i);
            }
        }

        return ans;
    }
}
