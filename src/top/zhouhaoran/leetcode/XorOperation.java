package top.zhouhaoran.leetcode;

import java.util.Arrays;

public class XorOperation {
    public static void main(String[] args) {
        XorOperation xorOperation = new XorOperation();
        System.out.println(xorOperation.xorOperation(5, 0));

    }

    public int xorOperation(int n, int start) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = start + 2 * i;
        }

        int ans = Arrays.stream(nums).reduce((a, b) -> a ^ b).getAsInt();

        return ans;
    }
}
