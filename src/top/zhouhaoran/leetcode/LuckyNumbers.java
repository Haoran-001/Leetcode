package top.zhouhaoran.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LuckyNumbers {
    public static void main(String[] args) {
        LuckyNumbers luckyNumbers = new LuckyNumbers();
        int[][] matrix = {{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
        System.out.println(luckyNumbers.luckyNumbers(matrix));
    }

    public List<Integer> luckyNumbers (int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int[] rowMin = new int[rowLen];
        int[] colMax = new int[colLen];
        Arrays.fill(rowMin, Integer.MAX_VALUE);
        Arrays.fill(colMax, Integer.MIN_VALUE);
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                rowMin[i] = Math.min(rowMin[i], matrix[i][j]);
                colMax[j] = Math.max(colMax[j], matrix[i][j]);
            }
        }

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (matrix[i][j] == rowMin[i] && matrix[i][j] == colMax[j]) {
                    ans.add(matrix[i][j]);
                }
            }
        }

        return ans;
    }
}
