package top.zhouhaoran.leetcode;

import java.util.*;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        TreeNode node1 = new TreeNode(3), node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1), node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(2), node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(8), node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(4);

        node1.left = node2; node1.right = node3;
        node2.left = node4; node2.right = node5;
        node3.left = node6; node3.right = node7;
        node5.left = node8; node5.right = node9;

        System.out.println(lowestCommonAncestor.lowestCommonAncestor(node1, node2, node3));
    }

    private TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        postorder(root, p, q);
        return ans;
    }

    private boolean postorder(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return false;
        }

        boolean isleftSonContaining = postorder(node.left, p, q);
        boolean isRightSonContaining = postorder(node.right, p, q);
        if ((isleftSonContaining && isRightSonContaining) || ((node == p || node == q) && (isleftSonContaining || isRightSonContaining))) {
            this.ans = node;
        }

        return isleftSonContaining || isRightSonContaining || node == p || node == q;
    }

    Map<TreeNode, TreeNode> map = new HashMap<>();
    Set<TreeNode> pathOfP = new HashSet<>();
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        findNodeAndParentNode(root);

        while (p != null) {
            pathOfP.add(p);
            TreeNode parentNode = map.get(p);
            p = parentNode;
        }

        while (q != null) {
            if (pathOfP.contains(q)) {
                return q;
            }
            TreeNode parentNode = map.get(q);
            q = parentNode;
        }

        return null;
    }

    private void findNodeAndParentNode (TreeNode node) {
        if (node.left != null) {
            map.put(node.left, node);
            findNodeAndParentNode(node.left);
        }

        if (node.right != null) {
            map.put(node.right, node);
            findNodeAndParentNode(node.right);
        }
    }
}
