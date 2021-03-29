package top.zhouhaoran.leetcode;

public class MergeTwoLists {
    public static void main(String[] args) {
        MergeTwoLists mergeTwoLists = new MergeTwoLists();

        ListNode node1_1 = new ListNode(1);
        ListNode node1_2 = new ListNode(2);
        ListNode node1_3 = new ListNode(4);
        node1_1.next = node1_2; node1_2.next = node1_3;

        ListNode node2_1 = new ListNode(1);
        ListNode node2_2 = new ListNode(3);
        ListNode node2_3 = new ListNode(4);
        node2_1.next = node2_2; node2_2.next = node2_3;

        ListNode node = mergeTwoLists.mergeTwoLists2(node1_1, node2_1);

        ListNode p = node;
        while (p != null) {
            System.out.println(p.val + "->");
            p = p.next;
        }
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;

        ListNode p1 = l1, p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }

        if (p1 != null) {
            p.next = p1;
        }

        if (p2 != null) {
            p.next = p2;
        }

        return head.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
