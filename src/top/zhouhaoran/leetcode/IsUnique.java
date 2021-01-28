package top.zhouhaoran.leetcode;

import java.util.HashSet;
import java.util.Set;

public class IsUnique {
    public static void main(String[] args) {
        String astr = "let";
        IsUnique isUnique = new IsUnique();
        System.out.println(isUnique.isUnique2(astr));
    }

    public boolean isUnique(String astr) {
        Set<Character> set = new HashSet<>();
        for (char c : astr.toCharArray()) {
            if (!set.add(c)) {
                return false;
            }
        }

        return true;
    }

    public boolean isUnique2(String astr) {
        int[] map = new int[26];

        for (int i = 0; i < astr.length(); i++) {
            char c = astr.charAt(i);
            map[c - 'a']++;
        }

        for (int i = 0; i < map.length; i++) {
            if (map[i] > 1) {
                return false;
            }
        }

        return true;
    }
}
