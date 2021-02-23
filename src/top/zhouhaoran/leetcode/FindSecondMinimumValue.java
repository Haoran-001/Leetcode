package top.zhouhaoran.leetcode;

import java.util.*;

public class FindSecondMinimumValue {
    public static void main(String[] args) {
        FindSecondMinimumValue findSecondMinimumValue = new FindSecondMinimumValue();
//        TreeNode node1 = new TreeNode(2), node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(5), node4 = new TreeNode(5);
//        TreeNode node5 = new TreeNode(7);
//        node1.left = node2; node1.right = node3;
//        node3.left = node4; node3.right = node5;
        TreeNode node6 = new TreeNode(2), node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(2147483647);
        node6.left = node7; node6.right = node8;
        System.out.println(findSecondMinimumValue.findSecondMinimumValue(node6));
    }

    Set<Integer> set = new TreeSet<>();
    public int findSecondMinimumValue(TreeNode root) {
        preorder(root);
        if (set.size() < 2) {
            return -1;
        }

        int count = 0;
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            int num = it.next();
            count++;
            if (count == 2) {
                return num;
            }
        }
        return -1;
    }

    public void preorder(TreeNode node) {
        if (node == null) {
            return;
        }

        set.add(node.val);
        preorder(node.left);
        preorder(node.right);
    }

    public int findSecondMinimumValue2(TreeNode root) {
        if (root == null) {
            return -1;
        }

        return help(root, root.val);
    }

    private int help(TreeNode root, int min) {
        if (root == null) return -1;
        if (root.val > min) return root.val;
        int left = help(root.left, min);
        int right = help(root.right, min);
        if (left == -1) return right;
        if (right == -1) return left;

        return Math.min(left, right);
    }
}
