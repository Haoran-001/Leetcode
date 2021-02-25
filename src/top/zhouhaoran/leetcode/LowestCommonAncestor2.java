package top.zhouhaoran.leetcode;

import java.util.*;
import java.util.ArrayList;

public class LowestCommonAncestor2 {
    public static void main(String[] args) {
        LowestCommonAncestor2 lowestCommonAncestor = new LowestCommonAncestor2();

        TreeNode node1 = new TreeNode(6), node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(8), node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(4), node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(9), node8 = new TreeNode(3);
        TreeNode node9 = new TreeNode(5);

        node1.left = node2; node1.right = node3;
        node2.left = node4; node2.right = node5;
        node3.left = node6; node3.right = node7;
        node5.left = node8; node5.right = node9;

        System.out.println(lowestCommonAncestor.lowestCommonAncestor(node1, node2, node3));
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathOfP = getPath(root, p);
        List<TreeNode> pathOfQ = getPath(root, q);
        TreeNode ancestor = null;

        for (int i = 0; i < pathOfP.size() && i < pathOfQ.size(); i++) {
            if (pathOfP.get(i) == pathOfQ.get(i)) {
                ancestor = pathOfP.get(i);
            } else {
                break;
            }
        }

        return ancestor;
    }

    private List<TreeNode> getPath(TreeNode root, TreeNode targetNode) {
        List<TreeNode> path = new ArrayList<>();
        TreeNode p = root;

        while (p != targetNode) {
            path.add(p);

            if (targetNode.val < p.val) {
                p = p.left;
            } else if (targetNode.val > p.val) {
                p = p.right;
            }
        }

        path.add(p);

        return path;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
       TreeNode currentNode = root;

       while (true) {
           if (currentNode.val > p.val && currentNode.val > q.val) {
               currentNode = currentNode.left;
           } else if (currentNode.val < p.val && currentNode.val < q.val) {
               currentNode = currentNode.right;
           } else {
               break;
           }
       }

       return currentNode;
    }
}
