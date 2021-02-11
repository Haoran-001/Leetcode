package top.zhouhaoran.leetcode;

import java.util.Arrays;

public class MinMoves {
    public static void main(String[] args) {
        MinMoves minMoves = new MinMoves();
        int[] moves = {1, 2, 3, 4, 5, 6};
        System.out.println(minMoves.minMoves4(moves));
    }

    // 1 2 3 -> 2 3 3 -> 3 4 3 -> 4 4 4
    // 1 2 3 -> 3 4 3 -> 4 4 4
    public int minMoves(int[] nums) {
        int min = 0, max = 0, count = 0;

        while (true) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[min] > nums[i]) {
                    min = i;
                } else if (nums[max] < nums[i]) {
                    max = i;
                }
            }

            if (nums[min] == nums[max]) {
                break;
            }

            for (int i = 0; i < nums.length; i++) {
                if (i != max) {
                    nums[i]++;
                }
            }
            count++;
        }

        return count;
    }

    public int minMoves2(int[] nums) {
        int min = 0, max = 0, count = 0;

        while (true) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[min] > nums[i]) {
                    min = i;
                } else if (nums[max] < nums[i]) {
                    max = i;
                }
            }

            int diff = nums[max] - nums[min];

            if (diff == 0) {
                break;
            }

            for (int i = 0; i < nums.length; i++) {
                if (i != max) {
                    nums[i] += diff;
                }
            }
            count += diff;
        }

        return count;
    }

    public int minMoves3(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i] - nums[0];
        }

        return count;
    }

    public int minMoves4(int[] nums) {
        int moves = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            moves += nums[i];
            min = Math.min(min, nums[i]);
        }

        return moves - min * nums.length;
    }

    public int minMoves5(int[] nums) {
        int moves = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            moves += nums[i] - min;
        }

        return moves;
    }

}