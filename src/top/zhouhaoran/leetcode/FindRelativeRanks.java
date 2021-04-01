package top.zhouhaoran.leetcode;

import java.util.*;

public class FindRelativeRanks {
    public static void main(String[] args) {
        FindRelativeRanks findRelativeRanks = new FindRelativeRanks();
        int[] score = {5,4,1,0,3};
        System.out.println(Arrays.toString(findRelativeRanks.findRelativeRanks3(score)));
    }

    public String[] findRelativeRanks(int[] score) {
        int[] scoreCopy = score.clone();
        Arrays.sort(scoreCopy);
        int n = score.length;
        String[] ans = new String[n];


        for (int i = 0; i < n; i++) {
            int rank = n - Arrays.binarySearch(scoreCopy, score[i]);

            switch(rank) {
                case 1:
                    ans[i] = "Gold Medal";
                    break;
                case 2:
                    ans[i] = "Silver Medal";
                    break;
                case 3:
                    ans[i] = "Bronze Medal";
                    break;
                default:
                    ans[i] = String.valueOf(rank);
            }
        }

        return ans;
    }

    public String[] findRelativeRanks2(int[] score) {
        String[] ans = new String[score.length];
        TreeMap<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < score.length; i++) {
            map.put(score[i], i);
        }

        int count = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();

            switch(count) {
                case 1:
                    ans[value] = "Gold Medal";
                    break;
                case 2:
                    ans[value] = "Silver Medal";
                    break;
                case 3:
                    ans[value] = "Bronze Medal";
                    break;
                default:
                    ans[value] = String.valueOf(count);
            }
            count++;
        }

        return ans;
    }

    public String[] findRelativeRanks3(int[] score) {
        String[] ans = new String[score.length];

        int max = 0;
        for (int i = 0; i < score.length; i++) {
            if (max < score[i]) {
                max = score[i];
            }
        }

        int[] map = new int[max + 1];

        for (int i = 0; i < score.length; i++) {
            // map的索引为分数,元素值为score中的逻辑下标, 逻辑下标等于物理下标+1
            map[score[i]] = i + 1;
        }

        int count = 1;
        for (int i = map.length - 1; i >= 0; i--) {
            int value = map[i];
            if (value > 0) {
                switch (count) {
                    case 1:
                        ans[map[i] - 1] = "Gold Medal";
                        break;
                    case 2:
                        ans[map[i] - 1] = "Silver Medal";
                        break;
                    case 3:
                        ans[map[i] - 1] = "Bronze Medal";
                        break;
                    default:
                        ans[map[i] - 1] = String.valueOf(count);
                }
                count++;
            }
        }

        return ans;
    }
}
