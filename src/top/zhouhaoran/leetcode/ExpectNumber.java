package top.zhouhaoran.leetcode;
import java.util.*;

public class ExpectNumber {
    public static void main(String[] args) {
        ExpectNumber expectNumber = new ExpectNumber();
        int[] scores = {1, 1, 2, 3};
        System.out.println(expectNumber.expectNumber((scores)));
    }

    public int expectNumber(int[] scores) {
        Set<Integer> set = new HashSet<>();

        for (int score : scores) {
            set.add(score);
        }

        return set.size();
    }
}
