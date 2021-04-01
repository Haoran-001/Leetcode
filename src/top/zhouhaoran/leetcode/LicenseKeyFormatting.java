package top.zhouhaoran.leetcode;

public class LicenseKeyFormatting {
    public static void main(String[] args) {
        LicenseKeyFormatting licenseKeyFormatting = new LicenseKeyFormatting();
        String S = "2";
        int K = 2;
        System.out.println(licenseKeyFormatting.licenseKeyFormatting(S, K));
    }

    public String licenseKeyFormatting(String S, int K) {

        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();

        for (char c : S.toCharArray()) {
            if (c != '-') {
                sb.append(Character.toUpperCase(c));
            }
        }

        if (sb.length() <= K) {
            return sb.toString();
        }

        int n = sb.length() / K;
        int t = sb.length() - n * K;
        int i = 0;

        if (t != 0) {
            ans.append(sb.substring(0, t));
            ans.append('-');
        }

        for (i = t; i < sb.length() - K; i = i + K) {
            ans.append(sb.substring(i, i + K));
            ans.append('-');
        }

        ans.append(sb.substring(sb.length() - K, sb.length()));

        return ans.toString();
    }
}
