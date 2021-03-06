package top.zhouhaoran.leetcode;

import java.util.*;

public class NumJewelsInStones {
    public static void main(String[] args) {
        NumJewelsInStones numJewelsInStones = new NumJewelsInStones();
        String J = "aA", S = "aAAbbbb";
        System.out.println(numJewelsInStones.numJewelsInStones2(J, S));
    }

    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;

        for (char c : jewels.toCharArray()) {
            count += getOneJewelNum(c, stones);
        }

        return count;
    }

    private int getOneJewelNum(char c, String stones) {
        int count = 0;
        for (char c2 : stones.toCharArray()) {
            if (c == c2) {
                count++;
            }
        }

        return count;
    }

    public int numJewelsInStones2(String jewels, String stones) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;

        for (char c : stones.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : jewels.toCharArray()) {
            count += map.getOrDefault(c, 0);
        }

        return count;
    }

}
