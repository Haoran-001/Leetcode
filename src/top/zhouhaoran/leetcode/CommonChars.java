package top.zhouhaoran.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonChars {
    public static void main(String[] args) {
        CommonChars commonChars = new CommonChars();
        String[] A = {"bella", "call", "ddll"};
        List<String> ans = commonChars.commonChars(A);
        System.out.println(ans);
    }

    public List<String> commonChars(String[] A) {
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);

        for (int i = 0; i < A.length; i++) {
            int[] freq = new int[26];
            for (int j = 0; j < A[i].length(); j++) {
                char c = A[i].charAt(j);
                freq[c - 'a']++;
            }
            for (int k = 0; k < 26; k++) {
                minFreq[k] = Math.min(minFreq[k], freq[k]);
            }
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < minFreq[i]; j++) {
                ans.add(String.valueOf((char)(i + 'a')));
            }
        }

        return ans;
    }
}
