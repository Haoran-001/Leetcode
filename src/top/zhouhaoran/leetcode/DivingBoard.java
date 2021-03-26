package top.zhouhaoran.leetcode;

import java.util.Arrays;

public class DivingBoard {
    public static void main(String[] args) {
        DivingBoard divingBoard = new DivingBoard();
        int[] ans = divingBoard.divingBoard(1, 2, 3);
        System.out.println(Arrays.toString(ans));
    }
    
    public int[] divingBoard(int shorter, int longer, int k) {
        int[] ans;

        if (k == 0) {
            ans = new int[0];
            return ans;
        }

        if (shorter == longer) {
            ans = new int[1];
            ans[0] = k * shorter;
            return ans;
        }

        // shorter取i个, 则longer取k-i个, 最终值为f(i) = shortter * i + (k - i) * longer
        // = shorter * i + k * longer - i * longer = k * longer - i * (longer - shorter)
        // = k * shorter + i * (longer - shorter) 按i递增
        // 显然由于0 <= i <= k所有f(i)共有k - 0 + 1 = k + 1种不同取法
        ans = new int[k + 1];

        for (int i = 0; i <= k; i++) {
            ans[i] = k * shorter + i * (longer - shorter);
        }

        return ans;
    }
}
