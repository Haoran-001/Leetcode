package top.zhouhaoran.leetcode;

import java.util.*;

public class CombinationSum3 {
    public static void main(String[] args) {
        CombinationSum3 combinationSum3 = new CombinationSum3();
        int k = 3, n = 7;
        System.out.println(combinationSum3.combinationSum3(k, n));
    }

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> ansItem = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        // 使用mask变量表示掩码, 意思是{1, 2, 3, 4, 5, 6, 7, 8, 9}， 该数组中那些位会被选择
        // 比如mask = 0表示数组中不选择任何元素, mask=2^9-1表示选择数组中全部元素
        // mask = 3表示选择数组中的1和2, 即下标为0和1的元素
        for (int mask = 0; mask < 1 << 9; mask++) {
            if (check(mask, k, n)) {
                ans.add(new ArrayList<>(ansItem));
            }
        }

        return ans;
    }

    private boolean check(int mask, int k, int n) {
        ansItem.clear();

        for (int i = 0; i < 9; i++) {
            if ((mask & (1 << i)) != 0) {
                ansItem.add(i + 1);
            }
        }

        if (ansItem.size() != k) {
            return false;
        }

        int sum = ansItem.stream().mapToInt(Integer::valueOf).sum();

        return sum == n;
    }
}
