package top.zhouhaoran.leetcode;

public class ReformatNumber {
    public static void main(String[] args) {
        ReformatNumber reformatNumber = new ReformatNumber();
        String ans = reformatNumber.reformatNumber("123 4-5678");
        System.out.println(ans);
    }

    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        for (char c : number.toCharArray()) {
            if (c != ' ' && c != '-') {
                sb.append(c);
            }
        }

        StringBuilder ans = new StringBuilder();
        while (sb.length() > 0) {
            if (sb.length() <= 4) {
                if (sb.length() == 4) {
                    ans.append(sb.substring(0, 2));
                    ans.append("-");
                    ans.append(sb.substring(2, 4));
                } else if (sb.length() == 3) {
                    ans.append(sb);
                } else if (sb.length() == 2) {
                    ans.append(sb);
                }
                break;
            }
            ans.append(sb.substring(0, 3));
            ans.append("-");
            sb.delete(0, 3);
        }

        return ans.toString();
    }
}
