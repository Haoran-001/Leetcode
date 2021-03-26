package top.zhouhaoran.leetcode;

public class Tribonacci {
    public static void main(String[] args) {
        Tribonacci tribonacci = new Tribonacci();
        System.out.println(tribonacci.tribonacci2(100));
    }

    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        }
    }

    public int tribonacci2(int n) {
        int[] ans = new int[4];
        ans[0] = 0;
        ans[1] = ans[2] = 1;
        if (n <= 2) {
            return ans[n];
        }

        for (int i = 3; i <= n; i++) {
            ans[3] = ans[2] + ans[1] + ans[0];
            ans[0] = ans[1];
            ans[1] = ans[2];
            ans[2] = ans[3];
        }

        return ans[3];
    }
}
