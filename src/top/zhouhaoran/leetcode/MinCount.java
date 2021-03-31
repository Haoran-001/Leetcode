package top.zhouhaoran.leetcode;

public class MinCount {
    public static void main(String[] args) {
        MinCount minCount = new MinCount();
        int[] coins = new int[] {4, 2, 1};
        System.out.println(minCount.minCount(coins));
    }

    public int minCount(int[] coins) {
        int count = 0;
        for (int i = 0; i < coins.length; i++) {
            count += (int)Math.ceil(coins[i] / 2.0);
        }

        return count;
    }
}
