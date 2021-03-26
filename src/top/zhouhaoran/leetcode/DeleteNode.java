package top.zhouhaoran.leetcode;

public class DeleteNode {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);
        node1.next = node2; node2.next = node3; node3.next = node4;

        DeleteNode deleteNode = new DeleteNode();
        deleteNode.deleteNode(node2);

        ListNode node = node1;
        while (node.next != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}