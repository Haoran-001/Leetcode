package top.zhouhaoran.leetcode;

public class IncreasingBST2 {
    public static void main(String[] args) {
        IncreasingBST increasingBST = new IncreasingBST();
        TreeNode node1 = new TreeNode(5), node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(6), node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4), node6 = new TreeNode(8);
        TreeNode node7 = new TreeNode(1), node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);

        node1.left = node2; node1.right = node3;
        node2.left = node4; node2.right = node5;
        node3.left = node6;
        node4.left = node7;
        node6.left = node8; node6.right = node9;

        System.out.println(increasingBST.increasingBST(node1));
    }

    TreeNode head = new TreeNode(0);
    TreeNode prev = null;
    public TreeNode increasingBST(TreeNode root) {
        inorder(root);

        return head.right;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        inorder(node.left);

        // 处理第一个结点
        if (prev == null) {
            prev = node;
            head.right = node;
        } else {
            prev.right = node;
            prev = node;
        }
        node.left = null;
        inorder(node.right);
    }
}
