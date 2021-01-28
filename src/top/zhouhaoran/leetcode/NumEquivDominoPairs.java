package top.zhouhaoran.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumEquivDominoPairs {
    public static void main(String[] args) {
        int[][] dominoes = {{1,2},{2,1},{3,4},{1, 2}, {4,3}};
        NumEquivDominoPairs numEquivDominoPairs = new NumEquivDominoPairs();
        int ans = numEquivDominoPairs.numEquivDominoPairs(dominoes);
        System.out.println(ans);
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        if (dominoes == null || dominoes.length == 0 || dominoes[0].length == 0) {
            return 0;
        }

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < dominoes.length; i++) {
            List<Integer> listItem = new ArrayList<>();
            listItem.add(dominoes[i][0]);
            listItem.add(dominoes[i][1]);
            list.add(listItem);
        }

        int ans = 0;
        for (int i = 0; i < list.size(); i++) {
            int cnt = 0;
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(i).get(0) == list.get(j).get(0) && list.get(i).get(1) == list.get(j).get(1)) {
                    cnt++;
                    list.remove(j);
                    continue;
                } else if (list.get(i).get(1) == list.get(j).get(0) && list.get(i).get(0) == list.get(j).get(1)) {
                    cnt++;
                    list.remove(j);
                    continue;
                }
            }

            ans = ans + ((cnt + 1) * cnt) / 2;
        }

        return ans;
    }
}
