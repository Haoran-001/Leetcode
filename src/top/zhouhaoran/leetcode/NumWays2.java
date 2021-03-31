package top.zhouhaoran.leetcode;

public class NumWays2 {
    public static void main(String[] args) {
        NumWays2 numWays = new NumWays2();
        int n = 5;
        int[][] relation = new int[][]{{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}};
        int k = 3;
        System.out.println(numWays.numWays(n, relation, k));
    }

    public int numWays(int n, int[][] relation, int k) {
        return 0;
    }

    private void dfs(int index, int num) {

    }
}
