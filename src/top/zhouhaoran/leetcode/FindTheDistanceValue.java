package top.zhouhaoran.leetcode;

import java.util.Arrays;

public class FindTheDistanceValue {
    public static void main(String[] args) {
        FindTheDistanceValue findTheDistanceValue = new FindTheDistanceValue();
        int[] arr1 = {4, 5, 8}, arr2 = {10, 9, 1, 8};
        System.out.println(findTheDistanceValue.findTheDistanceValue(arr1, arr2, 2));
    }
    // 4 5 8
    // 1 8 9 10
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        int i, j;
        for (i = 0; i < arr1.length; i++) {
            for (j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d) {
                    break;
                }
            }
            if (j == arr2.length) {
                count++;
            }
        }

        return count;
    }

    public int findTheDistanceValue2(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int cnt = 0;
        for (int x : arr1) {
            int p = binarySearch(arr2, x);
            boolean ok = true;
            if (p < arr2.length) {
                ok &= arr2[p] - x > d;
            }
            if (p - 1 >= 0 && p - 1 <= arr2.length) {
                ok &= x - arr2[p - 1] > d;
            }
            cnt += ok ? 1 : 0;
        }
        return cnt;
    }

    public int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        if (arr[high] < target) {
            return high + 1;
        }
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
