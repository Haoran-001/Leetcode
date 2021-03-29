package top.zhouhaoran.leetcode;

import java.util.*;

public class NumDifferentIntegers {
    public static void main(String[] args) {
        NumDifferentIntegers numDifferentIntegers = new NumDifferentIntegers();
        String word = "1672789595912943";
        System.out.println(numDifferentIntegers.numDifferentIntegers(word));
    }

    public int numDifferentIntegers(String word) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';

                int j = i + 1;
                while (j < word.length() && Character.isDigit(word.charAt(j))) {
                    num = num * 10 + word.charAt(j) - '0';
                    j++;
                }

                i = j - 1;
                set.add(num);
            }
        }

        return set.size();
    }
}
