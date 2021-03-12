package top.zhouhaoran.leetcode;

public class MinArray {
    public static void main(String[] args) {
        MinArray minArray = new MinArray();
        int[] numbers = {3, 4, 5, 1, 2};
        System.out.println(minArray.minArray(numbers));
    }

    // 1 2 3 4 5   5 1 2 3 4   4 5 1 2 3   3 4 5 1 2
    public int minArray(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return numbers[i + 1];
            }
        }

        return numbers[0];
    }
}
