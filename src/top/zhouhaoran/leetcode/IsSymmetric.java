package top.zhouhaoran.leetcode;

public class IsSymmetric {
    public static void main(String[] args) {
        IsSymmetric isSymmetric = new IsSymmetric();
        TreeNode node1 = new TreeNode(1), node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2), node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4), node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(3);
        node1.left = node2; node1.right = node3;
        node2.left = node4; node2.right = node5;
        node3.left = node6; node3.right = node7;
        System.out.println(isSymmetric.isSymmetric(node1));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return recur(root.left, root.right);
    }

    private boolean recur(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
            return false;
        }

        return recur(leftNode.left, rightNode.right) && recur(leftNode.right, rightNode.left);
    }
}
