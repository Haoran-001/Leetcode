package top.zhouhaoran.leetcode;

import java.util.Arrays;

public class LongestPalindrome {
    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("abccccdd"));
    }

    public int longestPalindrome(String s) {
        int ans = 0;
        int[] map = new int[128];

        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
        }

        for (int num : map) {
            ans += num / 2 * 2;
            if (num % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }

        return ans;
    }
}
