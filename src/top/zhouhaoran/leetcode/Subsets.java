package top.zhouhaoran.leetcode;

import java.util.*;

public class Subsets {
    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = {1, 2, 3};
        System.out.println(subsets.subsets5(nums));
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

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ansItem = new ArrayList<>();
        int n = nums.length;

        for (int mask = 0; mask < 1 << n; mask++) {
            ansItem.clear();

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    ansItem.add(nums[i]);
                }
            }
            ans.add(new ArrayList<>(ansItem));
        }

        return ans;
    }

    List<Integer> t = new ArrayList<>();
    List<List<Integer>> ans2 = new ArrayList<>();

    public List<List<Integer>> subsets4(int[] nums) {
        dfs(0, nums);

        return ans2;
    }

    public void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans2.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> ansItem = new ArrayList<>();

    public List<List<Integer>> subsets5(int[] nums) {
        for (int len = 0; len <= nums.length; len++) {
            helper(len, 0, nums);
        }

        return ans;
    }

    private void helper(int n, int start, int[] nums) {
        if (ansItem.size() == n) {
            ans.add(new ArrayList<>(ansItem));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            ansItem.add(nums[i]);
            helper(n, i + 1, nums);
            ansItem.remove(ansItem.size() - 1);
        }
    }
}
