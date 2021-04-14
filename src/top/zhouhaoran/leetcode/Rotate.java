package top.zhouhaoran.leetcode;

import java.util.Arrays;

public class Rotate {
    public static void main(String[] args) {
        Rotate rotate = new Rotate();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 10004;
        rotate.rotate2(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] tempArray = new int[n];

        for (int i = 0; i < n; i++) {
            tempArray[(i + k) % n] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = tempArray[i];
        }
    }

    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverseArray(nums, 0, n - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, n - 1);
    }

    // 1 2 3 4 5 6 7  k = 3
    // 7 6 5 4 3 2 1
    // 5 6 7 1 2 3 4
    private void reverseArray(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}
