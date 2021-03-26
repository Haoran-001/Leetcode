package top.zhouhaoran.leetcode;

public class DeleteNode2 {
    public static void main(String[] args) {
        DeleteNode2 deleteNode = new DeleteNode2();
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        node1.next = node2; node2.next = node3; node3.next = node4;
        deleteNode.deleteNode(node1, 5);

        ListNode p = node1;
        while (p != null) {
            System.out.println(p.val + "->");
            p = p.next;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode pre = h;
        ListNode p = h.next;

        while (p != null) {
            if (p.val == val) {
                pre.next = p.next;
            }
            pre = p;
            p = p.next;

        }

        return h.next;
    }
}
