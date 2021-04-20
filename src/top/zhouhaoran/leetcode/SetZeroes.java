package top.zhouhaoran.leetcode;

import java.util.*;

public class SetZeroes {
    public static void main(String[] args) {
        SetZeroes setZeros = new SetZeroes();
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        setZeros.setZeroes4(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public void setZeroes(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void setZeroes2(int[][] matrix) {
        // 由于我们使用第一行和第一列数组元素来存储当前元素是否为0, 然后去判断只要当前元素的行或者列中元素为0, 就将当前元素置为0
        // 因此, 原本第一行第一列是否包含0可能会被覆盖, 我们用两个标记的布尔变量来存储原信息
        boolean flagRows = false, flagCols = false;

        // 先判断第一行是否有0, 只要存在一个0, 则将flagRows置为true
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                flagRows = true;
                break;
            }
        }

        // 再判断第一列是否有0, 只要存在一个0, 则将flagCols置为true
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                flagCols = true;
                break;
            }
        }

        // 从第二行的第二个元素开始, 即物理下标[1, 1]开始, 遍历当前元素, 如果为0, 就将第一行和第一列对应的元素值置为0
        // 等同于行和列的标记数组, 如matrix[1][2] = 0, 则将第一行第2个元素置为0, 第一列第1个元素置为0
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        // 从第二行第二列的数组元素获取当前元素所在的行或列是否有0
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 对第一行和第一列数组元素是否包含0进行处理
        if (flagRows) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        if (flagCols) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public void setZeroes3(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }

            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }

            if (flagCol0) {
                matrix[i][0] = 0;
            }
        }
    }

    public void setZeroes4(int[][] matrix) {
        boolean flagCols0 = false;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                flagCols0 = true;
            }

            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }

            if (flagCols0) {
                matrix[i][0] = 0;
            }
        }

    }
}
