package top.zhouhaoran.leetcode;

public class SumBase {
    public static void main(String[] args) {
        SumBase sumBase = new SumBase();
        int n = 10, k = 10;
        System.out.println(sumBase.sumBase(n, k));
    }

    public int sumBase(int n, int k) {
        int ans = 0;
        int tempN = n;

        while (tempN > 0) {
            int remainder = tempN % k;
            int quotient = tempN / k;
            ans += remainder;
            tempN = quotient;
        }

        return ans;
    }
}
