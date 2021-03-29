package top.zhouhaoran.leetcode;

import java.util.*;

public class CountMatches {
    public static void main(String[] args) {
        CountMatches countMatches = new CountMatches();
        List<List<String>> items = new ArrayList<>() {{
           add(new ArrayList<>(){{add("phone"); add("blue"); add("pixel");}});
           add(new ArrayList<>(){{add("computer"); add("silver"); add("lenovo");}});
           add(new ArrayList<>(){{add("phone"); add("gold"); add("iphone");}});
        }};
        System.out.println(countMatches.countMatches(items, "color", "silver"));

    }

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        Map<String, Integer> map = new HashMap<>();
        map.put("type", 0);
        map.put("color", 1);
        map.put("name", 2);
        int count = 0;

        int key = map.get(ruleKey);

        for (List<String> item : items) {
            if (item.get(key).equals(ruleValue)) {
                count++;
            }
        }

        return count;
    }
}
