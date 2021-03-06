package top.zhouhaoran.leetcode;

import java.util.*;

public class UniqueOccurrences {
    public static void main(String[] args) {
        UniqueOccurrences uniqueOccurrences = new UniqueOccurrences();
        int[] arr = {1, 2, 2, 1, 1, 3};
        System.out.println(uniqueOccurrences.uniqueOccurrences(arr));
    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0 ) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue() != o2.getValue()) {
                    return o1.getValue() - o2.getValue();
                } else {
                    return o1.getKey() - o2.getKey();
                }
            }
        });

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).getValue() == list.get(i + 1).getValue()) {
                return false;
            }
        }

        return true;

    }

    public boolean uniqueOccurrences2(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0 ) + 1);
        }

        Set<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            set.add(entry.getValue());
        }

        return map.size() == set.size();
    }
}
