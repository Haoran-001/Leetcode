package top.zhouhaoran.leetcode;

import java.util.*;

public class LemonadeChange {
    public static void main(String[] args) {
        LemonadeChange lemonadeChange = new LemonadeChange();
        int[] bills = {5, 5, 5, 10, 20};
        boolean ans = lemonadeChange.lemonadeChange(bills);
        System.out.println(ans);
    }

    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;

        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else if (bill == 20) {
                if (ten > 0 && five > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
