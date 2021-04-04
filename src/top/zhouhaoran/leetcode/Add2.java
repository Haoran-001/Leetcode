package top.zhouhaoran.leetcode;

public class Add2 {
    public static void main(String[] args) {
        Add2 add2 = new Add2();
        System.out.println(add2.add(3, 4));
    }

    public int add(int a, int b) {
        int sum = 0, carry = 0;

        while (b != 0) {
            sum = a ^ b;
            carry = (a & b) << 1;
            a = sum;
            b = carry;
        }

        return a;
    }
}
