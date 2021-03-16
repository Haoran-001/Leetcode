package top.zhouhaoran.leetcode;

import java.util.*;

public class CalPoints {
    public static void main(String[] args) {
        CalPoints calPoints = new CalPoints();
        String[] ops = {"5","-2","4","C","D","9","+","+"};
        System.out.println(calPoints.calPoints(ops));
    }

    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;

        for (String op : ops) {
            if (Character.isDigit(op.charAt(0)) || op.charAt(0) == '-') {
                int num = Integer.parseInt(op);
                stack.push(num);
            } else if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                stack.push(stack.peek() * 2);
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2);
                stack.push(num1);
                stack.push(num1 + num2);
            }
        }

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }

        return sum;
    }
}
