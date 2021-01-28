package top.zhouhaoran.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement.majorityElement2(nums));
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int k = nums.length / 2;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > k) {
                return entry.getKey();
            }
        }

        return -1;
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        int k = nums.length / 2;
        int count = 1;
        int curNum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == curNum) {
                count++;
            } else {
                if (count > k) {
                    return curNum;
                } else {
                    curNum = nums[i];
                    count = 1;
                }
            }
        }

        if (count > k) {
            return curNum;
        } else {
            return -1;
        }
    }
}
