package top.zhouhaoran.leetcode;

public class CountServers {
    public static void main(String[] args) {
        CountServers countServers = new CountServers();
        int[][] grid = {{1,0,0,1,0},{0,0,0,0,0},{0,0,0,1,0}};
        int ans = countServers.countServers(grid);
        System.out.println(ans);
    }

    public int countServers(int[][] grid) {
        int[] countRows = new int[grid.length];
        int[] countCols = new int[grid[0].length];
        int ans = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    countRows[i]++;
                    countCols[j]++;
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (countRows[i] > 1 || countCols[j] > 1) {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }
}
