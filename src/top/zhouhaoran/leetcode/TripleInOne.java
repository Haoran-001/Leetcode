package top.zhouhaoran.leetcode;

public class TripleInOne {
    public static void main(String[] args) {
        TripleInOne tripleInOne = new TripleInOne(5);

        tripleInOne.push(0, 1);
        tripleInOne.push(0, 2);
        tripleInOne.push(0, 3);

        tripleInOne.push(1, 8);
        tripleInOne.push(1, 9);
        tripleInOne.push(1, 10);

        tripleInOne.push(2, 100);
        tripleInOne.push(2, 101);

        System.out.println(tripleInOne.peek(0));

    }

    private int[] stack;
    private int[] top;
    private int stackSize;
    public TripleInOne(int stackSize) {
        this.stackSize = stackSize;
        stack = new int[3 * stackSize];
        top = new int[3];

        for (int i = 0; i < 3; i++) {
            top[i] = i * stackSize;
        }
    }

    public void push(int stackNum, int value) {
        if (top[stackNum] == (stackNum + 1) * this.stackSize) {
            return;
        }

        stack[top[stackNum]] = value;
        top[stackNum]++;
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            return -1;
        }

        top[stackNum]--;

        return stack[top[stackNum]];
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            return -1;
        }

        return stack[top[stackNum] - 1];
    }

    public boolean isEmpty(int stackNum) {
        return top[stackNum] -  1 == stackNum * this.stackSize - 1;
    }
}
