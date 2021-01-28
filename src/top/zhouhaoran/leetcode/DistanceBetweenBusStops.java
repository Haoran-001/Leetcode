package top.zhouhaoran.leetcode;

import java.util.Arrays;

public class DistanceBetweenBusStops {
    public static void main(String[] args) {
        DistanceBetweenBusStops distanceBetweenBusStops = new DistanceBetweenBusStops();
        int[] distance = {7,10,1,12,11,14,5,0};
        int start = 7, destination = 2;
        System.out.println(-1 % 3 + 3);
        System.out.println(distanceBetweenBusStops.distanceBetweenBusStops(distance, start, destination));
    }

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start > destination) {
            return distanceBetweenBusStops(distance, destination, start);
        }
        int sum1 = 0;
        for (int i = start; i != destination; i++) {
            sum1 += distance[i];
        }
        int sum = Arrays.stream(distance).sum();
        int sum2 = sum - sum1;
        return Math.min(sum1, sum2);
    }
}
