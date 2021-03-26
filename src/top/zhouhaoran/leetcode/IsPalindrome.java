package top.zhouhaoran.leetcode;

import java.util.*;

public class IsPalindrome {
    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node1.next = node2; node2.next = node3; node3.next = node4;
        System.out.println(isPalindrome.isPalindrome2(node1));
    }

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();

        ListNode p = head;
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }

        int front = 0, back = list.size() - 1;

        while (front < back) {
            if (!list.get(front).equals(list.get(back))) {
                return false;
            }
            front++;
            back--;
        }

        return true;
    }

    private ListNode frontPointer;
    public boolean isPalindrome2(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode == null) {
            return true;
        } else {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }

            if (frontPointer.val != currentNode.val) {
                return false;
            }

            frontPointer = frontPointer.next;

            return true;
        }
    }

    public boolean isPalindrome3(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);
        ListNode p1 = head, p2 = secondHalfStart;

        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        firstHalfEnd.next = reverseList(secondHalfStart);

        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head, slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
