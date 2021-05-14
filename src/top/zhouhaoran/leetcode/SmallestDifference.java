package top.zhouhaoran.leetcode;

import java.util.*;

public class SmallestDifference {
    public static void main(String[] args) {
        SmallestDifference smallestDifference = new SmallestDifference();
        int[] a = {1, 3, 15, 11, 2}, b = {23, 127, 235, 19, 8};
        int ans = smallestDifference.smallestDifference(a, b);
        System.out.println(ans);
    }

    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0, j = 0;
        long ans = Long.MAX_VALUE;

        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                return 0;
            } else if (a[i] > b[j]) {
                ans = Math.min(ans, (long)a[i] - (long)b[j]);
                j++;
            } else if (a[i] < b[j]) {
                ans = Math.min(ans, (long)b[j] - (long)a[i]);
                i++;
            }
        }

        return (int)ans;
    }
}
