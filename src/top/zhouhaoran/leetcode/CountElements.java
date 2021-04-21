package top.zhouhaoran.leetcode;

import java.util.*;

public class CountElements {
    public static void main(String[] args) {
        CountElements countElements = new CountElements();
        int[] arr = {1, 2, 3};
        int ans = countElements.countElements(arr);
        System.out.println(ans);
    }

    public int countElements(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;

        for (int num : arr) {
            set.add(num);
        }

        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i];
            if (set.contains(cur + 1)) {
                ans++;
            }
        }

        return ans;
    }
}
