package top.zhouhaoran.leetcode;

public class NumSpecial {
    public static void main(String[] args) {
        NumSpecial numSpecial = new NumSpecial();
        int[][] mat = {{1, 0, 0}, {0, 0, 1}, {1, 0, 0}};
        System.out.println(numSpecial.numSpecial(mat));
    }

    public int numSpecial(int[][] mat) {
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1 && helper(mat, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean helper(int[][] mat, int row, int col) {
        // 第row行, 除col列外都必须满足为0
        for (int i = 0; i < mat[0].length; i++) {
            if (mat[row][i] == 1 && i != col) {
                return false;
            }
        }
        // 第col列, 除row行外都必须满足为0
        for (int j = 0; j < mat.length; j++) {
            if (mat[j][col] == 1 && j != row) {
                return false;
            }
        }

        return true;
    }
}
