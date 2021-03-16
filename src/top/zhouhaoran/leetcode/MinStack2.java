package top.zhouhaoran.leetcode;

import java.util.Stack;

class MinStack2 {
    public static void main(String[] args) {
        MinStack2 minStack = new MinStack2();

        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);


        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }

    Stack<Integer> stack1, stack2;
    /** initialize your data structure here. */
    public MinStack2() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
        // 3 1 2 4
        // 3 1 2 4 0        3 1 0
    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty() || x <= stack2.peek()) {
            stack2.push(x);
        }
    }

    public void pop() {
        if (stack1.peek().equals(stack2.peek())) {
            stack1.pop();
            stack2.pop();
        } else {
            stack1.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}