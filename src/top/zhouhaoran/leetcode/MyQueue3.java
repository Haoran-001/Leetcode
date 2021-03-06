package top.zhouhaoran.leetcode;

import java.util.*;

public class MyQueue3 {

    Stack<Integer> stack1, stack2;
    /** Initialize your data structure here. */
    public MyQueue3() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (stack1.isEmpty()) {
            stack1.push(x);
            return;
        }

        int size = stack1.size();

        for (int i = 0; i < size; i++) {
            stack2.push(stack1.pop());
        }
        stack2.push(x);

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack1.pop();
    }

    /** Get the front element. */
    public int peek() {
        return stack1.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty();
    }
}
