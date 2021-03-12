package top.zhouhaoran.leetcode;

public class NumWaterBottles {
    public static void main(String[] args) {
        NumWaterBottles numWaterBottles = new NumWaterBottles();
        int ans = numWaterBottles.numWaterBottles(15, 4);
        System.out.println(ans);
    }

    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;

        while (true) {
            int quotient = numBottles / numExchange;
            int remainder = numBottles % numExchange;
            ans += quotient;
            if (quotient + remainder < numExchange) {
                break;
            }
            numBottles = quotient + remainder;
        }

        return ans;
    }
}
