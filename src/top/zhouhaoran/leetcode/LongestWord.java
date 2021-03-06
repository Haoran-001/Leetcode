package top.zhouhaoran.leetcode;

import java.util.*;

public class LongestWord {
    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        LongestWord longestWord = new LongestWord();
        System.out.println(longestWord.longestWord2(words));
    }


    public String longestWord(String[] words) {
        Set<String> wordsSet = new HashSet<>();

        for (String word : words) {
            wordsSet.add(word);
        }

        String ans = "";
        for (String word : wordsSet) {
            if (word.length() > ans.length()
                     || word.length() == ans.length() && word.compareTo(ans) < 0) {
                boolean good = true;
                for (int i = 1; i < word.length(); i++) {
                    String prefixWord = word.substring(0, i);
                    if (!wordsSet.contains(prefixWord)) {
                        good = false;
                    }
                }
                if (good) {
                    ans = word;
                }
            }
        }

        return ans;
    }

    public String longestWord2(String[] words) {
        Trie trie = new Trie();
        int index = 0;
        for (String word : words) {
            trie.insert(word, ++index);
        }
        trie.words = words;
        return trie.dfs();
    }
}

class Node2 {
    public char c;
    public Map<Character, Node2> children = new HashMap<>();
    public int end;
    public Node2(char c) {
        this.c = c;
    }
}

class Trie {
    Node2 root;
    String[] words;
    public Trie() {
        root = new Node2('0');
    }

    public void insert(String word, int index) {
        Node2 cur = root;
        for (char c : word.toCharArray()) {
            cur.children.putIfAbsent(c, new Node2(c));
            cur = cur.children.get(c);
        }

        cur.end = index;
    }

    public String dfs() {
        String ans = "";
        Stack<Node2> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Node2 node = stack.pop();
            if (node.end > 0 || node == root) {
                if (node != root) {
                    String word = words[node.end - 1];
                    if (word.length() > ans.length()
                    || word.length() == ans.length() && word.compareTo(ans) < 0) {
                        ans = word;
                    }
                }
                for (Node2 nei : node.children.values()) {
                    stack.push(nei);
                }
            }
        }

        return ans;
    }
}
