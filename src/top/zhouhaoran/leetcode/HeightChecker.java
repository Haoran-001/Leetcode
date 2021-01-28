package top.zhouhaoran.leetcode;

import java.util.Arrays;

public class HeightChecker {
    public static void main(String[] args) {
        HeightChecker heightChecker = new HeightChecker();
        int[] heights = {1, 1, 4, 2, 1, 3};
        int ans = heightChecker.heightChecker(heights);
        System.out.println(ans);
    }

    public int heightChecker(int[] heights) {
        int[] heights2 = heights.clone();
        Arrays.sort(heights2);
        int ans = 0; // ans记录两个数组数对应下标不同的数

        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != heights2[i]) {
                ans++;
            }
        }

        return ans;
    }
}
