package top.zhouhaoran.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PlusOne {
    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int[] digits = {9};
        int[] ans = plusOne.plusOne(digits);
        System.out.println(Arrays.toString(ans));
    }

    public int[] plusOne(int[] digits) {
        List<Integer> list = new LinkedList<>();

        int len = digits.length;
        list.add(0,((digits[len - 1] + 1) % 10));
        // bit表示是否有进位
        int bit = (digits[len - 1] + 1) / 10;

        for (int i = len - 2; i >= 0; i--) {
            list.add(0, (digits[i] + bit) % 10);
            bit = (digits[i] + bit) / 10;
        }

        if (bit == 1) {
            list.add(0, bit);
        }

        int[] ans = list.stream().mapToInt(Integer::valueOf).toArray();

        return ans;
    }
}
