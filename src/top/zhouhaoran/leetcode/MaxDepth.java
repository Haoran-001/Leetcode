package top.zhouhaoran.leetcode;

import java.util.Stack;

public class MaxDepth {
    public static void main(String[] args) {
        MaxDepth maxDepth = new MaxDepth();
        String s = "1";
        System.out.println(maxDepth.maxDepth(s));
    }

    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int maxDepth = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.add(c);
                maxDepth = Math.max(maxDepth, stack.size());
            } else if (c == ')') {
                stack.pop();
            }
        }

        return maxDepth;
    }
}
