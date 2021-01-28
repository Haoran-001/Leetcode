package top.zhouhaoran.leetcode;

import java.util.Arrays;

public class SortArrayByParity {
    public static void main(String[] args) {
        SortArrayByParity sortArrayByParity = new SortArrayByParity();
        int[] A = {3, 1, 2, 4};
        System.out.println(Arrays.toString(sortArrayByParity.sortArrayByParity3(A)));
    }

    public int[] sortArrayByParity(int[] A) {
        int[] ans = new int[A.length];

        int index = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                ans[index++] = A[i];
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 1) {
                ans[index++] = A[i];
            }
        }

        return ans;
    }

    public int[] sortArrayByParity2(int[] A) {
        int[] ans = new int[A.length];

        int left = 0, right = A.length - 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                ans[left++] = A[i];
            } else if (A[i] % 2 == 1) {
                ans[right--] = A[i];
            }
        }

        return ans;
    }

    public int[] sortArrayByParity3(int[] A) {
        Integer[] B =Arrays.stream(A).boxed().toArray(Integer[]::new);
        Arrays.sort(B, (num1, num2) -> Integer.compare(num1 % 2, num2 % 2));
        A = Arrays.stream(B).mapToInt(num -> num).toArray();
        return A;
    }
}
