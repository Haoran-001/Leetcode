package top.zhouhaoran.leetcode;

public class FindMaxConsecutiveOnes {
    public static void main(String[] args) {
        FindMaxConsecutiveOnes findMaxConsecutiveOnes = new FindMaxConsecutiveOnes();
        int[] nums = {0, 0, 1,1,0,1,1,1};
        int ans = findMaxConsecutiveOnes.findMaxConsecutiveOnes(nums);
        System.out.println(ans);
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0, curCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                curCount++;
            } else {
                maxCount = Math.max(maxCount, curCount);
                curCount = 0;
            }
        }

        maxCount = Math.max(maxCount, curCount);

        return maxCount;
    }
}
