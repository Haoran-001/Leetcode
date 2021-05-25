package top.zhouhaoran.leetcode;

import java.util.*;

public class ConstructArr {
    public static void main(String[] args) {
        ConstructArr constructArr = new ConstructArr();
        int[] a = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(constructArr.constructArr(a)));
    }

    public int[] constructArr(int[] a) {
        int n = a.length;
        int[] ans = new int[n];

        // 从左向右扫描, ans数组表示当前位置左边数的乘积
        for (int i = 0, product = 1; i < n; product *= a[i], i++) {
            ans[i] = product;
        }

        // 从右向左扫描, ans数组表示将当前位置已经算出的左边的乘积结果再乘上右边数乘积的结果即可
        for (int i = n - 1, product = 1; i >= 0; product *= a[i], i--) {
            ans[i] *= product;
        }

        return ans;
    }
}
