package top.zhouhaoran.leetcode;

import java.util.*;

public class MaximumUnits {
    public static void main(String[] args) {
        MaximumUnits maximumUnits = new MaximumUnits();
        int[][] boxTypes = {{1, 3}, {2, 2}, {3, 1}};
        int truckSize = 4;
        System.out.println(maximumUnits.maximumUnits(boxTypes, truckSize));
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return o2[1] - o1[1];
                } else {
                    return o2[0] - o1[0];
                }
            }
        });

        int maxSumUnit = 0;
        int remainedSize = truckSize;

        for (int[] box : boxTypes) {
            if (box[0] <= remainedSize) {
                maxSumUnit += box[0] * box[1];
                remainedSize -= box[0];
            } else if (remainedSize > 0) {
                maxSumUnit += remainedSize * box[1];
                remainedSize = 0;
            } else {
                break;
            }
        }

        return maxSumUnit;
    }
}
