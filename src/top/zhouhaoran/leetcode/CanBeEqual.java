package top.zhouhaoran.leetcode;

import java.util.Arrays;

public class CanBeEqual {
    public static void main(String[] args) {
        CanBeEqual canBeEqual = new CanBeEqual();
        int[] target = {1, 2, 3, 4}, arr = {2, 4, 3, 1};
        System.out.println(canBeEqual.canBeEqual(target, arr));
    }

    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        boolean ans = Arrays.equals(arr, target);

        return ans;
    }
}
