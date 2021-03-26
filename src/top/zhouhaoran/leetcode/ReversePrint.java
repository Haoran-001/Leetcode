package top.zhouhaoran.leetcode;

import java.util.*;

public class ReversePrint {
    public static void main(String[] args) {
        ReversePrint reversePrint = new ReversePrint();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        node1.next = node2; node2.next = node3;

        int[] ans = reversePrint.reversePrint2(node1);

        System.out.println(Arrays.toString(ans));
    }

    public int[] reversePrint(ListNode head) {
        List<Integer> list = new LinkedList<>();

        for (ListNode p = head; p != null; p = p.next) {
            list.add(0, p.val);
        }

        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    public int[] reversePrint2(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        for (ListNode p = head; p != null; p = p.next) {
            stack.push(p);
        }

        int[] ans = new int[stack.size()];

        for (int i = 0; i < ans.length && !stack.isEmpty(); i++) {
            ans[i] = stack.pop().val;
        }

        return ans;
    }
}
