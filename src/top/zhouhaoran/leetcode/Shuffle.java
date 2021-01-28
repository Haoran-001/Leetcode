package top.zhouhaoran.leetcode;

import java.util.Arrays;

public class Shuffle {
    public static void main(String[] args) {
        Shuffle shuffle = new Shuffle();
        int[] nums = {2,5,1,3,4,7};
        int n = 3;
        System.out.println(Arrays.toString(shuffle.shuffle(nums, n)));
    }

    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        int i = 0;
        int j = 0, k = n;
        while (i < 2 * n) {
            if (i % 2 == 0) {
                res[i++] = nums[j++];
            } else {
                res[i++] = nums[k++];
            }
        }

        return res;
    }
}
