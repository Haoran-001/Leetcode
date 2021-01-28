package top.zhouhaoran.leetcode;

import java.util.Arrays;

public class SumZero {
    public static void main(String[] args) {
        SumZero sumZero = new SumZero();
        System.out.println(Arrays.toString(sumZero.sumZero2(2)));
    }

    public int[] sumZero(int n) {
        int[] ans = new int[n];

        // 偶数情况和奇数情况分别考虑
        if (n % 2 == 0) {
            sumZeroIfEven(n, ans);
        } else {
            sumZeroIfEven(n - 1, ans);
            ans[n - 1] = 0;
        }

        return ans;
    }

    public int[] sumZero2(int n) {
        int[] ans = new int[n];

        if (n == 2) {
            return new int[]{-1, 1};
        }

        for (int i = 0; i < n - 1; i++) {
            ans[i] = i;
        }
        ans[n - 1] = (-(n-2)*(n-1)) / 2;

        return ans;
    }

    private void sumZeroIfEven(int n, int[] ans) {
        for (int i = 1; i <= n / 2; i++) {
            ans[i - 1] = i;
            ans[n - i] = -i;
        }

    }
}
