package top.zhouhaoran.leetcode;

import java.util.*;

public class CountLetters {
    public static void main(String[] args) {
        CountLetters countLetters = new CountLetters();
        String S = "aaaba";
        int ans = countLetters.countLetters(S);
        System.out.println(ans);
    }

    public int countLetters(String S) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int n = S.length();
        int ans = 0;

        for (int i = 0; i < n - 1; i++) {
            sb.append(S.charAt(i));
            if (S.charAt(i) != S.charAt(i + 1)) {
                list.add(sb.toString());
                sb.delete(0, sb.length());
            }
        }

        sb.append(S.charAt(n - 1));
        list.add(sb.toString());

        for (String s : list) {
            int len = s.length();
            ans += ((len + 1) * len) / 2;
        }

        return ans;
    }
}
