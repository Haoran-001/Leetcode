package top.zhouhaoran.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumSpecialEquivGroups {
    public static void main(String[] args) {
        NumSpecialEquivGroups numSpecialEquivGroups = new NumSpecialEquivGroups();
        String[] A = {"abcd","cdab","cbad","xyzz","zzxy","zzyx"};
        int ans = numSpecialEquivGroups.numSpecialEquivGroups(A);
        System.out.println(ans);
    }

    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();

        for (String word : A) {
            int[] count = new int[52];
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                count[c - 'a' + (i % 2) * 26]++;
            }
            set.add(Arrays.toString(count));
        }

        return set.size();
    }
}
