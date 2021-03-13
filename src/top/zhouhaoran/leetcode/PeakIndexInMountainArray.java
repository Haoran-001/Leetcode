package top.zhouhaoran.leetcode;

public class PeakIndexInMountainArray {
    public static void main(String[] args) {
        PeakIndexInMountainArray peakIndexInMountainArray = new PeakIndexInMountainArray();
        int ans = peakIndexInMountainArray.peakIndexInMountainArray2(new int[]{0, 2, 1, 0});
        System.out.println(ans);
    }

    public int peakIndexInMountainArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return i;
            }
        }

        return -1;
    }

    // 0 2 1 0
    public int peakIndexInMountainArray2(int[] arr) {
        int left = 0, right = arr.length - 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else if (arr[mid] > arr[mid + 1]) {
                right = mid - 1;
            }
        }

        return left;

    }
}
