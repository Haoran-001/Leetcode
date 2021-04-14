package top.zhouhaoran.leetcode;

import java.util.*;

public class Subsets {
    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = {1, 2, 3};
        System.out.println(subsets.subsets(nums));
    }

    // 1 2 3
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ansItem = new ArrayList<>();
        ans.add(ansItem);

        for (int num : nums) {
            for (int i = 0, j = ans.size(); i < j; i++) {
                ansItem = new ArrayList<>(ans.get(i));
                ansItem.add(num);
                ans.add(ansItem);
            }
        }

        return ans;
    }
}
