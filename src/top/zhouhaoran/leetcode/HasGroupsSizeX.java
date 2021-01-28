package top.zhouhaoran.leetcode;

import java.util.*;

public class HasGroupsSizeX {
    public static void main(String[] args) {
        HasGroupsSizeX hasGroupsSizeX = new HasGroupsSizeX();
        int[] deck = {1};
        System.out.println((hasGroupsSizeX.hasGroupsSizeX2(deck)));
    }

    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int item : deck) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        int len = deck.length;

        for (int X = 2; X <= len; X++) {
            if (len % X == 0) {
                boolean flag = true;
                for (Map.Entry<Integer, Integer> entry : list) {
                    if (entry.getValue() % X != 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return true;
                }
            }
        }

        return false;
    }
    // 100 10  -> 10 100 -> 0, 10 -> 10
    // 15 9 -> 9 15 -> 6, 9 -> 3 6 ->0 3 -> 3
    // 100 50 -> 50 100 -> 0, 50 -> 50
    // 15 11 -> 11 15 ->4 11 ->3 4 ->1 3 ->0 1 -> 1

    public boolean hasGroupsSizeX2(int[] deck) {
        int[] count = new int[10000];
        for (int i = 0; i < deck.length; i++) {
            count[deck[i]]++;
        }

        int g = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                if (g == -1) {
                    g = count[i];
                } else {
                    g = gcd(g, count[i]);
                }
            }
        }

        return g >= 2;
    }

    private int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }
}
