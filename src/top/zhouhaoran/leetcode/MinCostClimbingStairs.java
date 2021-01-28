package top.zhouhaoran.leetcode;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        int[] cost = {10, 15, 20};
        int ans = minCostClimbingStairs.minCostClimbingStairs2(cost);
        System.out.println(ans);
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }

        return dp[n];
    }

    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int prev = 0, cur = 0, next = 0;

        for (int i = 2; i <= n; i++) {
            next = Math.min(prev + cost[i - 2], cur + cost[i - 1]);
            prev = cur;
            cur = next;
        }

        return next;
    }
}
