package top.zhouhaoran.leetcode;

public class ExchangeBits {
    public static void main(String[] args) {
        ExchangeBits exchangeBits = new ExchangeBits();
        System.out.println(exchangeBits.exchangeBits(3));
    }

    public int exchangeBits(int num) {
        int bit1 = 0, bit2 = 0;
        int num1 = num, num2 = 0;
        int ans = 0;
        int i = 0;

        while (num1 > 0) {
            bit1 = num1 & 1;
            num2 = num1 >> 1;
            bit2 = num2 & 1;

            num1 = num1 >> 2;
            ans = ans + (bit2 << i) + (bit1 << (i + 1));
            i =  i + 2;
        }

        return ans;
    }
}
