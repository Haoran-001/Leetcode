package top.zhouhaoran.leetcode;

import java.util.Arrays;

public class SpiralOrder {
    public static void main(String[] args) {
        SpiralOrder spiralOrder = new SpiralOrder();
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[] ans = spiralOrder.spiralOrder2(matrix);
        System.out.println(Arrays.toString(ans));
    }

    /**
     * 1  2  3  4
     * 5  6  7  8
     * 9 10 11 12
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int rows = matrix.length, cols = matrix[0].length;
        int row = 0, col = 0;
        // 方向数组代表向右、向下、向左、向上, directionIndex表示当前索引方向数组的下标
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        // visited数组表示当前元素是否被访问过, total记录总的要访问的元素个数
        int total = rows * cols;
        boolean[][] visited = new boolean[rows][cols];
        int[] ans = new int[total];

        for (int i = 0; i < total; i++) {
            ans[i] = matrix[row][col];
            visited[row][col] = true;
            int nextRow = row + directions[directionIndex][0];
            int nextCol = col + directions[directionIndex][1];

            if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || visited[nextRow][nextCol]) {
                directionIndex = (directionIndex + 1) % 4;
            }

            row += directions[directionIndex][0];
            col += directions[directionIndex][1];
        }

        return ans;
    }

    public int[] spiralOrder2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int rows = matrix.length, cols = matrix[0].length;
        int total = rows * cols;
        int[] ans = new int[total];
        int left = 0, right = cols - 1;
        int top = 0, bottom = rows - 1;
        int index = 0;
        
        while (left <= right && top <= bottom) {
            // 向右
            for (int col = left; col <= right; col++) {
                ans[index++] = matrix[top][col];
            }
            // 向下
            for (int row = top + 1; row <= bottom; row++) {
                ans[index++] = matrix[row][right];
            }

            if (left < right && top < bottom) {
                // 向左
                for (int col = right - 1; col >= left; col--) {
                    ans[index++] = matrix[bottom][col];
                }
                // 向上
                for (int row = bottom - 1; row > top; row--) {
                    ans[index++] = matrix[row][left];
                }
            }


            left++;
            right--;
            top++;
            bottom--;
        }

        return ans;
    }
}
