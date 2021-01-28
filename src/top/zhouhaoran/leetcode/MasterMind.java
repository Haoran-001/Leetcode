package top.zhouhaoran.leetcode;

import java.util.Arrays;

public class MasterMind {
    public static void main(String[] args) {
        MasterMind masterMind = new MasterMind();
        String solution = "RGBY", guess = "GGRR";
        int[] ans = masterMind.masterMind(solution, guess);
        System.out.println(Arrays.toString(ans));
    }

    public int[] masterMind(String solution, String guess) {
        int fake = 0, real = 0;
        int[] map = new int[26];

        for (int i = 0; i < 4; i++) {
            char sol = solution.charAt(i), gue = guess.charAt(i);

            if (sol == gue) {
                real++;
            } else {
                if (map[sol - 'A'] > 0) fake++;
                map[sol - 'A']--;

                if (map[gue - 'A'] < 0) fake++;
                map[gue - 'A']++;
            }
        }

        int[] ans = {real, fake};
        return ans;

    }
}
