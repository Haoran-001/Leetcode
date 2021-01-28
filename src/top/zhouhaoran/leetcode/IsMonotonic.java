package top.zhouhaoran.leetcode;

public class IsMonotonic {
    public static void main(String[] args) {
        IsMonotonic isMonotonic = new IsMonotonic();
        int[] A = {1, 2, 2, 3};
        System.out.println(isMonotonic.isMonotonic(A));
    }

    public boolean isMonotonic(int[] A) {
        boolean isAscend = true, isDescend = true;
        // 如果是单调递增序列, 返回true
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                isAscend = false;
                break;
            }
        }

        // 如果是单调递减序列，返回true
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1]) {
                isDescend = false;
                break;
            }
        }

        if (isAscend || isDescend) {
            return true;
        }

        return false;
    }
}
