package top.zhouhaoran.leetcode;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {
    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        String[] ans = permutation.permutation("qwe");
        System.out.println(Arrays.toString(ans));
    }

    StringBuilder sb = new StringBuilder();
    List<String> ans = new ArrayList<>();
    boolean[] visited = new boolean[9];
    public String[] permutation(String S) {
        char[] charArray = S.toCharArray();

        dfs(charArray);

        return ans.toArray(new String[ans.size()]);
    }

    private void dfs(char[] charArray) {
        if (sb.length() == charArray.length) {
            ans.add(sb.toString());
            return;
        }

        for (int i = 0; i < charArray.length; i++) {
            if (!visited[i]) {
                sb.append(charArray[i]);
                visited[i] = true;
                dfs(charArray);
                visited[i] = false;
                sb.delete(sb.length() - 1, sb.length());
            }
        }
    }
}
