package top.zhouhaoran.leetcode;

public class GetSum {
    public static void main(String[] args) {
        GetSum getSum = new GetSum();
        System.out.println(getSum.getSum(3, 5));
    }

    /**
     * 将a和b两个数转换为二进制, a与b进行按位异或运算, a与b进行按位与运算后左移一位
     * 对两个计算结果不断进行下去, 直到a与b进行按位与运算左移一位后的结果为0,
     * 就返回a与b进行按位异或运算的结果
     * @param a
     * @param b
     * @return int
     */
    public int getSum(int a, int b) {
        int orRes = a, andRes = b;
        while (b != 0) {
            orRes = a ^ b;
            andRes = (a & b) << 1;
            a = orRes;
            b = andRes;
        }

        return orRes;
    }
}
