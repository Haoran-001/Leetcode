package top.zhouhaoran.leetcode;

import java.util.Arrays;

public class FinalPrices {
    public static void main(String[] args) {
        FinalPrices finalPrices = new FinalPrices();
        int[] prices = {1, 2, 3, 4, 2};
        int[] ans = finalPrices.finalPrices(prices);
        System.out.println(Arrays.toString(ans));
    }

    public int[] finalPrices(int[] prices) {
        int[] ans = new int[prices.length];
        int i, j;

        for (i = 0; i < prices.length - 1; i++) {
            for (j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    ans[i] = prices[i] - prices[j];
                    break;
                }
            }
            if (j == prices.length) {
                ans[i] = prices[i];
            }
        }
        ans[prices.length - 1] = prices[prices.length - 1];
        return ans;
    }
}
