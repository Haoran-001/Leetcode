package top.zhouhaoran.leetcode;

public class IsUgly {
    public static void main(String[] args) {
        IsUgly isUgly = new IsUgly();
        boolean ans = isUgly.isUgly(14);
        System.out.println(ans);
    }

    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }

        while (true) {
            if (num == 1 || num == 2 || num == 3 || num == 5) {
                return true;
            } else if (num % 2 == 0) {
                num /= 2;
            } else if (num % 3 == 0) {
                num /= 3;
            } else if (num % 5 == 0) {
                num /= 5;
            } else {
                return false;
            }
        }
    }
}
