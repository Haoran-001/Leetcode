package top.zhouhaoran.leetcode;

import java.util.*;

public class KWeakestRows {
    public static void main(String[] args) {
        KWeakestRows kWeakestRows = new KWeakestRows();
        int[][] mat = {
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };
        System.out.println(Arrays.toString(kWeakestRows.kWeakestRows(mat, 3)));
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> map  = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            map.put(i, getMilitaryNum(mat[i]));
        }

        List<Map.Entry<Integer, Integer>> list = new LinkedList(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue() > o2.getValue()) {
                    return 1;
                }
                if (o1.getValue() < o2.getValue()) {
                    return -1;
                }
                if (o1.getValue() == o2.getValue() && o1.getKey() < o2.getKey()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        for (int i = 0; i < k; i++) {
            res[i] = list.get(i).getKey();
        }

        return res;
    }

    private int getMilitaryNum(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num != 1) {
                break;
            }
            count++;
        }
        return count;
    }
}
