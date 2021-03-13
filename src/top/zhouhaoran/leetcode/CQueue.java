package top.zhouhaoran.leetcode;

import java.util.Stack;

class CQueue {
    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        cQueue.appendTail(3);

        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }

    // 4 3 2 1
    Stack<Integer> stack1, stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        if (stack1.isEmpty()) {
            stack1.push(value);
            return;
        }

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        stack1.push(value);

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public int deleteHead() {
        if (stack1.isEmpty()) {
            return -1;
        }
        return stack1.pop();
    }
}
