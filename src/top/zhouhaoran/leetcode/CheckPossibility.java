package top.zhouhaoran.leetcode;

public class CheckPossibility {
    public static void main(String[] args) {
        CheckPossibility checkPossibility = new CheckPossibility();
        int[] nums = {4, 2, 3};
        System.out.println(checkPossibility.checkPossibility(nums));
    }

    // 2 4 2 6   3 4 2 6
    // 3 3 3 5 5 4
    public boolean checkPossibility(int[] nums) {
        int count = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                count++;
                if (count > 1) {
                    return false;
                }

                if (i - 2 < 0 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }
            }
        }

        return true;
    }
}
