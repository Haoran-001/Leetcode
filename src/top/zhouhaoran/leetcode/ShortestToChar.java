package top.zhouhaoran.leetcode;

import java.util.Arrays;

public class ShortestToChar {
    public static void main(String[] args) {
        ShortestToChar shortestToChar = new ShortestToChar();
        String s = "loveleetcode";
        char c = 'e';
        int[] ans = shortestToChar.shortestToChar(s, c);
        System.out.println(Arrays.toString(ans));
    }

    public int[] shortestToChar(String s, char c) {
        int[] ans = new int[s.length()];

        int prev = Integer.MIN_VALUE / 2;
        // 先从左向右遍历
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) prev = i;
            ans[i] = i - prev;
        }

        prev = Integer.MAX_VALUE / 2;
        // 再从右向左遍历
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) prev = i;
            ans[i] = Math.min(prev - i, ans[i]);
        }

        return ans;
    }
}
