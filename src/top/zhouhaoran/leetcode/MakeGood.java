package top.zhouhaoran.leetcode;

import java.util.Stack;

public class MakeGood {
    public static void main(String[] args) {
        MakeGood makeGood = new MakeGood();
        String s = "abBAcC"; //
        String res = makeGood.makeGood(s);
        System.out.println(res);
    }

    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0, len = s.length();
        while (i < len) {
            if (stack.empty()) {
                stack.push(s.charAt(i));
            } else {
                char c = stack.peek();
                if ((c ^ s.charAt(i)) == 32) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
            i++;
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < stack.size(); j++) {
            sb.append(stack.get(j));
        }

        return sb.toString();
    }
}
