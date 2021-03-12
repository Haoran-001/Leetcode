package top.zhouhaoran.leetcode;

import java.util.*;

public class FindContentChildren {
    public static void main(String[] args) {
        FindContentChildren findContentChildren = new FindContentChildren();
        int[] g = {1, 2, 3}, s = {1, 1};
        System.out.println(findContentChildren.findContentChildren(g, s));
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int numOfChildren = g.length, numOfCookies = s.length;
        int count = 0;

        for (int i = 0, j = 0; i < numOfChildren && j < numOfCookies; i++, j++) {
            while (j < numOfCookies && g[i] > s[j]) {
                j++;
            }

            if (j < numOfCookies) {
                count++;
            }
        }

        return count;
    }
}
