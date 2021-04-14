package top.zhouhaoran.leetcode;

public class SumNums {
    public static void main(String[] args) {
        SumNums sumNums = new SumNums();
        System.out.println(sumNums.sumNums2(9));
        System.out.println(sumNums.quickMulti(5 ,3));
    }

    public int sumNums(int n) {
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;

        return n;
    }

    public int quickMulti(int A, int B) {
        int ans = 0;
        for (; B != 0; B >>= 1) {
            if ((B & 1) != 0) {
                ans += A;
            }
            A <<= 1;
        }

        return ans;
    }

    public int sumNums2(int n) {
        int ans = 0, A = n, B = n + 1;

        boolean flag = ((B & 1) == 1) && (ans += A ) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) == 1) && (ans += A ) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) == 1) && (ans += A ) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) == 1) && (ans += A ) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) == 1) && (ans += A ) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) == 1) && (ans += A ) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) == 1) && (ans += A ) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) == 1) && (ans += A ) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) == 1) && (ans += A ) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) == 1) && (ans += A ) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) == 1) && (ans += A ) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) == 1) && (ans += A ) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) == 1) && (ans += A ) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) == 1) && (ans += A ) > 0;
        A <<= 1;
        B >>= 1;

        return ans >> 1;
    }
}
