package top.zhouhaoran.leetcode;

public class ReverseList {
    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2; node2.next = node3; node3.next = node4; node4.next = node5;

        ListNode node = reverseList.reverseList(node1);


        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
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
