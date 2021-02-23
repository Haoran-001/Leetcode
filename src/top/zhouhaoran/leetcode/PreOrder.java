package top.zhouhaoran.leetcode;

import java.util.*;

public class PreOrder {
    public static void main(String[] args) {
        PreOrder preorder = new PreOrder();
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.children = new LinkedList<>(){{
            add(node2);add(node3);add(node4);
        }};
        node2.children = new LinkedList<>(){{
            add(node5);add(node6);
        }};
        System.out.println(preorder.preorder2(node1));
    }

    List<Integer> ans = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return ans;
        }

        ans.add(root.val);

        if (root.children != null) {
            for (Node child : root.children) {
                preorder(child);
            }
        }
        return ans;
    }

    public List<Integer> preorder2(Node root) {
        Stack<Node> nodeStack = new Stack<>();
        List<Integer> ans = new LinkedList<>();

        if (root == null ) {
            return ans;
        }

        nodeStack.add(root);
        while (!nodeStack.empty()) {
            Node node = nodeStack.pop();
            ans.add(node.val);
            if (node.children != null) {
                Collections.reverse(node.children);
                for (Node child : node.children) {
                    nodeStack.push(child);
                }
            }
        }

        return ans;
    }
}

class Node {
    public int val;
    public List<Node> children = null;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
