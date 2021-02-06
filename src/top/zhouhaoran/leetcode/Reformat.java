package top.zhouhaoran.leetcode;

public class Reformat {
    public static void main(String[] args) {
        Reformat reformat = new Reformat();
        String s = "a0b1c2";
        String ans = reformat.reformat2(s);
        System.out.println(ans);
    }

    public String reformat(String s) {
        StringBuilder numSb = new StringBuilder();
        StringBuilder letterSb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                numSb.append(c);
            } else if (Character.isLetter(c)) {
                letterSb.append(c);
            }
        }

        if (Math.abs(numSb.length() - letterSb.length()) > 1) {
            return "";
        }

        String ans;
        if (numSb.length() >= letterSb.length()) {
            ans = concatString(numSb, letterSb);
        } else {
            ans = concatString(letterSb, numSb);
        }

        return ans;
    }

    private String concatString(StringBuilder sb1, StringBuilder sb2) {
        StringBuilder ans = new StringBuilder();
        int len1 = sb1.length();
        int len2 = sb2.length();
        for (int i = 0;i < len2; i++) {
            ans.append(sb1.charAt(i));
            ans.append(sb2.charAt(i));
        }

        if (len1 > len2) {
            ans.append(sb1.charAt(len1 - 1));
        }

        return ans.toString();
    }

    public String reformat2(String s) {
        int numCount = 0, letterCount = 0;

        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                letterCount++;
            } else if (c >= '0' && c <= '9') {
                numCount++;
            }
        }

        if (numCount - letterCount > 1 || letterCount - numCount > 1) {
            return "";
        }

        int numIndex = numCount >= letterCount ? 0 : 1;
        int letterIndex = numIndex == 0 ? 1 : 0;

        char[] ans = new char[s.length()];

        for (char c : s.toCharArray()) {
            if (c>= 'a' && c <= 'z') {
                ans[letterIndex] = c;
                letterIndex += 2;
            } else if (c >= '0' && c <= '9') {
                ans[numIndex] = c;
                numIndex += 2;
            }
        }

        return String.valueOf(ans);
    }
}
