package top.zhouhaoran.leetcode;

import java.util.*;

public class FindRightInterval {
    public static void main(String[] args) {
        FindRightInterval findRightInterval = new FindRightInterval();
        int[][] intervals = {{1, 1}, {3, 4}};
        System.out.println(Arrays.toString(findRightInterval.findRightInterval3(intervals)));
    }

    public int[] findRightInterval(int[][] intervals) {
        int[] res = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            int minValue = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int j = 0; j < intervals.length; j++) {
                if (intervals[j][0] >= intervals[i][1] && intervals[j][0] < minValue) {
                    minIndex = j;
                    minValue = intervals[j][0];
                }
            }

            res[i] = minIndex;
        }

        return res;
    }

    public int[] findRightInterval2(int[][] intervals) {
        Map<int[], Integer> map = new HashMap<>();
        int[] res = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i], i);
        }

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        // 3, 4  1,2   -> 1,2  3,4
        for (int i = 0; i < intervals.length; i++) {
            int minIndex = -1;
            int minValue = Integer.MAX_VALUE;

            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[j][0] >= intervals[i][1] && intervals[j][0] < minValue) {
                    minIndex = map.get(intervals[j]);
                    minValue = intervals[j][0];
                }
            }
            res[map.get(intervals[i])] = minIndex;
        }

        return res;
    }

    public int[] findRightInterval3(int[][] intervals) {
        Map<int[], Integer> map = new HashMap<>();
        int[] res = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i], i);
        }

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        // (3,4) (1,2) (5,6)   -> (1,2)  (3,4) (5,6)
        for (int i = 0; i < intervals.length; i++) {
            int rightSectionValue = intervals[i][1];

            if (rightSectionValue == intervals[i][0]) {
                res[map.get(intervals[i])] = map.get(intervals[i]);
                continue;
            }

            int left = i + 1;
            int right = intervals.length - 1;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (intervals[mid][0] >= rightSectionValue) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            res[map.get(intervals[i])] = (left <= intervals.length - 1 && intervals[left][0] >= rightSectionValue) ? map.get(intervals[left]) : -1;
        }

        return res;
    }
}
