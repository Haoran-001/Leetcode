package top.zhouhaoran.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CountLargestGroup {
    public static void main(String[] args) {
        CountLargestGroup countLargestGroup = new CountLargestGroup();
        System.out.println(countLargestGroup.countLargestGroup(13));
    }

    public int countLargestGroup(int n) {
        // 定义一个哈希表, 其键为数位和, 值为所有数位和为该值的数的个数
        Map<Integer, Integer> map = new HashMap<>();
        int maxValue = 0; // maxValue统计最大的次数
        int count = 0; // 在哈希表中有多少个值为最大次数
        for (int i = 1; i <= n; i++) {
            int key = 0, i0 = i;
            // 统计每个数字的数位和
            while (i0 != 0) {
                key += i0 % 10;
                i0 = i0 / 10;
            }
            map.put(key, map.getOrDefault(key, 0) + 1);
            maxValue = Math.max(maxValue, map.get(key));
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxValue) {
                count++;
            }
        }

        return count;
    }
}
