package top.zhouhaoran.leetcode;

import java.util.*;

public class RemoveDuplicateNodes {
    public static void main(String[] args) {
        RemoveDuplicateNodes removeDuplicateNodes = new RemoveDuplicateNodes();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);

        node1.next = node2; node2.next = node3; node3.next = node4; node4.next = node5;

        ListNode node = removeDuplicateNodes.removeDuplicateNodes(node1);
        ListNode p = node;
        while (p != null) {
            System.out.println(p.val + "->");
            p = p.next;
        }
    }

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return head;
        }

        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        ListNode p = head;

        while (p.next != null) {
            ListNode cur = p.next;
            if (set.add(cur.val)) {
                p = p.next;
            } else {
                p.next = cur.next;
            }
        }

        p.next = null;
        return head;
    }
}
