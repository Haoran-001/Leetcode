package top.zhouhaoran.leetcode;

import java.util.*;

public class UncommonFromSentences {
    public static void main(String[] args) {
        UncommonFromSentences uncommonFromSentences = new UncommonFromSentences();
        String A = "this apple is sweet";
        String B = "this apple is sour";
        System.out.println(Arrays.toString(uncommonFromSentences.uncommonFromSentences(A, B)));
    }

    public String[] uncommonFromSentences(String A, String B) {

        Map<String, Integer> map = new HashMap<>();

        for (String s : A.split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String s : B.split(" ")) {
                map.put(s, map.getOrDefault(s, 0) + 1);
        }


        List<String> list = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }

        return list.stream().toArray(String[]::new);
    }
}
