package top.zhouhaoran.leetcode;

import java.util.Arrays;

public class GenerateMatrix {
    public static void main(String[] args) {
        GenerateMatrix generateMatrix = new GenerateMatrix();
        System.out.println(Arrays.deepToString(generateMatrix.generateMatrix2(3)));
    }

    public int[][] generateMatrix(int n) {
        int count = n * n;
        int curCount = 1;
        int row = 0, col = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 右下左上
        int[][] ans = new int[n][n];
        int i = 0;

        while (curCount <= count) {
            ans[row][col] = curCount;
            curCount++;
            int nextRow = row + directions[i][0], nextCol = col + directions[i][1];
            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || ans[nextRow][nextCol] != 0) {
                i = (i + 1) % 4;
            }
            row = row + directions[i][0];
            col = col + directions[i][1];
        }

        return ans;
    }

    public int[][] generateMatrix2(int n) {
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int[][] ans = new int[n][n];
        int curCount = 1;

        while (left <= right && top <= bottom) {
            // 从左上到右上
            for (int col = left; col <= right; col++) {
                ans[top][col] = curCount++;
            }

            // 从右上到右下
            for (int row = top + 1; row <= bottom; row++) {
                ans[row][right] = curCount++;
            }

            // 从右下到左下, 从左下到左上
            if (left < right && top < bottom) {
                for (int col = right - 1; col > left; col--) {
                    ans[bottom][col] = curCount++;
                }

                for (int row = bottom; row > top; row--) {
                    ans[row][left] = curCount++;
                }
            }

            top++;
            left++;

            right--;
            bottom--;
        }

        return ans;
    }
}
