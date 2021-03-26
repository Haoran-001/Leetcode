package top.zhouhaoran.leetcode;

import java.util.*;

public class Fib {
    public static void main(String[] args) {
        Fib fib = new Fib();
        System.out.println(fib.fib2(45));
    }

    public int fib(int n) {
        int ans[] = new int[3];
        ans[0] = 0;
        ans[1] = 1;

        if (n <= 1) {
            return ans[n];
        }

        for (int i = 2; i <= n; i++) {
            ans[2] = (ans[1] + ans[0]) % 1000000007;
            ans[0] = ans[1];
            ans[1] = ans[2];
        }

        return ans[2];
    }

    private Map<Integer, Integer> map = new HashMap<>();
    public int fib2(int n) {
        if (n <= 1) {
            return n;
        }

        map.put(0, 0);
        map.put(1, 1);

        return recursiveFib(n);
    }

    private int recursiveFib(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        int prevOneNumFib = recursiveFib(n - 1) % 1000000007;
        map.put(n - 1, prevOneNumFib);
        int preTwoNumFib = recursiveFib(n - 2) % 1000000007;
        map.put(n - 2, preTwoNumFib);

        map.put(n, (prevOneNumFib + preTwoNumFib) % 1000000007);

        return map.get(n);
    }
}
