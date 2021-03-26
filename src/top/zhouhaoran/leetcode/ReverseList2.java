package top.zhouhaoran.leetcode;

public class ReverseList2 {
    public static void main(String[] args) {
        ReverseList2 reverseList = new ReverseList2();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2; node2.next = node3; node3.next = node4; node4.next = node5;
        ListNode node = reverseList.reverseList(node1);
        ListNode p = node;
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null, cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}
