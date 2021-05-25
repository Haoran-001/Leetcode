package top.zhouhaoran.leetcode;

public class AverageWaitingTime {
    public static void main(String[] args) {
        AverageWaitingTime averageWaitingTime = new AverageWaitingTime();
        int[][] customers = {{5,2},{5,4},{10,3},{20,1}};
        // System.out.println(averageWaitingTime.averageWaitingTime(new int[][]{{1,2},{2,5},{4,3}}));
        System.out.println(averageWaitingTime.averageWaitingTime(customers));
    }

    public double averageWaitingTime(int[][] customers) {
        double waitedTimes = customers[0][1];
        double completedTime = customers[0][0] + customers[0][1];

        for (int i = 1; i < customers.length; i++) {
            double tempWaitedTimes = 0.0;
            if (completedTime - customers[i][0] > 0) {
                tempWaitedTimes += (completedTime - customers[i][0]);
            }
            tempWaitedTimes += customers[i][1];
            waitedTimes += tempWaitedTimes;
            if (completedTime - customers[i][0] > 0) {
                completedTime += customers[i][1];
            } else {
                completedTime = customers[i][0] + customers[i][1];
            }
        }

        return waitedTimes / customers.length;
    }
}
