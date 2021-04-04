package top.zhouhaoran.leetcode;

import java.util.Arrays;

public class NumberOfLines {
    public static void main(String[] args) {
        NumberOfLines numberOfLines = new NumberOfLines();
        int[] widths = {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String s = "bbbcccdddaaa";
        int[] ans = numberOfLines.numberOfLines(widths, s);
        System.out.println(Arrays.toString(ans));
    }

    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1;
        int finalLinePos = 0;

        for (char c : s.toCharArray()) {
            int k = widths[c - 'a'];
            if (finalLinePos + k <= 100) {
                finalLinePos += k;
            } else {
                lines++;
                finalLinePos = k;
            }
        }

        return new int[] {lines, finalLinePos};
    }
}
