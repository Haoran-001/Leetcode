package top.zhouhaoran.leetcode;

import java.util.*;

public class FindClosest {
    public static void main(String[] args) {
        FindClosest findClosest = new FindClosest();
        String[] words = {"I","am","a","student","from","a","university","in","a","city"};
        String word1 = "a", word2 = "student";
        System.out.println(findClosest.findClosest(words, word1, word2));
    }

    public int findClosest(String[] words, String word1, String word2) {
        int minLength = Integer.MAX_VALUE;
        int start = -1, end = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                start = i;
            } else if (words[i].equals(word2)) {
                end = i;
            }

            if (start != -1 && end != -1) {
                minLength = Math.min(minLength, Math.abs(end - start));
            }
        }

        return minLength;
    }
}
