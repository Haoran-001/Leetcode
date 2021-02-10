package top.zhouhaoran.leetcode;

public class IsSubsequence {
    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        String s = "abc", t = "ahbgdc";
        boolean ans = isSubsequence.isSubsequence2(s, t);
        System.out.println(ans);
    }

    public boolean isSubsequence(String s, String t) {
        if (s.equals("")) {
            return true;
        }

        if (t.equals("")) {
            return false;
        }


        char[] tCharArray = t.toCharArray();
        char[] sCharArray = s.toCharArray();

        int index = 0;
        int i, j;
        for (i = 0; i < sCharArray.length; i++) {
            for (j = index; j < tCharArray.length; j++) {
                if (sCharArray[i] == tCharArray[j]) {
                    index = j + 1;
                    break;
                }
            }
            if (j == tCharArray.length) return false;
        }

        return true;
    }

    public boolean isSubsequence2(String s, String t) {
        int n = s.length(), m = t.length();

        int[][] f = new int[m + 1][26];
        for (int i = 0; i < 26; i++) {
            f[m][i] = m;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a')
                    f[i][j] = i;
                else
                    f[i][j] = f[i + 1][j];
            }
        }
        int add = 0;
        for (int i = 0; i < n; i++) {
            if (f[add][s.charAt(i) - 'a'] == m) {
                return false;
            }
            add = f[add][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }
}
