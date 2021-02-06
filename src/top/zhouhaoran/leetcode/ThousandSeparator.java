package top.zhouhaoran.leetcode;

public class ThousandSeparator {
    public static void main(String[] args) {
        ThousandSeparator thousandSeparator = new ThousandSeparator();
        String ans = thousandSeparator.thousandSeparator2(0);
        System.out.println(ans);
    }

    public String thousandSeparator(int n) {
        String num = String.valueOf(n);
        int len = num.length();

        if (len <= 3) return num;

        int quotient = len / 3;
        int remainder = len % 3;

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < len; i++) {
            ans.append(num.charAt(i));
            if (i + 1 == remainder) {
                ans.append(".");
            }
            else if ((i + 1 - remainder) % 3 == 0 && quotient > 1) {
                ans.append(".");
                quotient--;
            }
        }

        return ans.toString();
    }

    // 712345    543.217.
    public String thousandSeparator2(int n) {
        StringBuilder ans = new StringBuilder();
        int count = 0;

        if (n == 0) {
            return "0";
        }

        while (n > 0) {
            int remainder = n % 10;
            int quotient = n / 10;
            ans.append(remainder);
            count++;
            if (count % 3 == 0 && quotient > 0) {
                ans.append(".");
            }
            n = quotient;
        }

        return ans.reverse().toString();
    }
}
