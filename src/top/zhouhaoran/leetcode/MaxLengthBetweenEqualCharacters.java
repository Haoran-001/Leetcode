package top.zhouhaoran.leetcode;

import java.util.*;

public class MaxLengthBetweenEqualCharacters {
    public static void main(String[] args) {
        MaxLengthBetweenEqualCharacters maxLengthBetweenEqualCharacters = new MaxLengthBetweenEqualCharacters();
        String s = "cabbac"; // abaab
        System.out.println(maxLengthBetweenEqualCharacters.maxLengthBetweenEqualCharacters(s));
    }

    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, int[]> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int[] indices = map.get(c);
                int beforeLen = indices[1] - indices[0] - 1;
                int curLen = i - indices[0] - 1;
                if (beforeLen < curLen) {
                    map.put(c, new int[]{indices[0], i});
                }
                continue;
            }
            map.put(c, new int[]{i, i});
        }

        int maxLength = -1;
        for (Map.Entry<Character, int[]> entry : map.entrySet()) {
            int curLength = entry.getValue()[1] - entry.getValue()[0] - 1;
            maxLength = Math.max(maxLength, curLength);
        }

        return maxLength;
    }
}
