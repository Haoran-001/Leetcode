package top.zhouhaoran.leetcode;

import java.util.*;

public class ShortestCompletingWord {
    public static void main(String[] args) {
        ShortestCompletingWord shortestCompletingWord = new ShortestCompletingWord();
        String licensePlate = "1s3";
        String[] words = {"looks","pest","stew","show"};
        System.out.println(shortestCompletingWord.shortestCompletingWord(licensePlate, words));
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        String shortesAns = "";

        for (char c : licensePlate.toCharArray()) {
            if (Character.isDigit(c) || c == ' ') {
                continue;
            }
            c = Character.toLowerCase(c);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < words.length; i++) {
            if (isCompletingWord(words[i], map)) {
                if (count == 0) {
                    shortesAns = words[i];
                    count++;
                } else {
                    shortesAns = shortesAns.length() <= words[i].length() ? shortesAns : words[i];
                }
            }
        }

        return shortesAns;
    }

    private boolean isCompletingWord(String word, Map<Character, Integer> map) {
        Map<Character, Integer> tempMap = new HashMap<>();

        for (char c : word.toCharArray()) {
            tempMap.put(c, tempMap.getOrDefault(c, 0) + 1);
        }

        if (map.size() > tempMap.size()) {
            return false;
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            if (!tempMap.containsKey(key) || tempMap.get(key) < value) {
                return false;
            }
        }

        return true;
    }
}
