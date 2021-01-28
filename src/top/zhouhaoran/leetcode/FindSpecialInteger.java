package top.zhouhaoran.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FindSpecialInteger {
    public static void main(String[] args) {
        FindSpecialInteger findSpecialInteger = new FindSpecialInteger();
        int[] arr = {1,2,2,6,6,6,6,7,10};
        System.out.println(findSpecialInteger.findSpecialInteger2(arr));
    }

    public int findSpecialInteger(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = arr.length;
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if ((double)entry.getValue() / (double)len > 0.25) {
                return entry.getKey();
            }
        }

        return -1;
    }

    public int findSpecialInteger2(int[] arr) {
        // count * 4 > arr.length
        int cur = arr[0];
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == cur) {
                count++;
            } else {
                if (count * 4 > arr.length) {
                    return cur;
                } else {
                    cur = arr[i];
                    count = 1;
                }
            }
        }

        if (count * 4 > arr.length) {
            return cur;
        } else {
            return -1;
        }
    }
}
