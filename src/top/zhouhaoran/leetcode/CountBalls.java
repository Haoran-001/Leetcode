package top.zhouhaoran.leetcode;

public class CountBalls {
    public static void main(String[] args) {
        CountBalls countBalls = new CountBalls();
        System.out.println(countBalls.countBalls(1, 10));
    }

    public int countBalls(int lowLimit, int highLimit) {
        int[] ans = new int[46];
        int index = bitsSum(lowLimit);
        ans[index]++;

        for (int i = lowLimit + 1; i <= highLimit; i++) {
            int count = endOfZeros(i);
            index = index + 1 - 9 * count;
            ans[index]++;
        }

        int maxValue = 0;

        for (int i = 0; i < ans.length; i++) {
            if (maxValue < ans[i]) {
                maxValue = ans[i];
            }
        }

        return maxValue;
    }

    private int bitsSum(int num) {
        int sum = 0;
        // 100
        while (num > 0) {
            int remainder = num % 10;
            sum += remainder;
            int quotient = num / 10;
            num = quotient;
        }

        return sum;
    }

    private int endOfZeros(int num) {
        int count = 0;

        while (num % 10 == 0) {
            count++;
            num = num / 10;
        }

        return count;
    }
}
