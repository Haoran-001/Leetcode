package top.zhouhaoran.leetcode;

public class Add {
    public static void main(String[] args) {
        Add add = new Add();
        System.out.println(add.add(2, -1));
    }

    public int add(int a, int b) {
        // sum保存a+b没有进位的部分, carry保存a+b进位的部分
        // 当两个数的进位为0, 没有进位的部分即是最终的相加结果

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
