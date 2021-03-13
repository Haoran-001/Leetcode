package top.zhouhaoran.leetcode;

public class BinSearch {
    public static void main(String[] args) {
        BinSearch binSearch = new BinSearch();
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        System.out.println(binSearch.search(nums, target));
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }

        return -1;
    }
}
