package top.zhouhaoran.leetcode;

public class MajorityElement2 {
    public static void main(String[] args) {
        MajorityElement2 majorityElement = new MajorityElement2();
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(majorityElement.majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        int votes = 0, majorElement = 0, count = 0;
        for (int num : nums) {
            if (votes == 0) {
                majorElement = num;
            }
            votes += num == majorElement ? 1 : -1;
        }

        for (int num : nums) {
            if (num == majorElement) {
                count++;
            }
        }

        return count > nums.length / 2 ? majorElement : 0;
    }
}
