package top.zhouhaoran.leetcode;

import java.util.*;

public class RepeatedNTimes {
    public static void main(String[] args) {
        RepeatedNTimes repeatedNTimes = new RepeatedNTimes();
        int[] A = {1, 2, 3};
        System.out.println(repeatedNTimes.repeatedNTimes2(A));
    }

    public int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<>();

        for (int a : A) {
            if (!set.add(a)) {
                return a;
            }
        }

        return -1;
    }

    // 1 2 3 3
    public int repeatedNTimes2(int[] A) {
        for (int k = 1; k <= 3; k++) {
            for (int i = 0; i < A.length - k; i++) {
                if (A[i] == A[i + k]) {
                    return A[i];
                }
            }
        }

        throw null;
    }
}
