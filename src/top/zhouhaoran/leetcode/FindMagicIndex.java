package top.zhouhaoran.leetcode;

public class FindMagicIndex {
    public static void main(String[] args) {
        FindMagicIndex findMagicIndex = new FindMagicIndex();
        int[] nums = {0, 2, 3, 4, 5};
        int ans = findMagicIndex.findMagicIndex(nums);
        System.out.println(ans);
    }

    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                return i;
            }
        }

        return -1;
    }
}
