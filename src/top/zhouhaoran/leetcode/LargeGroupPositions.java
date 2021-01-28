package top.zhouhaoran.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LargeGroupPositions {
    public static void main(String[] args) {
        LargeGroupPositions largeGroupPositions = new LargeGroupPositions();
        String s = "aaa";
        List<List<Integer>> ans = largeGroupPositions.largeGroupPositions(s);
        System.out.println(ans);
    }

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        int start = 0, end = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                end++;
            } else if (s.charAt(i) != s.charAt(i + 1)) {
                if (end - start + 1 >= 3) {
                    List<Integer> list = new ArrayList<>();
                    list.add(start);
                    list.add(end);
                    ans.add(list);
                }
                start = end = i+1;
            }
        }

        if (end - start + 1 >= 3) {
            List<Integer> list = new ArrayList<>();
            list.add(start);
            list.add(end);
            ans.add(list);
        }

        return ans;
    }
}
