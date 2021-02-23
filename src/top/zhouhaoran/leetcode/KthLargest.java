package top.zhouhaoran.leetcode;

public class KthLargest {
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest();
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);
        node1.left = node2; node1.right = node3;
        node2.left = node4;
        System.out.println(kthLargest.kthLargest(node1, 1));
    }

    int ans, count;
    public int kthLargest(TreeNode root, int k) {
        this.count = k;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null || count == 0) {
            return;
        }

        dfs(root.right);
        if (--count == 0) {
            ans = root.val;
            return;
        }
        dfs(root.left);
    }
}
