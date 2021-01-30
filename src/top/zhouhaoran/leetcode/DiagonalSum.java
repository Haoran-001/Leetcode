package top.zhouhaoran.leetcode;

public class DiagonalSum {
    public static void main(String[] args) {
        DiagonalSum diagonalSum = new DiagonalSum();
        int[][] mat = {{7, 3, 1, 9}, {3, 4, 6, 9}, {6, 9, 6, 6}, {9, 5, 8, 5}};
        System.out.println(diagonalSum.diagonalSum(mat));
    }

    public int diagonalSum(int[][] mat) {
        int len = mat.length;
        int sum = 0;

        // 计算主对角线
        for (int i = 0; i < len; i++) {
            sum += mat[i][i];
        }

        // 计算副对角线
        for (int i = len - 1; i >=0; i--) {
            sum += mat[i][len - 1 - i];
        }

        // 方矩阵的行列个数都是奇数, 减去重复计算的最中间的数
        if (len % 2 == 1) {
            int k = (len - 1) / 2;
            sum -= mat[k][k];
        }

        return sum;
    }
}
