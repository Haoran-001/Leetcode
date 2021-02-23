package top.zhouhaoran.leetcode;

import java.util.ArrayList;
import java.util.List;

public class IncreasingBST {
    public static void main(String[] args) {
        IncreasingBST increasingBST = new IncreasingBST();
        TreeNode node1 = new TreeNode(5), node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(6), node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4), node6 = new TreeNode(8);
        TreeNode node7 = new TreeNode(1), node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        node1.left = node2; node1.right = node3;
        node2.left = node4; node2.right = node5;
        node3.right = node6; node4.left = node7;
        node6.left = node8; node6.right = node9;
        System.out.println(increasingBST.increasingBST(node1));
    }

    List<Integer> list = new ArrayList<>();
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        inorder(root);

        TreeNode ans = new TreeNode(0), p = ans;
        for (Integer val : list) {
            p.val = val;
            p.left = new TreeNode(0);
            p = p.left;
        }

        return ans;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        list.add(node.val);
        inorder(node.right);
    }
}
