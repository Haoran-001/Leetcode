package top.zhouhaoran.leetcode;

public class StrStr {
    public static void main(String[] args) {
        StrStr strStr = new StrStr();
        String haystack = "mississippi";
        String needle = "issip";
        System.out.println(strStr.strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        if (haystack.length() == 0) {
            return -1;
        }

        char[] haystackCharArray = haystack.toCharArray();
        char[] needleCharArray = needle.toCharArray();

        int m = haystack.length(), n = needle.length();

        int i, j;
        for (i = 0, j = 0; i < m && j < n; ) {
            if (haystackCharArray[i] == needleCharArray[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }

        if (j == n) {
            return i - j;
        } else {
            return -1;
        }
    }
}
