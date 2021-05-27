package top.zhouhaoran.leetcode;

import java.util.Arrays;

public class StrToInt {
    public static void main(String[] args) {
        StrToInt strToInt = new StrToInt();
        System.out.println(strToInt.strToInt("+1"));
    }

    public int strToInt(String str) {
        str = str.trim();

        if (str.length() == 0 || str.length() == 1 && !Character.isDigit(str.charAt(0)))  {
            return 0;
        }

        if (str.length() >= 2) {
            char c1 = str.charAt(0), c2 = str.charAt(1);
            if (!Character.isDigit(c1) && !Character.isDigit(c2)) {
                return 0;
            }
        }

        boolean negativeSymbol = false;
        int start = 0;

        if (str.charAt(0) == '-') {
            negativeSymbol = true;
            start = 1;
        }

        if (str.charAt(0) == '+') {
            start = 1;
        }

        long ans = 0;
        for (; start < str.length(); start++) {
            if (!Character.isDigit(str.charAt(start))) {
                break;
            }

            if (ans > 2147483648L) {
                break;
            }

            ans = ans * 10;

            long temp = str.charAt(start) - '0';
            ans += temp;
        }

        if (negativeSymbol) {
            ans = -ans;
        }

        if (ans > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (ans < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int)ans;
    }
}
