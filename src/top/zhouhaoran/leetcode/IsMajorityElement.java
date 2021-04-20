package top.zhouhaoran.leetcode;

public class IsMajorityElement {
    public static void main(String[] args) {
        IsMajorityElement isMajorityElement = new IsMajorityElement();
        int[] nums = {10,100,101,101};
        int target = 101;
        System.out.println(isMajorityElement.isMajorityElement3(nums, target));
    }

    public boolean isMajorityElement(int[] nums, int target) {
        int n = nums.length;
        int leastCount = n / 2 + 1;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                count++;
                if (count == leastCount) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isMajorityElement2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            if (nums[left] < target) {
                left++;
            } else if (nums[left] > target) {
                return false;
            }

            if (nums[right] > target) {
                right--;
            } else if (nums[right] < target) {
                return false;
            }

            if (nums[left] == target && nums[right] == target) {
                break;
            }
        }

        return (right - left + 1) >= (nums.length / 2 + 1);
    }

    public boolean isMajorityElement3(int[] nums, int target) {
        int left = binarySearchLeft(nums, target);
        int right = binarySearchRight(nums, target);

        if (left == -1 || right == -1) {
            return false;
        }

        return (right - left + 1) >= (nums.length / 2 + 1);
    }

    private int binarySearchLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (left < nums.length && nums[left] == target) {
            return left;
        } else {
            return -1;
        }
    }

    private int binarySearchRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (right < nums.length && nums[right] == target) {
            return right;
        } else {
            return -1;
        }
    }
}
