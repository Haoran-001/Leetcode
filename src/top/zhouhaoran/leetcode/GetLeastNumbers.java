package top.zhouhaoran.leetcode;

import java.util.Arrays;

public class GetLeastNumbers {
    public static void main(String[] args) {
        GetLeastNumbers getLeastNumbers = new GetLeastNumbers();
        int[] arr = {3, 2, 1}; int k = 2;
        int[] ans = getLeastNumbers.getLeastNumbers(arr, k);
        System.out.println(Arrays.toString(ans));
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }

        return ans;
    }
}
