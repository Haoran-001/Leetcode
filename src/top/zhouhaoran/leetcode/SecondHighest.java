package top.zhouhaoran.leetcode;

import java.util.*;

public class SecondHighest {
    public static void main(String[] args) {
        SecondHighest secondHighest = new SecondHighest();
        String s = "dfa12321afd";
        int ans = secondHighest.secondHighest(s);
        System.out.println(ans);
    }

    public int secondHighest(String s) {
        TreeSet<Integer> set = new TreeSet<>();

        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                set.add(c - '0');
            }
        }
        System.out.println(set);
        if (set.size() <= 1) {
            return -1;
        } else {
            set.pollLast();

            return set.pollLast();
        }
    }
}
