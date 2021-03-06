package top.zhouhaoran.leetcode;

public class IsAlienSorted {
    public static void main(String[] args) {
        IsAlienSorted isAlienSorted = new IsAlienSorted();
        String[] words = {"word","world","row"};
        String order = "worldabcefghijkmnpqstuvxyz";
        System.out.println(isAlienSorted.isAlienSorted(words, order));
    }

    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];

        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            map[c - 'a'] = i;
        }

        search: for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if (c1 != c2) {
                    if (map[c1 - 'a'] > map[c2 - 'a']) {
                        return false;
                    }
                    continue search;
                }
            }

            if (word1.length() > word2.length()) {
                return false;
            }
        }

        return true;
    }
}
