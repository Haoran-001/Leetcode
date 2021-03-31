package top.zhouhaoran.leetcode;

import java.util.*;

public class LongestNiceSubstring {
    public static void main(String[] args) {
        LongestNiceSubstring longestNiceSubstring = new LongestNiceSubstring();
        System.out.println(longestNiceSubstring.longestNiceSubstring2("c"));
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

    public void helper(char[] charArray, int left, int right) {
        if (left > right) {
            return;
        }

        Set<Character> set = new HashSet<>();
        for (int i = left; i <= right; i++) {
            set.add(charArray[i]);
        }

        for (int i = left; i <= right; i++) {
            char c = charArray[i];
            if (Character.isUpperCase(c) && !set.contains(Character.toLowerCase(c)) || Character.isLowerCase(c) && !set.contains(Character.toUpperCase(c))) {
                charArray[i] = '0';
                helper(charArray, left, i - 1);
                helper(charArray, i + 1, right);
            }
        }
    }

    private String longestNiceSubstring2(String s) {
        char[] sCharArray = s.toCharArray();
        helper(sCharArray, 0, sCharArray.length - 1);

        String res = "";
        String tempString = String.valueOf(sCharArray);
        String[] tempStringArray = tempString.split("0");

        for (String str : tempStringArray) {
            if (str.length() > res.length()) {
                res = str;
            }
        }

        return res;
    }
}
