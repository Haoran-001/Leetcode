package top.zhouhaoran.leetcode;

import java.util.*;

public class LongestNiceSubstring {
    public static void main(String[] args) {
        LongestNiceSubstring longestNiceSubstring = new LongestNiceSubstring();
        System.out.println(longestNiceSubstring.longestNiceSubstring("YazaAay"));
    }

    public String longestNiceSubstring(String s) {
        String longestNiceSubstring = "";
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j > i; j--) {
                String substring = s.substring(i, j+1);
                if (isNiceSubstring(substring)) {
                    if (longestNiceSubstring.length() < substring.length()) {
                        longestNiceSubstring = substring;
                    }
                }
            }
        }

        return longestNiceSubstring;
    }

    private boolean isNiceSubstring(String substring) {
        Set<Character> set = new HashSet<>();
        for (char c : substring.toCharArray()) {
            set.add(c);
        }

        Iterator<Character> iter = set.iterator();
        while (iter.hasNext()) {
            char c = iter.next();
            if (Character.isLowerCase(c)) {
                if (!set.contains(Character.toUpperCase(c))) {
                    return false;
                }
            } else if (Character.isUpperCase(c)) {
                if (!set.contains(Character.toLowerCase(c))) {
                    return false;
                }
            }
        }

        return true;
    }
}
