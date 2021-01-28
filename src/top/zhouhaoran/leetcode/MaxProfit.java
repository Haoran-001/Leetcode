package top.zhouhaoran.leetcode;

public class MaxProfit {
    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit.maxProfit(prices));
    }

    /**
     * 使用动态规划, 第i天的收益为持有股票和没有股票两种中的最大值
     * 第i天持有股票可能为两种情况: 第i-1天已经持有股票; 第i-1天未持有股票, 第i天买入了一只股票
     * 第i天未持有股票可能为两种情况: 第i-1天未持有股票, 第i-1天持有股票, 第i天卖出了该只股票
     * 初始条件, 第一天要么没有一只股票, 要么买入一只股票
     * 最终最大的利润应该是卖出股票
     * @param prices
     * @return int
     */
    public int maxProfit(int[] prices) {
        int dp0 = 0, dp1 = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            int newDp0 = Math.max(dp0, dp1 + prices[i]);
            int newDp1 = Math.max(dp1, dp0 - prices[i]);

            dp0 = newDp0;
            dp1 = newDp1;
        }

        return dp0;
    }
}
