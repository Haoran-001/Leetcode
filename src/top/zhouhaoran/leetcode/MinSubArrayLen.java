package top.zhouhaoran.leetcode;

import java.util.Arrays;

public class MinSubArrayLen {
    public static void main(String[] args) {
        MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen.minSubArrayLen3(target, nums));
        System.out.println(Arrays.binarySearch(new int[]{1, 2, 2, 2,3}, 100));
        System.out.println(minSubArrayLen.binarySearch(new int[]{1, 2, 2, 2, 3}, 100));
    }

    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= target) {
                    ans = Math.min(ans, j - i + 1);
                }
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    /**
     * 使用前缀和加二分查找的方式
     * nums: 2 3 1 2 4 3     (原数组)
     * sums: 0 2 5 6 8 12 15 (前缀和)
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen2(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] sums = new int[n + 1];
        int ans = Integer.MAX_VALUE;

        // 首先计算前缀和
        for (int i = 1; i <= n; i++) {
            sums[i] += sums[i - 1] + nums[i - 1];
        }

        // 对数组中每个元素作为起始位置开始查找目标位target的最小长度
        for (int i = 0; i < n; i++) {
            int tempTarget = target + sums[i];

            int bound = Arrays.binarySearch(sums, tempTarget);

            if (bound < 0) {
                bound = -bound - 1;
            }

            if (bound <= n) {
                ans = Math.min(ans, bound - i);
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public int binarySearch(int[] arr, int k) {
        if (arr.length == 0) {
            return -1;
        }
        // 1 5 8  k = 3
        // left = 0, right = 2, mid = 1  k = 3 < arr[mid] = 5
        // right = 0
        // left = 0, right = 0, mid = 0 k = 3 > arr[mid] = 1
        // left  = 1
        // left = 1 and right = 0
        int n = arr.length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (k == arr[mid]) {
                return mid;
            } else if (k < arr[mid]) {
                right = mid - 1;
            } else if (k > arr[mid]) {
                left = mid + 1;
            }
        }

        return -left - 1;
    }

    public int binarySearch2(int[] arr, int k) {
        if (arr.length == 0) {
            return -1;
        }

        // 1 2 2 2 3   k = 2
        // left = 0, right = 4, mid = 2  k = 2 == arr[mid] == 2
        // right = 2
        // left = 0, right = 2  mid = 1 k = 2 == arr[mid] == 2
        // right = 1
        // left = 0, right = 1 mid = 0  k = 2 > arr[mid] = 1
        // left = 1
        // left = 1, right = 1 end!

        // 1 2 3 4 5 k = 3
        // left = 0, right = 4, mid = 2, k = 3 == arr[mid] = 3
        // right = 2
        // left = 0, right = 2, mid = 1, k = 3 > arr[mid] = 2
        // left = 2
        // left == 2, right == 2
        int n = arr.length;
        int left = 0, right = n - 1;

        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (k == arr[mid]) {
                right = mid;
            } else if (k < arr[mid]) {
                right = mid;
            } else if (k > arr[mid]) {
                left = mid + 1;
            }
        }

        return arr[right] == k ? right : -1;
    }

    public int minSubArrayLen3(int target, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int start = 0, end = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
