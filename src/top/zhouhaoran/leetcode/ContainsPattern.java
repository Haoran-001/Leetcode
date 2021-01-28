package top.zhouhaoran.leetcode;

public class ContainsPattern {
    public static void main(String[] args) {
        ContainsPattern containsPattern = new ContainsPattern();
        int[] arr = {1, 2, 1, 2, 1, 1, 1, 3};
        int m = 2, k = 2;
        System.out.println(containsPattern.containsPattern(arr, m, k));
    }

    /**
     *  连续出现k次且长度为m子数组, 若其左端点为l, 则右端点一定为l+(k*m)-1,偏移量相对于l, 为[0, k*m)
     *  在偏移量内有arr[l+offset] == arr[l+(offset) / m]
     *  因此, 枚举左端点l, 再对每个l枚举offset中的[0, k*m)判断是否满足条件即可
     * @param arr
     * @param m
     * @param k
     * @return boolean
     */
    public boolean containsPattern(int[] arr, int m, int k) {
        for (int l = 0; l <= arr.length - m * k; l++) {
            int offset;
            for (offset = 0; offset < m * k; offset++) {
                if (arr[l + offset] != arr[l + offset % m]) {
                    break;
                }
            }
            if (offset == m * k) {
                return true;
            }
        }

        return false;
    }
}
