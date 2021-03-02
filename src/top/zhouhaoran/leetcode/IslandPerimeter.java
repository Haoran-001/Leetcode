package top.zhouhaoran.leetcode;

public class IslandPerimeter {
    public static void main(String[] args) {
        IslandPerimeter islandPerimeter = new IslandPerimeter();
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(islandPerimeter.islandPerimeter2(grid));
    }

    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int rows = grid.length;
        int cols = grid[0].length;


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int cnt = 0;
                if (grid[i][j] == 1) {
                    for (int d  = 0; d < 4; d++) {
                        int nextX = i + dx[d];
                        int nextY = j + dy[d];
                        if (nextX < 0 || nextX >= rows || nextY < 0 || nextY >= cols || grid[nextX][nextY] == 0) {
                            cnt++;
                        }
                    }
                }
                ans += cnt;
            }
        }

        return ans;
    }

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int islandPerimeter2(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int ans = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    ans += dfs(i, j, grid, rows, cols);
                }
            }
        }

        return ans;
    }

    private int dfs(int x, int y, int[][] grid, int rows, int cols) {
        if (x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] == 0) {
            return 1;
        }
        if (grid[x][y] == 2) {
            return 0;
        }

        grid[x][y] = 2;
        int res = 0;
        for (int d = 0; d < 4; d++) {
            int nextX = x + dx[d];
            int nextY = y + dy[d];

            res += dfs(nextX, nextY, grid, rows, cols);
        }

        return res;
    }
}
