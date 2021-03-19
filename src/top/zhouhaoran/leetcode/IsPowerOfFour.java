package top.zhouhaoran.leetcode;

public class IsPowerOfFour {
    public static void main(String[] args) {
        IsPowerOfFour isPowerOfFour = new IsPowerOfFour();
        boolean ans = isPowerOfFour.isPowerOfFour2(5);
        System.out.println(ans);
    }

    public boolean isPowerOfFour(int n) {
        return n > 0 && Math.log(n) / Math.log(2) % 2 == 0;
    }

    public boolean isPowerOfFour2(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & (0xaaaaaaaa)) == 0;
    }
}
