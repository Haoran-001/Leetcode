package top.zhouhaoran.leetcode;

import java.util.Arrays;

public class NumMovesStones {
    public static void main(String[] args) {
        NumMovesStones numMovesStones = new NumMovesStones();
        System.out.println(Arrays.toString(numMovesStones.numMovesStones(1, 2, 5)));
    }

    public int[] numMovesStones(int a, int b, int c) {
        int x = Math.min(a, Math.min(b, c));
        int z = Math.max(a, Math.max(b, c));
        int y = a + b + c - x - z;

        int[] ans = new int[2];
        ans[0] = getMinSteps(x, y, z);
        ans[1] = getMaxSteps(x, y, z);

        return ans;
    }

    private int getMinSteps(int a, int b, int c) {
        if (Math.abs(a - b) == 1 && Math.abs(b - c) == 1) {
            return 0;
        } else if (Math.abs(a - b) == 1 || Math.abs(a - b) == 2 || Math.abs(b - c) == 1 || Math.abs(b - c) == 2) {
            return 1;
        }

        return 2;
    }

    private int getMaxSteps(int a, int b, int c) {
        int result = 0;

        if (Math.abs(a - b) != 1) {
            result += Math.abs(a - b) - 1;
        }

        if (Math.abs(b - c) != 1) {
            result += Math.abs(b - c) - 1;
        }

        return result;
    }
}
