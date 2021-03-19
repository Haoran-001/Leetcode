package top.zhouhaoran.leetcode;

import java.util.*;

public class ReverseBits {
    public static void main(String[] args) {
        ReverseBits reverseBits = new ReverseBits();
        System.out.println(reverseBits.reverseBits(-3));
    }

    public int reverseBits(int num) {
        if (num == -1) {
            return 32;
        }

        long completeCode = num;

        if (num < 0) {
            completeCode = getCompleteCode(num);
        }

        int[] bits = new int[32];
        int i = 0;
        int max = Integer.MIN_VALUE;

        while (completeCode > 0) {
            if ((completeCode & 1) == 1) {
                bits[i]++;
            } else if ((completeCode & 1) == 0) {
                i++;
            }
            completeCode = completeCode >> 1;
        }

        for (int j = 0; j < bits.length - 1; j++) {
            max = Math.max(max, bits[j] + bits[j + 1] + 1);
        }

        System.out.println(getCompleteCode(-3));

        return max;
    }

    private long getCompleteCode(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            int t = (num & 0x80000000 >>> i) >>> (31 - i);
            sb.append(t);
        }

        long code = Long.parseLong(sb.toString(), 2);

        return code;
    }
}
