package top.zhouhaoran.leetcode;

public class MaxPower {
    public static void main(String[] args) {
        MaxPower maxPower = new MaxPower();
        String s = "ccc";
        System.out.println(maxPower.maxPower(s));
    }

    public int maxPower(String s) {
        int maxLen = 1, curLen = 1;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                maxLen = Math.max(maxLen, curLen);
                curLen = 1;
                continue;
            }
            curLen++;
        }

        maxLen = Math.max(maxLen, curLen);

        return maxLen;
    }
}
