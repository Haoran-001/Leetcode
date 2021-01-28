package top.zhouhaoran.leetcode;

public class KLengthApart {
    public static void main(String[] args) {
        KLengthApart kLengthApart = new KLengthApart();
        int[] nums = {1,0,0,0,1,0,0,1,0};
        int k = 2;
        System.out.println(kLengthApart.kLengthApart(nums, k));
    }

    public boolean kLengthApart(int[] nums, int k) {
        int startIndex;
        int interval = 0;
        // 找到数组中第一个1的下标
        for (startIndex = 0; startIndex < nums.length; startIndex++) {
            if (nums[startIndex] == 1) {
                break;
            }
        }

        for (int i = startIndex + 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                interval++;
            } else if (nums[i] == 1) {
                if (interval < k) {
                    return false;
                }
                interval = 0;
            }
        }

        return true;
    }
}
