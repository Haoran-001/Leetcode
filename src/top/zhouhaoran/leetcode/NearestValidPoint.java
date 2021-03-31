package top.zhouhaoran.leetcode;

public class NearestValidPoint {
    public static void main(String[] args) {
        NearestValidPoint nearestValidPoint = new NearestValidPoint();
        int x = 3, y = 4;
        var points = new int[][]{{1, 2}, {3, 1}, {2, 4}, {2, 3}, {4, 4}};
        System.out.println(nearestValidPoint.nearestValidPoint(x, y, points));
    }

    public int nearestValidPoint(int x, int y, int[][] points) {
        int tempX = 0, tempY = 0;
        int minDis = Integer.MAX_VALUE;
        int i = -1;
        int validI = -1;
        for (int[] point : points) {
            i++;
            if (x == point[0] || y == point[1]) {
                tempX = point[0];
                tempY = point[1];
                int tempDis = Math.abs(tempX - x) + Math.abs(tempY - y);
                if (tempDis < minDis) {
                    minDis = tempDis;
                    validI = i;
                }
            }
        }

        return validI;
    }
}
