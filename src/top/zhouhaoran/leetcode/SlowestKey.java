package top.zhouhaoran.leetcode;

import java.util.*;

public class SlowestKey {
    public static void main(String[] args) {
        SlowestKey slowestKey = new SlowestKey();
        int[] releaseTimes = {9, 29, 49, 50};
        String keysPressed = "cbcd";
        System.out.println(slowestKey.slowestKey(releaseTimes, keysPressed));
    }

    public char slowestKey(int[] releaseTimes, String keysPressed) {
        Map<Character, Integer> map = new HashMap<>();
        char c = keysPressed.charAt(0);
        int time = releaseTimes[0];
        map.put(c, time);
        for (int i = 1; i < keysPressed.length(); i++) {
            c = keysPressed.charAt(i);
            time = releaseTimes[i] - releaseTimes[i - 1];
            if (map.containsKey(c)) {
                int originTime = map.get(c);
                time = Math.max(originTime, time);
            }
            map.put(c, time);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                if (o1.getValue() != o2.getValue()) {
                    return o2.getValue() - o1.getValue();
                } else {
                    return o2.getKey() - o1.getKey();
                }
            }
        });

        char ans = list.get(0).getKey();

        return ans;
    }
}
