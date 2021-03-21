package top.zhouhaoran.leetcode;

public class ConvertInteger {
    public static void main(String[] args) {
        ConvertInteger convertInteger = new ConvertInteger();
        System.out.println(convertInteger.convertInteger2(826966453, -729934991));
    }

    public int convertInteger(int A, int B) {
        int C = A ^ B;
        int count = 0;

        for (int i = 0; i < 32; i++) {
            count += C & 1;
            C >>= 1;
        }

        return count;
    }

    public int convertInteger2(int A, int B) {
        int C = A ^ B;
        int count = 0;

        while (C != 0) {
            count += C & 1;
            C >>>= 1;
        }

        return count;
    }
}
