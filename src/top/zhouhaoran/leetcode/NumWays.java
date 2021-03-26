package top.zhouhaoran.leetcode;

import java.util.*;

public class NumWays {
    public static void main(String[] args) {
        NumWays numWays = new NumWays();
        System.out.println(numWays.numWays4(80));
    }

    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1 || n == 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }

        return dp[n];
    }

    public int numWays2(int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1 || n == 2) {
            return n;
        }

        int preTwoNum = 1;
        int preOneNum = 2;
        int ans = 0;

        for (int i = 3; i <= n; i++) {
            ans = (preOneNum + preTwoNum) % 1000000007;
            preTwoNum = preOneNum;
            preOneNum = ans;
        }

        return ans;
    }

    Map<Integer, Integer> map = new HashMap<>();
    public int numWays3(int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1 || n == 2) {
            return n;
        }

        map.put(1, 1);
        map.put(2, 2);

        return dfs(n);
    }

    private int dfs(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        int preOneNum = dfs(n - 1) % 1000000007;
        map.put(n - 1, preOneNum);
        int preTwoNum = dfs(n - 2) % 1000000007;
        map.put(n - 2, preTwoNum);

        map.put(n, (preOneNum + preTwoNum) % 1000000007);

        return map.get(n);
    }

    public int numWays4(int n) {
        int[] ans = new int[] {
                1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 134903163, 836311896, 971215059, 807526948, 778742000, 586268941, 365010934, 951279875, 316290802, 267570670, 583861472, 851432142, 435293607, 286725742, 722019349, 8745084, 730764433, 739509517, 470273943, 209783453, 680057396, 889840849, 569898238, 459739080, 29637311, 489376391, 519013702, 8390086, 527403788, 535793874, 63197655, 598991529, 662189184, 261180706, 923369890, 184550589, 107920472, 292471061, 400391533, 692862594, 93254120, 786116714, 879370834, 665487541, 544858368, 210345902, 755204270, 965550172, 720754435, 686304600, 407059028, 93363621, 500422649, 593786270, 94208912, 687995182, 782204094
        };

        return ans[n];
    }
}
