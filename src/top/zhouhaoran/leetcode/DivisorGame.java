package top.zhouhaoran.leetcode;

public class DivisorGame {
    public static void main(String[] args) {
        DivisorGame divisorGame = new DivisorGame();
        System.out.println(divisorGame.divisorGame2(100));
    }

    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }

    public boolean divisorGame2(int N) {
        if (N == 1) return false;
        if (N == 2) return true;

        boolean[] dp = new boolean[N + 1];

        dp[1] = false;
        dp[2] = true;

        for (int i = 3; i <= N; i++) {
            for (int j = 1; j <= i-1; j++) {
                if (i % j == 0 && !dp[i - j]) {
                    dp[i] = true;
                }
            }
        }

        return dp[N];
    }
}
