package top.zhouhaoran.leetcode;

public class NumberOfSteps {
    public static void main(String[] args) {
        NumberOfSteps numberOfSteps = new NumberOfSteps();
        System.out.println((numberOfSteps.numberOfSteps(14)));
    }

    public int numberOfSteps (int num) {
        int count = 0;
        while (num > 0) {
            if ((num & 1) == 0) {
                num >>= 1;
                count++;
            } else if ((num & 1) == 1) {
                num -= 1;
                count++;
            }
        }

        return count;
    }
}
