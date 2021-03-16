package top.zhouhaoran.leetcode;

import java.util.Stack;

public class MinOperations2 {
    public static void main(String[] args) {
        MinOperations2 minOperations = new MinOperations2();
        int ans = minOperations.minOperations(new String[]{"d1/","d2/","../","d21/","./"});
        System.out.println(ans);
    }

    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();

        for (String s : logs) {
            if (s.equals("../")) {
                if (stack.isEmpty()) {
                    continue;
                }
                stack.pop();
            } else if (s.equals("./")) {
                continue;
            } else {
                stack.push(s);
            }
        }

        return stack.size();
    }
}
