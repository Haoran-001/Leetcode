package top.zhouhaoran.leetcode;

import java.util.*;

public class DestCity {
    public static void main(String[] args) {
        DestCity destCity = new DestCity();
        List<List<String>> paths = new ArrayList<>();
        paths.add(new ArrayList<String>(){{add("London");add("New York");}});
        paths.add(new ArrayList<String>(){{add("New York");add("Lima");}});
        paths.add(new ArrayList<String>(){{add("Lima");add("Sao Paulo");}});
        String ans = destCity.destCity(paths);
        System.out.println(ans);
    }

    public String destCity(List<List<String>> paths) {
        Map<String, Integer> map = new HashMap<>();
        for (List<String> path : paths) {
            map.put(path.get(0), map.getOrDefault(path.get(0), 0) + 1);
            map.put(path.get(1), map.getOrDefault(path.get(1), 0) + 1);
        }

        String[] sourOrDest = new String[2];
        int index = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                sourOrDest[index++] = entry.getKey();
            }
        }

        for (List<String> path : paths) {
            if (path.get(0) == sourOrDest[0]) {
                return sourOrDest[1];
            }
        }

        return sourOrDest[0];
    }
}
