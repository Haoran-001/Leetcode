package top.zhouhaoran.leetcode;

public class FindNumbers {
    public static void main(String[] args) {
        int[] nums= {12,3456,2,6,7896};
        FindNumbers findNumbers = new FindNumbers();
        System.out.println(findNumbers.findNumbers2(nums));
    }

    public int findNumbers(int[] nums) {
        int count = 0;
        String[] stringNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            stringNums[i] = String.valueOf(nums[i]);
        }

        for (String stringNum : stringNums) {
            if (stringNum.length() % 2 == 0) {
                count++;
            }
        }

        return count;
    }

    // 10^(k-1) <= x < 10^k  -> k-1 <= log10(x) < k -> k = math.floor(log10(x))+1
    public int findNumbers2(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int k = (int) (Math.ceil(Math.floor(Math.log10(nums[i])) + 1));
            if (k % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}
