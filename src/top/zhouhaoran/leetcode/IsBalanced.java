package top.zhouhaoran.leetcode;

public class IsBalanced {
    public static void main(String[] args) {
        IsBalanced isBalanced = new IsBalanced();
        TreeNode node1 = new TreeNode(3), node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20), node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2; node1.right = node3;
        node3.left = node4; node3.right = node5;
        System.out.println(isBalanced.isBalanced2(node1));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftSubTreeHeight = height(node.left);
        int rightSubTreeHeight = height(node.right);

        return Math.max(leftSubTreeHeight, rightSubTreeHeight) + 1;
    }

    public boolean isBalanced2(TreeNode root) {
        return height2(root) >= 0;
    }

    private int height2(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftSubTreeHeight = height2(node.left);
        int rightSubTreeHeight = height2(node.right);
        if (leftSubTreeHeight == -1 || rightSubTreeHeight == -1 || Math.abs(leftSubTreeHeight - rightSubTreeHeight) > 1) {
            return -1;
        }

        return Math.max(leftSubTreeHeight, rightSubTreeHeight) + 1;
    }
}
