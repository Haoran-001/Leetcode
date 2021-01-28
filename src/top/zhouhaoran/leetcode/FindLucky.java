package top.zhouhaoran.leetcode;

import java.util.*;

public class FindLucky {
    public static void main(String[] args) {
        FindLucky findLucky = new FindLucky();
        int[] arr = {2, 2, 3, 4, 3, 3};
        System.out.println(findLucky.findLucky(arr));
    }

    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) -> {
            if (o1.getKey() < o2.getKey()) {
                return 1;
            } else {
                return -1;
            }
        });

        for (Map.Entry<Integer, Integer> entry : list) {
            if (entry.getKey() == entry.getValue()) {
                return entry.getKey();
            }
        }

        return -1;
    }
}
