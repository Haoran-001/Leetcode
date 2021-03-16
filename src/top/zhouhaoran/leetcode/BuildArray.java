package top.zhouhaoran.leetcode;

import java.util.*;

public class BuildArray {
    public static void main(String[] args) {
        BuildArray buildArray = new BuildArray();
        int[] target = {1, 2};
        int n = 4;
        List<String> ans = buildArray.buildArray(target, n);
        System.out.println(ans);
    }

    public List<String> buildArray(int[] target, int n) {
        Set<Integer> set = new HashSet<>();
        List<String> ans = new ArrayList<>();

        for (int i : target) {
            set.add(i);
        }

        for (int i = 1; i <= n; i++) {
            if (set.isEmpty()) {
                break;
            }
            if (set.contains(i)) {
                set.remove(Integer.valueOf(i));
                ans.add("Push");
            } else {
                ans.add("Push");
                ans.add("Pop");
            }
        }

        return ans;
    }
    // 1 3 5    1-6  1 1  3 2
    public List<String> buildArray2(int[] target, int n) {
        final String PUSH = "Push";
        final String POP = "Pop";
        List<String> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 1, j = 0; i <= n && j < target.length; i++) {
            stack.push(i);
            ans.add(PUSH);

            if (stack.peek() != target[j]) {
                stack.pop();
                ans.add(POP);
            } else {
                j++;
            }
        }

        return ans;
    }

    public List<String> buildArray3(int[] target, int n) {
        final String PUSH = "Push";
        final String POP = "Pop";
        List<String> ans = new ArrayList<>();

        for (int i = 1, j = 0; i <= n && j < target.length; i++) {
            if (i == target[j]) {
                ans.add(PUSH);
                j++;
            } else {
                ans.add(PUSH);
                ans.add(POP);
            }
        }

        return ans;
    }
}
