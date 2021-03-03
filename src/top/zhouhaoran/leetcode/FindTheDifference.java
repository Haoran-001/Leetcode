package top.zhouhaoran.leetcode;

import java.util.*;

public class FindTheDifference {
    public static void main(String[] args) {
        FindTheDifference findTheDifference = new FindTheDifference();
        String s = "abcd", t = "abcde";
        System.out.println(findTheDifference.findTheDifference2(s, t));
    }

    public char findTheDifference(String s, String t) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            map[c - 'a']--;
            if (map[c - 'a'] == -1) {
                return c;
            }
        }

        return ' ';
    }

    public char findTheDifference2(String s, String t) {
        int ans1 = 0, ans2 = 0;

        for (char c : s.toCharArray()) {
            ans1 += c;
        }

        for (char c : t.toCharArray()) {
            ans2 += c;
        }

        return (char)(ans2 - ans1);
    }
}
