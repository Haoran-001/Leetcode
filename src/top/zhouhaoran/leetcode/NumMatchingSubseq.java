package top.zhouhaoran.leetcode;

import java.util.*;

public class NumMatchingSubseq {
    public static void main(String[] args) {
        NumMatchingSubseq numMatchingSubseq = new NumMatchingSubseq();
        String s = "abcde";
        String[] words = {"a", "bb", "acd", "ace"};
        System.out.println(numMatchingSubseq.numMatchingSubseq(s, words));
    }

    public int numMatchingSubseq(String s, String[] words) {
        ArrayList<OneNode>[] heads = new ArrayList[26];
        int ans = 0;

        for (int i = 0; i < 26; i++) {
            heads[i] = new ArrayList<OneNode>();
        }

        for (String word : words) {
            heads[word.charAt(0) - 'a'].add(new OneNode(word, 0));
        }

        for (char c : s.toCharArray()) {
            ArrayList<OneNode> tempList = heads[c - 'a'];
            heads[c - 'a'] = new ArrayList<OneNode>();

            for (OneNode node : tempList) {
                node.index++;
                if (node.index == node.word.length()) {
                    ans++;
                } else {
                    heads[node.word.charAt(node.index) - 'a'].add(node);
                }
            }
        }

        return ans;
    }
}

class OneNode {
    String word;
    int index;

    public OneNode(String word, int index) {
        this.word = word;
        this.index = index;
    }
}

