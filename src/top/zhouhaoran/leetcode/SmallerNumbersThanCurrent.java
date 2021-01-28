package top.zhouhaoran.leetcode;

import java.util.Arrays;


public class SmallerNumbersThanCurrent {
    public static void main(String[] args) {
        SmallerNumbersThanCurrent smallerNumbersThanCurrent = new SmallerNumbersThanCurrent();
        int[] nums = {8, 1, 2, 2, 3};
        int[] ans = smallerNumbersThanCurrent.smallerNumbersThanCurrent3(nums);
        System.out.println(Arrays.toString(ans));
    }
// 1 2 2 3 8
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    cnt++;
                }
            }
            ans[i] = cnt;
        }
        return ans;
    }

    public int[] smallerNumbersThanCurrent2(int[] nums) {
        int[] nums2 = nums.clone();
        Arrays.sort(nums2);
        for (int i = 0; i < nums.length; i++) {
            int idx = lowerBound(nums2, nums[i]);
            nums[i] = idx;
        }

        return nums;

    }

    private int lowerBound(int[] nums, int target) {
        int leftIndex = 0, rightIndex = nums.length - 1;
        while (leftIndex < rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;
            if (nums[midIndex] >= target) {
                rightIndex = midIndex;
            } else {
                leftIndex = midIndex + 1;
            }
        }

        return leftIndex;
    }

    public int[] smallerNumbersThanCurrent3(int[] nums) {
        int[] cnt = new int[101];

        for (int i = 0; i < nums.length; i++) {
            cnt[nums[i]]++;
        }
        for (int i = 1; i <= 100; i++) {
            cnt[i] = cnt[i] + cnt[i - 1];
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i] == 0 ? 0 : cnt[nums[i] - 1];
        }

        return res;
    }
}
