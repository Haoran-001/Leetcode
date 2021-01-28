package top.zhouhaoran.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TrimMean {
    public static void main(String[] args) {
        TrimMean trimMean = new TrimMean();
        int[] arr = {4,8,4,10,0,7,1,3,7,8,8,3,4,1,6,2,1,1,8,0,9,8,0,3,9,10,3,10,1,10,7,3,2,1,4,9,10,7,6,4,0,8,5,1,2,1,6,2,5,0,7,10,9,10,3,7,10,5,8,5,7,6,7,6,10,9,5,10,5,5,7,2,10,7,7,8,2,0,1,1};
        int[] index = new int[arr.length];
        System.out.println(trimMean.trimMean(arr));
    }

    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        int h5 = (int)(Math.ceil(0.05 * (double)(len)));
        int t5 = (int)(Math.ceil(0.95 * (double)(len)));
        double avg = 0.0;
        double sum = 0;
        for (int i = h5; i < t5; i++) {
            sum += arr[i];
        }

        avg = sum / (t5 - h5);

        return avg;
    }
}
