package top.zhouhaoran.leetcode;

import java.util.Locale;

public class AreAlmostEqual {
    public static void main(String[] args) {
        AreAlmostEqual areAlmostEqual = new AreAlmostEqual();
        String s1 = "aa", s2 = "ac";
        boolean ans = areAlmostEqual.areAlmostEqual(s1, s2);
        System.out.println(ans);
    }

    public boolean areAlmostEqual(String s1, String s2) {
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();

        int i = 0;
        int k = 0;
        int x = -1, y = -1;
        int count = 0;

        for (i = 0; i < s1Arr.length; i++) {
            if (s1Arr[i] != s2Arr[i] && k % 2 == 0) {
                x = i;
                k++;
            } else if (s1Arr[i] != s2Arr[i] && k % 2 == 1) {
                y = i;
                k++;
            }

            if (x != -1 && y != -1) {
                if (count >= 1 || s1Arr[x] != s2Arr[y] || s2Arr[x] != s1Arr[y]) {
                    return false;
                }
                count++;
                x = -1;
                y = -1;
            }
        }

        if (x == -1 && y == -1) {
            return true;
        } else {
            return false;
        }
    }
}
