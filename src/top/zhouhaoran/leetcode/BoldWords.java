package top.zhouhaoran.leetcode;

import java.sql.SQLOutput;
import java.util.*;

public class BoldWords {
    public static void main(String[] args) {
        BoldWords boldWords = new BoldWords();
        String[] words = {"ccb","b","d","cba","dc"};
        String S = "eeaadadadc";
        System.out.println(boldWords.boldWords(words, S));
    }

    public String boldWords(String[] words, String S) {
        int n = S.length();
        boolean[] mask = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < words.length; j++) search: {
                for (int k = 0; k < words[j].length(); k++) {
                    if (i + k >= n || words[j].charAt(k) != S.charAt(i + k)) {
                        break search;
                    }
                }

                for (int l = i; l < i + words[j].length(); l++) {
                    mask[l] = true;
                }
            }
        }

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (mask[i] && (i == 0 || !mask[i - 1])) {
                ans.append("<b>");
            }
            ans.append(S.charAt(i));
            if (mask[i] && (i == n - 1 || !mask[i + 1])) {
                ans.append("</b>");
            }
        }

        return ans.toString();
    }
}
