package top.zhouhaoran.leetcode;

import java.util.*;

public class FindLongestSubarray {
    public static void main(String[] args) {
        FindLongestSubarray findLongestSubarray = new FindLongestSubarray();
        // String[] array = {"42","10","O","t","y","p","g","B","96","H","5","v","P","52","25","96","b","L","Y","z","d","52","3","v","71","J","A"};
        //String[] array = {"A","1","B","C","2","4"};
        // String[] array = {"A", "A"};
        // String[] array = {"A", "B", "1", "2", "A", "B", "A", "A", "3", "6"};
        String[] array = {"A", "B", "1", "2", "A"};

        System.out.println(Arrays.toString(findLongestSubarray.findLongestSubarray4(array)));
    }

    public String[] findLongestSubarray(String[] array) {
        int[] temp = new int[2 * array.length + 1];
        Arrays.fill(temp, -2);
        temp[array.length] = -1;
        int count = 0;
        int start = -1, end = -1, maxLen = 0;

        for (int i = 0; i < array.length; i++) {
            count = count + (Character.isLetter(array[i].charAt(0)) ? 1 : -1);

            if (temp[count + array.length] >= -1) {
                if (maxLen < i - temp[count + array.length]) {
                    start = temp[count + array.length] + 1;
                    end = i + 1;
                    maxLen = i - temp[count + array.length];
                }
            } else {
                temp[count + array.length] = i;
            }
        }

        if (start == -1 || end == -1) {
            return new String[]{};
        }

        return Arrays.copyOfRange(array, start, end);
    }

    public String[] findLongestSubarray2(String[] array) {
        int len = array.length;
        int[] memo = new int[(len << 1) + 1];
        Arrays.fill(memo, -2);
        memo[len] = -1;
        int res = 0, count = 0, begin = 0, end = 0;
        for (int i = 0; i < len; ++i) {
            boolean is_num = true;
            for (char c : array[i].toCharArray())
                if (c < '0' || c > '9') {
                    is_num = false;
                    break;
                }
            count += is_num ? -1 : 1;
            //未曾见过该前缀和(即memo数组中没有记录)
            if (memo[count + len] <= -2)
                memo[count + len] = i;  //记录该前缀和的下标
                //曾见过该前缀和(即memo数组中已有记录)
            else if (i - memo[count + len] > res) {
                begin = memo[count + len] + 1;
                end = i + 1;
                res = i - memo[count + len];
            }
        }
        return Arrays.copyOfRange(array, begin, end);
    }

    public String[] findLongestSubarray3(String[] array) {
        int[] temp = new int[2 * array.length + 1];

        Arrays.fill(temp, -2);
        temp[array.length] = -1;
        int count = 0;
        int maxSubLen = 0;
        int maxSubStart = -1, maxSubEnd = -1;

        for (int i = 0; i < array.length; i++) {
            if (Character.isLetter(array[i].charAt(0))) {
                count++;
            } else {
                count--;
            }

            if (temp[count + array.length] == -2) {
                temp[count + array.length] = i;
            } else {
                if (maxSubLen < i - temp[count + array.length]) {
                    maxSubLen = i - temp[count + array.length];
                    maxSubStart = temp[count + array.length] + 1;
                    maxSubEnd = i + 1;
                }
            }
        }

        if (maxSubStart == -1 || maxSubEnd == -1) {
            return new String[]{};
        }

        return Arrays.copyOfRange(array, maxSubStart, maxSubEnd);
    }

    public String[] findLongestSubarray4(String[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0;
        int maxSubLen = 0;
        int maxSubStart = -1, maxSubEnd = -1;

        for (int i = 0; i < array.length; i++) {
            count += (Character.isLetter(array[i].charAt(0)) ? 1 : -1);

            if (map.containsKey(count)) {
                if (maxSubLen < i - map.get(count)) {
                    maxSubLen = i - map.get(count);
                    maxSubStart = map.get(count) + 1;
                    maxSubEnd = i + 1;
                }
            } else {
                map.put(count, i);
            }
        }

        if (maxSubStart == -1 || maxSubEnd == -1) {
            return new String[]{};
        }

        return Arrays.copyOfRange(array, maxSubStart, maxSubEnd);
    }
}
