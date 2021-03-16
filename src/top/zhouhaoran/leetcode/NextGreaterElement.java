package top.zhouhaoran.leetcode;

import java.util.*;

public class NextGreaterElement {
    public static void main(String[] args) {
        NextGreaterElement nextGreaterElement = new NextGreaterElement();

        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        System.out.println(Arrays.toString(nextGreaterElement.nextGreaterElement(nums1, nums2)));
    }
    //  2 3 5 1 0 7 3     (2, 3) (3, 5), (0, 7), (1, 7), (5, 7)
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }

        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }

        for (int i = 0; i < ans.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}
