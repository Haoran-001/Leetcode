package top.zhouhaoran.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FairCandySwap {
    public static void main(String[] args) {
        FairCandySwap fairCandySwap = new FairCandySwap();
        int[] A = {1, 1};
        int[] B = {2, 2};
        int[] ans = fairCandySwap.fairCandySwap(A, B);
        System.out.println(Arrays.toString(ans));
    }

    public int[] fairCandySwap(int[] A, int[] B) {
        int sa = 0, sb = 0;
        for (int a : A) sa += a;
        for (int b : B) sb += b;
        int delta = (sb - sa) / 2;
        Set<Integer> set = new HashSet<>();
        for (int b : B) set.add(b);
        for (int a : A) {
            if (set.contains(a + delta)) {
                return new int[]{a, a + delta};
            }
        }

        return null;
    }
}
