package top.zhouhaoran.leetcode;

public class WaysToStep {
    public static void main(String[] args) {
        WaysToStep waysToStep = new WaysToStep();
        System.out.println(waysToStep.waysToStep2(1000));
    }

    public int waysToStep(int n) {

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        if (n == 3) {
            return 4;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1; dp[2] = 2; dp[3] = 4;

        for (int i = 4; i <= n; i++) {
            dp[i] = ((dp[i - 3] + dp[i - 2]) % 1000000007 + dp[i - 1]) % 1000000007;
        }

        return dp[n];
    }

    public int waysToStep2(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        if (n == 3) {
            return 4;
        }

        int before3 = 1, before2 = 2, before1 = 4;

        for (int i = 4; i <= n; i++) {
            int cur = ((before3 + before2) % 1000000007 + before1) % 1000000007;
            before3 = before2;
            before2 = before1;
            before1 = cur;
        }

        return before1;
    }
}
