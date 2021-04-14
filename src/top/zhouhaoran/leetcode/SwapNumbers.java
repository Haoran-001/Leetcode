package top.zhouhaoran.leetcode;

import java.util.Arrays;

public class SwapNumbers {
    public static void main(String[] args) {
        SwapNumbers swapNumbers = new SwapNumbers();
        int[] numbers = {9, 9};
        System.out.println(Arrays.toString(swapNumbers.swapNumbers2(numbers)));
    }

    public int[] swapNumbers(int[] numbers) {
        numbers[0] = numbers[0] + numbers[1];
        numbers[1] = numbers[0] - numbers[1];
        numbers[0] = numbers[0] - numbers[1];

        return numbers;
    }

    public int[] swapNumbers2(int[] numbers) {
        if (numbers[0] == numbers[1]) return numbers;

        numbers[0] ^= numbers[1];
        numbers[1] ^= numbers[0];
        numbers[0] ^= numbers[1];

        return numbers;
    }
}
