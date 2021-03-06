package top.zhouhaoran.leetcode;

import java.util.*;

public class DistributeCandies {
    public static void main(String[] args) {
        DistributeCandies distributeCandies = new DistributeCandies();
        var ans = distributeCandies.distributeCandies3(new int[]{1, 1, 2, 3});
        System.out.println(ans);
        System.out.println(Integer.MIN_VALUE + "~" + Integer.MAX_VALUE);
        System.out.println(Long.MIN_VALUE + "~" + Long.MAX_VALUE);
        System.out.println(Float.MIN_VALUE + "~" + Float.MAX_VALUE);
        System.out.println(Double.MIN_VALUE + "~" + Double.MAX_VALUE);


    }

    private int maxKind = 0;

    public int distributeCandies(int[] nums) {
        permute(nums, 0);

        return maxKind;
    }

    private void permute(int[] nums, int l) {
        if (l == nums.length - 1) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length / 2; i++) {
                set.add(nums[i]);
            }
            maxKind = Math.max(maxKind, set.size());
        }

        for (int i = l; i < nums.length; i++) {
            swap(nums, i, l);
            permute(nums, l + 1);
            swap(nums, i, l);
        }
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public int distributeCandies2(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        return Math.min(set.size(), nums.length / 2);
    }

    // 1 1 2 3
    public int distributeCandies3(int[] candies) {
        Arrays.sort(candies);
        int count = 1;
        for (int i = 1; i <= candies.length - 1 && count < candies.length / 2; i++) {
            if (candies[i] > candies[i - 1]) {
                count++;
            }
        }

        return count;
    }

    public int distributeCandies4(int[] candies) {
        int count = 0;  // 统计元素值不相同的元素个数
        for (int i = 0; i < candies.length && count < candies.length / 2; i++) {
            if (candies[i] != Integer.MIN_VALUE) {
                count++;
                for (int j = i + 1; j < candies.length; j++) {
                    if (candies[i] == candies[j]) {
                        candies[j] = Integer.MIN_VALUE;
                    }
                }
            }
        }

        return count;
    }
}