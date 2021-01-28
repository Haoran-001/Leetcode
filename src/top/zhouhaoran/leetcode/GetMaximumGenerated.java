package top.zhouhaoran.leetcode;

import java.util.Arrays;

public class GetMaximumGenerated {
    public static void main(String[] args) {
        GetMaximumGenerated getMaximumGenerated = new GetMaximumGenerated();
        System.out.println(getMaximumGenerated.getMaximumGenerated(7));
    }

    public int getMaximumGenerated(int n) {
        if (n < 2) {
            return n;
        }

        int[] ans = new int[n + 1];
        ans[0] = 0; ans[1] = 1;

        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                int temp = i / 2;
                ans[i] = ans[temp];
            } else if (i % 2 == 1) {
                int temp = (i - 1) / 2;
                ans[i] = ans[temp] + ans[temp + 1];
            }
        }

        Arrays.sort(ans);
        return ans[n];
    }
}
