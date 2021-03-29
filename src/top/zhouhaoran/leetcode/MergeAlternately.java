package top.zhouhaoran.leetcode;

import java.util.Locale;

public class MergeAlternately {
    public static void main(String[] args) {
        MergeAlternately mergeAlternately = new MergeAlternately();
        String word1 = "abc", word2 = "pqrtttt";
        String ans = mergeAlternately.mergeAlternately(word1, word2);
        System.out.println(ans);
    }

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        char[] word1Arr = word1.toCharArray();
        char[] word2Arr = word2.toCharArray();

        int i = 0, j = 0;

        while (i < word1Arr.length && j < word2Arr.length) {
            sb.append(word1Arr[i++]);
            sb.append(word2Arr[j++]);
        }

        while (i < word1Arr.length) {
            sb.append(word1Arr[i++]);
        }

        while (j < word2Arr.length) {
            sb.append(word2Arr[j++]);
        }

        return sb.toString();
    }
}
