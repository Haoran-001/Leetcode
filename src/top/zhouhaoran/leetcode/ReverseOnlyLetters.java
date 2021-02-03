package top.zhouhaoran.leetcode;

import java.util.Stack;

public class ReverseOnlyLetters {
    public static void main(String[] args) {
        ReverseOnlyLetters reverseOnlyLetters = new ReverseOnlyLetters();
        String S = "z<*zj";
        System.out.println(reverseOnlyLetters.reverseOnlyLetters2(S));
    }
    // zzj  j<*zz
    public String reverseOnlyLetters(String S) {
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (Character.isLetter(c)) {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (Character.isLetter(c)) {
                char temp = stack.pop();
                sb.append(temp);
                continue;
            }
            sb.append(c);
        }

        return sb.toString();
    }

    public String reverseOnlyLetters2(String S) {
        int j = S.length() - 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            if (Character.isLetter(S.charAt(i))) {
                while (!Character.isLetter(S.charAt(j))) {
                    j--;
                }
                sb.append(S.charAt(j--));
                continue;
            }
            sb.append(S.charAt(i));
        }

        return sb.toString();
    }
}
