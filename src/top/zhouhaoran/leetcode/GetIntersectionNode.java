package top.zhouhaoran.leetcode;

import java.util.*;

public class GetIntersectionNode {
    public static void main(String[] args) {
        GetIntersectionNode getIntersectionNode = new GetIntersectionNode();

        ListNode node1_1 = new ListNode(4);
        ListNode node1_2 = new ListNode(1);
        ListNode node1_3 = new ListNode(8);
        ListNode node1_4 = new ListNode(4);
        ListNode node1_5 = new ListNode(5);
        node1_1.next = node1_2; node1_2.next = node1_3; node1_3.next = node1_4; node1_4.next = node1_5;

        ListNode node2_1 = new ListNode(5);
        ListNode node2_2 = new ListNode(0);
        ListNode node2_3 = new ListNode(1);
        node2_1.next = node2_2; node2_2.next = node2_3; node2_3.next = node1_3;


        System.out.println(getIntersectionNode.getIntersectionNode(node1_1, node2_1).val);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        ListNode pa = headA;
        while (pa != null) {
            set.add(pa);
            pa = pa.next;
        }

        ListNode pb = headB;
        while (pb != null) {
            if (set.contains(pb)) {
                return pb;
            }
            set.add(pb);
            pb = pb.next;
        }

        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode pa = headA, pb = headB;

        while (pa != pb) {
            pa = pa != null ? pa.next : headB;
            pb = pb != null ? pb.next : headA;
        }

        return pa;
    }
}
