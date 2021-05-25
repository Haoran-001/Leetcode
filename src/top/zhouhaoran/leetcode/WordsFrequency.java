package top.zhouhaoran.leetcode;

import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;
import java.util.Map;

public class WordsFrequency {
    public static void main(String[] args) {
        String[] book = {"i", "have", "an", "apple", "he", "have", "a", "pen"};
        WordsFrequency wordsFrequency = new WordsFrequency(book);
        System.out.println(wordsFrequency.get("i"));
    }

    Map<String, Integer> map = new HashMap<>();
    public WordsFrequency(String[] book) {
        for (String word : book) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
    }

    public int get(String word) {
        return map.getOrDefault(word, 0);
    }
}
