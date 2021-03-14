package top.zhouhaoran.leetcode;

import java.util.*;

public class MyQueue4 {

    private Stack<Integer> stack1, stack2;
    private int front;

    /** Initialize your data structure here. */
    public MyQueue4() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (stack1.isEmpty()) {
            front = x;
        }
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (!stack1.isEmpty()) {
            return front;
        }

        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}