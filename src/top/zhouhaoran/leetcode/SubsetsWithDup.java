package top.zhouhaoran.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class SubsetsWithDup {
    public static void main(String[] args) {
        int[] nums = {4, 4, 4, 1, 4};
        SubsetsWithDup subsetsWithDup = new SubsetsWithDup();
        System.out.println(subsetsWithDup.subsetsWithDup2(nums));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ansItem = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);


        for (int mask = 0; mask < 1 << n; mask++) {
            boolean flag = true;
            ansItem.clear();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    if (i > 0 && ((mask & (1 << (i - 1))) == 0) && nums[i] == nums[i - 1]) {
                        flag = false;
                        break;
                    }
                    ansItem.add(nums[i]);
                }
            }

            if (flag) {
                ans.add(new ArrayList<>(ansItem));
            }
        }

        return ans;
    }

    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ansItem = new ArrayList<>();
        ans.add(ansItem);

        for (int num : nums) {
            for (int i = 0, j = ans.size(); i < j; i++) {
                ansItem = new ArrayList<>(ans.get(i));
                ansItem.add(num);
                ansItem.sort((a, b) -> a-b);
                ans.add(new ArrayList<>(ansItem));
            }
        }

        return ans.stream().collect(Collectors.toSet()).stream().collect(Collectors.toList());
    }
}
