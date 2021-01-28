package top.zhouhaoran.leetcode;

import java.util.Arrays;

public class DuplicateZeros {
    public static void main(String[] args) {
        DuplicateZeros duplicateZeros = new DuplicateZeros();
        int[] arr = {1, 0, 2, 0, 3, 0, 4, 4};
        duplicateZeros.duplicateZeros2(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void duplicateZeros(int[] arr) {
        int possibleDups = 0;
        int length_ = arr.length - 1;

        // Find the number of zeros to be duplicated
        // Stopping when left points beyond the last element in the original array
        // which would be part of the modified array
        for (int left = 0; left <= length_ - possibleDups; left++) {

            // Count the zeros
            if (arr[left] == 0) {

                // Edge case: This zero can't be duplicated. We have no more space,
                // as left is pointing to the last element which could be included
                if (left == length_ - possibleDups) {
                    // For this zero we just copy it without duplication.
                    arr[length_] = 0;
                    length_ -= 1;
                    break;
                }
                possibleDups++;
            }
        }

        // Start backwards from the last element which would be part of new array.
        int last = length_ - possibleDups;

        // Copy zero twice, and non zero once.
        for (int i = last; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + possibleDups] = 0;
                possibleDups--;
                arr[i + possibleDups] = 0;
            } else {
                arr[i + possibleDups] = arr[i];
            }
        }
    }

    /**
     * possibleDups统计需要复写的0的个数, 也即数组中需要抛弃的元素个数
     * 对数组进行两次扫描, 第一次扫描为统计需要抛弃的元素个数, 第二次是进行从右往左迭代复制元素
     * 第一次扫描时, 判断当前元素若不为0, 则什么也不做; 若为0, 则判断其是否为最后一个边界0元素,
     * 因为在数组中没有额外空间可以用于复写, 所以直接复制到数组的最后位置即可, 否则将possibleDups加1,表示需要多抛弃数组后的一个元素
     * 第二次扫描时, 用数组最后下表位置减去possibleDups得到的位置从右往左进行迭代复制元素即可
     * @param arr
     */
    public void duplicateZeros2(int[] arr) {
        int possibleDups = 0;
        int endIndex = arr.length - 1;
        // 1 0 0 0
        for (int i = 0; i <= endIndex - possibleDups; i++) {
            if (arr[i] == 0) {
                if (i == endIndex - possibleDups) {
                    arr[endIndex] = 0;
                    endIndex -= 1;
                    break;
                }
                possibleDups++;
            }
        }

        int lastIndex = endIndex - possibleDups;
        for (int i = lastIndex; i >=0; i--) {
            if (arr[i] == 0) {
                arr[i+possibleDups] = arr[i];
                possibleDups--;
                arr[i+possibleDups] = arr[i];
            } else {
                arr[i+possibleDups] = arr[i];
            }
        }
    }
}
