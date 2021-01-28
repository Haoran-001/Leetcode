package top.zhouhaoran.leetcode;

import java.util.Arrays;

public class SumEvenAfterQueries {
    public static void main(String[] args) {
        SumEvenAfterQueries sumEvenAfterQueries = new SumEvenAfterQueries();
        int[] A = {1, 2, 3, 4};
        int[][] queries = {{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};
        int[] ans = sumEvenAfterQueries.sumEvenAfterQueries(A, queries);
        System.out.println(Arrays.toString(ans));
    }

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] ans = new int[queries.length];
        // 先计算初始时数组中所有偶数的和
        int sum = Arrays.stream(A).filter(a -> a % 2 == 0).sum();
        int i = 0;

        for (int[] query : queries) {
            int value = query[0], index = query[1];
            /*
            分四种情况讨论:
            1. 原数组对应位置是偶数, 与queries新加入值求和也是偶数, 执行两次更新
            2. 原数组对应位置是奇数, 与queries新加入值求和是偶数, 执行第二次更新
            3. 原数组对应位置是奇数, 与queries新加入值求和是奇数, 不更新
            4. 原数组对应位置是偶数, 与queries新加入值求和是奇数, 执行第一次更新
            **/
            if (A[index] % 2 == 0) {
                sum -= A[index];
            }
            A[index] += value;
            if (A[index] % 2 == 0) {
                sum += A[index];
            }
            ans[i++] = sum;
        }

        return ans;
    }
}
