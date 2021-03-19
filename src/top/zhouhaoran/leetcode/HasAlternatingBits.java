package top.zhouhaoran.leetcode;

public class HasAlternatingBits {
    public static void main(String[] args) {
        HasAlternatingBits hasAlternatingBits = new HasAlternatingBits();
        System.out.println(hasAlternatingBits.hasAlternatingBits(3));
    }

    public boolean hasAlternatingBits(int n) {
        int bit1 = 0, bit2 = 0;
        int num1 = n, num2 = 0;

        while (num1 > 0) {
            bit1 = num1 & 1;
            num2 = num1 >> 1;
            bit2 = num2 & 1;

            if ((bit1 ^ bit2) == 0) {
                return false;
            }
            num1 = num1 >> 1;
        }

        return true;
    }
}
