package top.zhouhaoran.leetcode;

import java.util.*;

public class LargestSumAfterKNegations {
    public static void main(String[] args) {
        LargestSumAfterKNegations largestSumAfterKNegations = new LargestSumAfterKNegations();
        int[] A =  {4, 2, 3};
        int K = 1;
        System.out.println(largestSumAfterKNegations.largestSumAfterKNegations(A, K));
    }

    public int largestSumAfterKNegations(int[] A, int K) {
        int[] map = new int[201];
        int i = 0;
        int sum = 0;

        for (int num : A) {
            map[num + 100]++;
        }

        while (K > 0) {
            while (map[i] == 0) {
                i++;
            }
            // 第二个while结束则找到当前map对应地A数组中地最小值
            map[i]--;
            map[200 - i]++;
            // 如果当前修改地数是一个正数的话, 则修改其为它的相反数是一个负数, 则i应该指向最小值下标为那个相反数的下标
            if (i >= 101) {
                i = 200 - i;
            }

            K--;
        }

        for (int j = 0; j <= 200; j++) {
            sum += (j - 100) * map[j];
        }

        return sum;
    }
}
