package top.zhouhaoran.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MostVisited {
    public static void main(String[] args) {
        MostVisited mostVisited = new MostVisited();
        int n = 7;
        int[] rounds = {1, 3, 5, 7};  // 0 2 0 1
        System.out.println(mostVisited.mostVisited(n, rounds));
    }

    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> ans = new ArrayList<>();
        int[] map = new int[n];
        map[rounds[0] - 1]++;
        for (int i = 0; i < rounds.length - 1; i++) {
            int start = ((rounds[i] - 1) + 1) % n, end = (rounds[i+1] - 1) % n;
            if (start <= end) {
                while (start <= end) {
                    map[start++]++;
                }
            } else {
                while (start != end) {
                    map[start]++;
                    start = (start + 1) % n;
                }
                map[end]++;
            }
        }

        int maxCount = map[0];
        for (int i = 1; i < map.length; i++) {
            if (maxCount < map[i]) {
                maxCount = map[i];
            }
        }

        for (int i = 0; i < map.length; i++) {
            if (map[i] == maxCount) {
                ans.add(i + 1);
            }
        }

        return ans;
    }
}
