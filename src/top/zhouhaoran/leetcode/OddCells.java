package top.zhouhaoran.leetcode;

public class OddCells {
    public static void main(String[] args) {
        OddCells oddCells = new OddCells();
        int[][] indices = {{0, 1}, {1, 1}};
        System.out.println(oddCells.oddCells(2, 3, indices));
    }

    public int oddCells(int n, int m, int[][] indices) {
        int[][] arr = new int[n][m];
        // 统计奇数值的单元格数目
        int count = 0;

        for (int[] indice : indices) {
            // 对选定的行每列元素加1
            int chosenRow = indice[0];
            for (int col = 0; col < m; col++) {
                arr[chosenRow][col]++;
            }

            // 对选定的列每行元素加1
            int chosenCol = indice[1];
            for (int row = 0; row < n; row++) {
                arr[row][chosenCol]++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] % 2 == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}
