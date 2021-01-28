package top.zhouhaoran.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KidsWithCandies {
    public static void main(String[] args) {
        int[] candies = {12, 1, 12}; int extraCandies = 10;
        KidsWithCandies kidsWithCandies = new KidsWithCandies();
        System.out.println(kidsWithCandies.kidsWithCandies(candies, extraCandies));
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        int curVal;
        int maxVal = Arrays.stream(candies).max().getAsInt();
        for (int i = 0; i < candies.length; i++) {
            curVal = candies[i] + extraCandies;
            if (curVal >= maxVal) {
                list.add(true);
            } else {
                list.add(false);
            }
        }

        return list;
    }
}
