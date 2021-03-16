package top.zhouhaoran.leetcode;

import java.util.Stack;

public class RemoveDuplicates {
    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        String s = "abbaca";
        System.out.println(removeDuplicates.removeDuplicates(s));
    }

    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else if (s.charAt(i) == stack.peek()) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();

        if (stack.isEmpty()) {
            return "";
        } else {
            for (int i = 0; i < stack.size(); i++) {
                sb.append(stack.get(i));
            }
        }

        return sb.toString();
    }
}
