package top.zhouhaoran.leetcode;

public class MiddleNode {
    public static void main(String[] args) {
        MiddleNode middleNode = new MiddleNode();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2; node2.next = node3; node3.next = node4; node4.next = node5; node5.next = node6;

        System.out.println(middleNode.middleNode(node1).val);
    }

    public ListNode middleNode(ListNode head) {
        int count = 0;

        ListNode p = head;

        while (p != null) {
            count++;
            p = p.next;
        }

        count = count / 2 + 1;

        p = head;

        int i = 1;
        while (p != null && i != count) {
            i++;
            p = p.next;
        }

        return p;
    }
}
