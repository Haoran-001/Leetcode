package top.zhouhaoran.leetcode;

import java.util.Arrays;

public class ReplaceElements {
    public static void main(String[] args) {
        ReplaceElements replaceElements = new ReplaceElements();
        int[] arr = {17,18,5,4,6,1};
        int[] ans = replaceElements.replaceElements2(arr);
        System.out.println(Arrays.toString(ans));
    }

    public int[] replaceElements(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length - 1; i++) {
            int maxElem = arr[i + 1];
            for (int j = i + 1; j < arr.length; j++) {
                if (maxElem < arr[j]) {
                    maxElem = arr[j];
                }
            }
            ans[i] = maxElem;
        }

        ans[ans.length - 1] = -1;

        return ans;
    }

    public int[] replaceElements2(int[] arr) {
        int[] ans = new int[arr.length];
        ans[ans.length - 1] = -1;

        for (int i = arr.length - 2; i >=0; i--) {
            ans[i] = Math.max(arr[i+1], ans[i+1]);
        }

        return ans;
    }
}
