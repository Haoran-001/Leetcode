package top.zhouhaoran.leetcode;

import java.util.*;

public class FizzBuzz {
    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        System.out.println(fizzBuzz.fizzBuzz(15));
    }

    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                ans.add("FizzBuzz");
            } else if (i % 3 == 0) {
                ans.add("Fizz");
            } else if (i % 5 == 0) {
                ans.add("Buzz");
            } else {
                ans.add(String.valueOf(i));
            }
        }

        return ans;
    }
}
