package top.zhouhaoran.leetcode;

import java.util.*;

public class UpdateMatrix {
    public static void main(String[] args) {
        UpdateMatrix updateMatrix = new UpdateMatrix();
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        System.out.println(Arrays.deepToString(updateMatrix.updateMatrix(mat)));
    }

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dist = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        // 广度优先搜索
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0], j = cell[1];

            for (int d = 0; d < 4; d++) {
                int nextI = i + directions[d][0];
                int nextJ = j + directions[d][1];

                if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n && !visited[nextI][nextJ]) {
                    dist[nextI][nextJ] = dist[i][j] + 1;
                    queue.offer(new int[]{nextI, nextJ});
                    visited[nextI][nextJ] = true;
                }
            }
        }

        return dist;
    }
}
