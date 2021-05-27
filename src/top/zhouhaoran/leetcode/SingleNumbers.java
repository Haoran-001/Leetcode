package top.zhouhaoran.leetcode;

import java.util.Arrays;

public class SingleNumbers {
    public static void main(String[] args) {
        SingleNumbers singleNumbers = new SingleNumbers();
        int[] nums = {1, 1, 2, 3, 3, 4, 5, 5, 6, 6};
        int[] ans = singleNumbers.singleNumbers(nums);
        System.out.println(Arrays.toString(ans));
    }

    public int[] singleNumbers(int[] nums) {
        int sumOfXOR = 0;

        // sumOfXOR得到数组中所有数异或运算的结果, 也就是两个只出现一次的数异或运算的结果
        for (int num : nums) {
            sumOfXOR ^= num;
        }

        // 对该异或运算的结果, 从最低位开始, 找到第一个二进制不为0的位, 也就是该二进制位为1
        int target = 1;
        while ((target & sumOfXOR) == 0) {
            target <<= 1;
        }

        // 利用第一个二进制位不为0的位(也是一个数, 等于2^(i-1))分别和数组中所有数该二进制位进行与运算
        // 与运算结果有为0和1两种结果, 为0的为第一组, 为1的为第二组
        // 显然如果一个数出现了两次, 两次的结果一定全为0或者全为1, 一定分到了同一组中
        // 只有那两个只出现一次的不相同的数会被分到不同的组, 因为异或结果是1, 表示一个数该位为0, 另一个数该位为1
        int a = 0, b = 0;
        for (int num : nums) {
            if ((num & target) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[] {a, b};
    }
}
