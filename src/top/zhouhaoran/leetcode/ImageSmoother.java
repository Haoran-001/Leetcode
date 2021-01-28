package top.zhouhaoran.leetcode;

import java.util.Arrays;

public class ImageSmoother {
    public static void main(String[] args) {
        ImageSmoother imageSmoother = new ImageSmoother();
        int[][] M = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] ans = imageSmoother.imageSmoother(M);
        System.out.println(Arrays.deepToString(ans));
    }

    public int[][] imageSmoother(int[][] M) {
        int[][] ans = new int[M.length][M[0].length];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                ans[i][j] = getAverageGray(i, j, M);
            }
        }
        return ans;
    }

    private int getAverageGray(int i, int j, int[][] M) {
        int count = 1;  // 点的个数
        int sum = M[i][j];
        int rows = M.length, cols = M[0].length;
        // 上下左右 (-1,0) (1,0) (0,-1) (0,1)
        // 左上右下 左下右上 (-1, -1) (1, 1) (1, -1) (-1, 1)
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};

        for (int[] direction : directions) {
            if ((i + direction[0] >= 0 && i + direction[0] < rows)
                    && (j + direction[1] >= 0 && j + direction[1] < cols)) {
                sum += M[i+direction[0]][j+direction[1]];
                count++;
            }
        }

        int avg = sum / count;

        return avg;
    }
}
