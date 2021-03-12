package top.zhouhaoran.leetcode;

import java.util.Arrays;

public class CheckOnesSegment {
    public static void main(String[] args) {
        CheckOnesSegment checkOnesSegment = new CheckOnesSegment();
        System.out.println(checkOnesSegment.checkOnesSegment3("1111000011"));
    }

    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }

    public boolean checkOnesSegment2(String s) {
        String[] strArray = s.split("0");
        int count = 0;

        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i] != null && strArray[i].length() > 0) {
                count++;
            }
        }

        return count == 1;
    }

    public boolean checkOnesSegment3(String s) {
        int times = 0;
        int i, j = 0;
        boolean flag = false;
        for (i = 0; i < s.length();) {
            if (s.charAt(i) == '1') {
                times++;
                for (j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) != '1') {
                        flag = true;
                        break;
                    }
                }
                if (j == s.length()) {
                    flag = true;
                }
            }

            if (flag) {
                i = j;
                flag = false;
            } else {
                i++;
            }
        }

        return times == 1;
    }
}
