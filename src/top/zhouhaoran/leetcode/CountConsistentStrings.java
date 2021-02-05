package top.zhouhaoran.leetcode;

import java.util.HashSet;
import java.util.Set;

public class CountConsistentStrings {
    public static void main(String[] args) {
        CountConsistentStrings countConsistentStrings = new CountConsistentStrings();
        String allowed = "ab";
        String[] words = {"ad", "bd", "aaab", "baa", "badab"};
        int ans = countConsistentStrings.countConsistentStrings(allowed, words);
        System.out.println(ans);
    }

    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (char c : allowed.toCharArray()) {
            set.add(c);
        }

        for (String word : words) {
            if (containsCharacters(word, set))
                count++;
        }

        return count;
    }

    private boolean containsCharacters(String word, Set<Character> set) {
        for (char c : word.toCharArray()) {
            if (!set.contains(c)) {
                return false;
            }
        }
        return true;
    }
}
