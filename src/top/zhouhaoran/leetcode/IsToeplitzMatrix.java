package top.zhouhaoran.leetcode;

public class IsToeplitzMatrix {
    public static void main(String[] args) {
        IsToeplitzMatrix isToeplitzMatrix = new IsToeplitzMatrix();
        int[][] matrix = {{1,2,3,4},
                          {5,1,2,3},
                          {9,5,1,2}};
        System.out.println(isToeplitzMatrix.isToeplitzMatrix(matrix));
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;

        // 判断第一列上的对角线元素是否相同, 变化行
        for (int i = 0; i < rows - 1; i++) {
            int r = i, c = 0;
            while (r < rows - 1 && c < cols - 1) {
                if (matrix[r][c] != matrix[r + 1][c + 1]) {
                    return false;
                }
                r = r + 1;
                c = c + 1;
            }
        }


        // 判断第一行上的对角线元素是否相同, 变化列
        for (int i = 1; i < cols - 1; i++) {
            int r = 0, c = i;
            while (r < rows - 1 && c < cols - 1) {
                if (matrix[r][c] != matrix[r+1][c+1]) {
                    return false;
                }
                r = r + 1;
                c = c + 1;
            }
        }

        return true;
    }
}
