package top.zhouhaoran.leetcode;

public class GcdOfStrings {
    public static void main(String[] args) {
        GcdOfStrings gcdOfStrings = new GcdOfStrings();
        String str1 = "ABABAB", str2 = "ABAB";
        String ans = gcdOfStrings.gcdOfStrings(str1, str2);
        System.out.println(ans);
    }

    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();

        for (int i = Math.min(len1, len2); i >= 1; i--) {
            if (len1 % i == 0 && len2 % i == 0) {
                String substr = str1.substring(0, i);
                if (check(substr, str1) && check(substr, str2))
                    return substr;
            }
        }

        return "";
    }

    private boolean check(String t, String s) {
        StringBuilder sb = new StringBuilder();
        int len = s.length() / t.length();
        for (int i = 0; i < len; i++) {
            sb.append(t);
        }

        return sb.toString().equals(s);
    }
}
