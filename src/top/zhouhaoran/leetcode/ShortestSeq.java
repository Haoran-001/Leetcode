package top.zhouhaoran.leetcode;

import java.util.*;

public class ShortestSeq {
    public static void main(String[] args) {
        ShortestSeq shortestSeq = new ShortestSeq();
//        int[] big = {7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7};
//        int[] small = {1, 5, 9};
//        int[] big = {842, 336, 777, 112, 789, 801, 922, 874, 634, 121, 390, 614, 179, 565, 740, 672, 624, 130, 555, 714, 9, 950, 887, 375, 312, 862, 304, 121, 360, 579, 937, 148, 614, 885, 836, 842, 505, 187, 210, 536, 763, 880, 652, 64, 272, 675, 33, 341, 101, 673, 995, 485, 16, 434, 540, 284, 567, 821, 994, 174, 634, 597, 919, 547, 340, 2, 512, 433, 323, 895, 965, 225, 702, 387, 632, 898, 297, 351, 936, 431, 468, 694, 287, 671, 190, 496, 80, 110, 491, 365, 504, 681, 672, 825, 277, 138, 778, 851, 732, 176};
//        int[] small = {950, 885, 702, 101, 312, 652, 555, 936, 842, 33, 634, 851, 174, 210, 287, 672, 994, 614, 732, 919, 504, 778, 340, 694, 880, 110, 777, 836, 365, 375, 536, 547, 887, 272, 995, 121, 225, 112, 740, 567, 898, 390, 579, 505, 351, 937, 825, 323, 874, 138, 512, 671, 297, 179, 277, 304};
        int[] big = {1, 1, 1, 2, 3};
        int[] small = {1, 1, 2};
        System.out.println(Arrays.toString(shortestSeq.shortestSeq(big, small)));
    }

    /**
     *
     * @param big
     * @param small
     * @return int[]
     * 使用滑动窗口的方式来解此题
     * 定义两个指针left和right, 初始化都为0
     * 对当前[left, right]区间中的数判断是否包含small数组中的所有元素,并且每个元素的次数也相同
     * 如果还有未包含的数, 则right指针向右滑动, 直到right指向big.length
     * 如果当前[left, right]区间中的数已经包含small数组中的所有元素, 则将left指针向右滑动, 接着判断这个区间是否包含small数组中的所有元素
     * 若包含, 则比较当前[left, right]的区间长度和最小长度哪个更小
     * 具体来说, 需要定义一个哈希表, 存放small数组中的所有元素, 由于可能有重复元素, 所以以哈希表的方式记录每个元素出现的次数
     * 每次right指向的元素如果包含在哈希表中, 则对应哈希表键对应的值1, 并设置一个变量n记录small数组元素的个数, 若获得哈希表键对应的值大于0, 则对n减1操作
     * 直到n = 0,表示找到了一个合法的解
     * 再判断left指针指向的元素是否包含在哈希表键中, 若包含, 则哈希表中的键对应的值进行加1操作, 若哈希表键对应的值大于1,则对n加1操作
     */
    public int[] shortestSeq(int[] big, int[] small) {
        Map<Integer, Integer> map = new HashMap<>();
        int smallLen = small.length;
        int bigLen = big.length;
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int[] res = new int[]{-1, -1};

        for (int i = 0; i < smallLen; i++) {
            map.put(small[i], map.getOrDefault(small[i], 0) + 1);
        }

        while (right < bigLen) {
            if (map.containsKey(big[right])) {
                int value = map.get(big[right]);
                if (value > 0) {
                    smallLen--;
//                    value--;
//                    map.put(big[right], value);
                }
                value--;
                map.put(big[right], value);
            }

            while (smallLen == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    res = new int[] {left, right};
                }

                if (map.containsKey(big[left])) {
                    int value2 = map.get(big[left]);
                    if (value2 >= 0) {
                        smallLen++;
                        // 以下两行需要写在if外面, 否则针对big: [1 1 1 2 3] small: [1 1 2]找到的是[0, 3]但实际是[1, 3]
//                        value2++;
//                        map.put(big[left], value2);
                    }
                    value2++;
                    map.put(big[left], value2);
                }
                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? new int[]{} : res;
    }
}
