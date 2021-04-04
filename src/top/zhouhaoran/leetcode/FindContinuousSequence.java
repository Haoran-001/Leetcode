package top.zhouhaoran.leetcode;

import java.util.*;

public class FindContinuousSequence {
    public static void main(String[] args) {
        FindContinuousSequence findContinuousSequence = new FindContinuousSequence();
        int[][] ans = findContinuousSequence.findContinuousSequence2(15);
        System.out.println(Arrays.deepToString(ans));
    }

    public int[][] findContinuousSequence(int target) {
        int upBound = (target - 1) / 2;
        List<int[]> ans = new ArrayList<>();
        int sum = 0;

        for (int i = 1; i <= upBound; i++) {
            for (int j = i;;j++) {
                if (sum + j > target) {
                    sum = 0;
                    break;
                } else if (sum + j == target) {
                    int[] item = new int[j - i + 1];
                    for (int k = i; k <= j; k++) {
                        item[k - i] = k;
                    }
                    ans.add(item);
                    sum = 0;
                    break;
                }
                sum += j;
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }

    public int[][] findContinuousSequence2(int target) {
        List<int[]> ans = new ArrayList<>();

        int upperBound = (target - 1) / 2;

        for (int left = 1, right = 2; left <= upperBound;) {
            int sum = (left + right) * (right - left + 1) / 2;
            if (sum == target) {
                int[] item = new int[right - left + 1];
                for (int k = left; k <= right; k++) {
                    item[k - left] = k;
                }
                ans.add(item);
                left++;
            } else if (sum > target) {
                left++;
            } else if (sum < target) {
                right++;
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
