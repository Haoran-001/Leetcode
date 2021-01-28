package top.zhouhaoran.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsDifference {
    public static void main(String[] args) {
        MinimumAbsDifference minimumAbsDifference = new MinimumAbsDifference();
        int[] arr = {40,11,26,27,-20};
        System.out.println(minimumAbsDifference.minimumAbsDifference(arr));
    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        int minAbs = Integer.MAX_VALUE;
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            int abs = arr[i + 1] - arr[i];
            if (abs < minAbs) {
                minAbs = abs;
                ans.clear();
            }
            if (abs == minAbs) {
                List<Integer> listItem = new ArrayList<>();
                listItem.add(arr[i]);
                listItem.add(arr[i+1]);
                ans.add(listItem);
            }
        }

        return ans;
    }
}
