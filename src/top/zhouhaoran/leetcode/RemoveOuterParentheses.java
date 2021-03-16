package top.zhouhaoran.leetcode;

import java.util.Stack;

public class RemoveOuterParentheses {
    public static void main(String[] args) {
        RemoveOuterParentheses removeOuterParentheses = new RemoveOuterParentheses();
        String S = "(())()(())";
        String ans = removeOuterParentheses.removeOuterParentheses2(S);
        System.out.println(ans);
    }

    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int level = 0;

        for (char c : S.toCharArray()) {
            if (c == ')') --level;
            if (level >= 1) sb.append(c);
            if (c == '(') ++level;
        }

        return sb.toString();
    }

    public String removeOuterParentheses2(String S) {
        Stack<Character> stack = new Stack<Character>();
        StringBuilder sb = new StringBuilder();

        for (char c : S.toCharArray()) {
            if (c == '(') {
                if (!stack.isEmpty()) {
                    sb.append(c);
                }
                stack.push(c);
            } else if (c == ')') {
                stack.pop();
                if (!stack.isEmpty()) {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }
}
