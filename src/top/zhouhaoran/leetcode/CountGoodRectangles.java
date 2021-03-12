package top.zhouhaoran.leetcode;

import java.util.Arrays;

public class CountGoodRectangles {
    public static void main(String[] args) {
        CountGoodRectangles countGoodRectangles = new CountGoodRectangles();
        int[][] rectangles = {{5,8},{3,9},{5,12},{16,5}};
        System.out.println(countGoodRectangles.countGoodRectangles2(rectangles));
    }

    public int countGoodRectangles(int[][] rectangles) {
        int k = Integer.MAX_VALUE;
        int[] maxLen = new int[rectangles.length];
        int index = 0;
        int count = 0;
        int maxNum = 0;

        for (int[] rectangle : rectangles) {
            for (int len : rectangle) {
                k = Math.min(k, len);
            }
            maxLen[index++] = k;
            k = Integer.MAX_VALUE;
        }

        for (int i = 0; i < maxLen.length; i++) {
            maxNum = Math.max(maxNum, maxLen[i]);
        }

        for (int i = 0; i < maxLen.length; i++) {
            if (maxLen[i] == maxNum) {
                count++;
            }
        }

        return count;
    }

    public int countGoodRectangles2(int[][] rectangles) {
        int maxLen = 0, ans = 0;

        for (int[] rectangle : rectangles) {
            int len = Math.min(rectangle[0], rectangle[1]);

            if (len > maxLen) {
                maxLen = len;
                ans = 1;
            } else if (len == maxLen) {
                ans++;
            } else if (len < maxLen) {
                continue;
            }
        }

        return ans;
    }
}
