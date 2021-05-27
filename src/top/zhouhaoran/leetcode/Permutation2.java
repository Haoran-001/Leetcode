package top.zhouhaoran.leetcode;

import java.util.*;

public class Permutation2 {
    public static void main(String[] args) {
        Permutation2 permutation = new Permutation2();
        String s = "aaa";
        System.out.println(Arrays.toString(permutation.permutation(s)));
    }

    boolean[] visited;
    StringBuilder sb;
    Set<String> set;
    public String[] permutation(String s) {
        char[] sCharrArray = s.toCharArray();
        visited = new boolean[s.length()];
        sb = new StringBuilder();
        set = new HashSet<>();

        dfs(sCharrArray);

        return set.toArray(new String[set.size()]);
    }

    private void dfs(char[] sCharArray) {
        if (sb.length() == sCharArray.length) {
            set.add(sb.toString());
        }

        for (int i = 0; i < sCharArray.length; i++) {
            if (!visited[i]) {
                sb.append(sCharArray[i]);
                visited[i] = true;
                dfs(sCharArray);
                visited[i] = false;
                sb.delete(sb.length() - 1, sb.length());
            }
        }
    }
}
