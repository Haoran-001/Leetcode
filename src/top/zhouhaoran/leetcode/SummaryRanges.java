package top.zhouhaoran.leetcode;

import java.util.*;

public class SummaryRanges {
    public static void main(String[] args) {
        SummaryRanges summaryRanges = new SummaryRanges();
        int[] nums = {1, 2};
        List<String> ans = summaryRanges.summaryRanges(nums);
        System.out.println(ans);
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();

        // 若数组元素为空返回空, 若数组只有一个元素, 则返回该元素
        if (nums == null || nums.length == 0) {
            return ans;
        }

        if (nums.length == 1) {
            ans.add("" + nums[0]);
            return ans;
        }


        int start = 0;
        int i;
        for (i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                if (start != i) {
                    ans.add(nums[start] + "->" + nums[i]);
                } else {
                    ans.add("" + nums[i]);
                }
                start = i + 1;
            }
        }

        if (nums[i] != nums[i - 1] + 1) {
            ans.add("" + nums[i]);
        } else {
            ans.add(nums[start] + "->" + nums[i]);
        }

        return ans;
    }
}
