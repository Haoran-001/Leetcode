package top.zhouhaoran.leetcode;

import java.util.*;

public class Insert {
    public static void main(String[] args) {
        Insert insert = new Insert();
        int[][] intervals = {{1, 3}, {6 ,9}};
        int[] newInterval = {2, 5};
        int[][] ans = insert.insert2(intervals, newInterval);
        System.out.println(Arrays.deepToString(ans));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0], right = newInterval[1];
        List<int[]> ans = new ArrayList<>();

        for (int[] interval : intervals) {
            // 如果遍历到的区间在当前要插入的区间左边, 即interval[1] < left的情况
            // 如果遍历到的区间在当前要插入的区间右边, 即interval[0] > right的情况
            // 以上两种情况都不满足, 说明遍历到的区间与当前要插入的区间有交集, 因此让(left, right)变为它们的并集
            // 即(left, right) = (min(interval[0], left), max(interval[1], right))
            if (interval[1] < left) {
                ans.add(interval);
            } else if (interval[0] > right) {
                ans.add(interval);
            } else {
                left = Math.min(interval[0], left);
                right = Math.max(interval[1], right);
            }
        }

        ans.add(new int[]{left, right});

        Collections.sort(ans, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        return ans.toArray(new int[ans.size()][2]);
    }

    public int[][] insert2(int[][] intervals, int[] newInterval) {
        int left = newInterval[0], right = newInterval[1];
        List<int[]> ans = new ArrayList<>();
        boolean placed = true;

        for (int[] interval : intervals) {
            if (interval[1] < left) {
                ans.add(interval);
            } else if (interval[0] > right) {
                if (placed) {
                    ans.add(new int[]{left, right});
                    placed = false;
                }
                ans.add(interval);
            } else {
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }

        if (placed) {
            ans.add(new int[]{left, right});
        }

        return ans.toArray(new int[ans.size()][2]);
    }
}
