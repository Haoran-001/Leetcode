package top.zhouhaoran.leetcode;

import java.util.*;

public class LongestWord2 {
    public static void main(String[] args) {
        LongestWord2 longestWord = new LongestWord2();
        String[] words = {"cat","banana","dog","nana","walk","walker","dogwalker"};
//        String[] words = {""};
        System.out.println(longestWord.longestWord2(words));
    }

    /**
     * 使用动态规划的方法
     * 首先定义一个集合, 将字符串数组中的所有字符串加入集合中
     * 接着遍历字符串数组, 每次为每个字符串定义一个布尔型的dp数组, dp数组长度为字符串长度
     * 判断当前字符串的子字符串, 从0到s.length()-2, 因为字符串本身一定包含在集合中, 所以0到s.length()-1显然不需要判断
     * 若符合要求, 则设置dp[i]=true, 表示字符串从0到i位置的子字符串可以由字符串数组中的其他字符串组成
     * 若不满足条件, 则进入条件转移方程, 判断以当前i下标结尾, j从i-1开始的子字符串(j, i)下标位置的子字符串是否包含在集合中,满足, 并且dp[j-1]为true
     * 也就是说(0, j-1)下标位置的子字符串可以由其他字符串组成, 当前(j, i)下标位置的子字符串也可以由其他字符串组成
     * 每次遍历当前字符串0到s.length()-1, 结束时判断dp[s.length()-1]是否为true
     * 若为true, 则再判断它和已有求出的最长单词哪个更长, 若两个字符串长度相同, 则返回字典排序更小的那个
     * @param words
     * @return String
     */
    public String longestWord(String[] words) {
        String ans = "";
        Set<String> set = new HashSet<>();
        for (String word : words) {
            set.add(word);
        }

        for (String word : words) {
            if (word.length() == 0) continue;

            int n = word.length();
            boolean[] dp = new boolean[n];

            for (int i = 0; i < n; i++) {
                if (i != n - 1 && set.contains(word.substring(0, i + 1))) {
                    dp[i] = true;
                } else {
                    for (int j = i - 1; j >= 0; j--) {
                        if (dp[j] && set.contains(word.substring(j + 1, i + 1))) {
                            dp[i] = true;
                        }
                    }
                }
            }

            if (dp[n - 1]) {
                if (ans.length() < word.length()) {
                    ans = word;
                } else if (ans.length() == word.length()) {
                    ans = ans.compareTo(word) < 0 ? ans : word;
                }
            }
        }

        return ans;
    }

    Set<String> set = new HashSet<>();
    public String longestWord2(String[] words) {
        String ans = "";
        for (String word : words) {
            set.add(word);
        }

        for (String word : words) {
            if (word.length() == 0) continue;
            if (dfs(word)) {
                if (ans.length() < word.length()) {
                    ans = word;
                } else if (ans.length() == word.length()) {
                    ans = ans.compareTo(word) < 0 ? ans : word;
                }
            }
        }

        return ans;

    }

    private boolean dfs(String word) {
        int n = word.length();

        for (int i = 0; i < n; i++) {
            String left = word.substring(0, i + 1);
            String right = word.substring(i + 1, n);

            if (set.contains(left)) {
                if (set.contains(right)) {
                    return true;
                } else if (dfs(right)) {
                    return true;
                }
            }
        }

        return false;
    }
}
