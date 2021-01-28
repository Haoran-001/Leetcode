package top.zhouhaoran.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CreateTargetArray {
    public static void main(String[] args) {
        CreateTargetArray createTargetArray = new CreateTargetArray();
        int[] nums = {0, 1, 2, 3, 4}, index = {0, 1, 2, 2, 1};
        int[] ans = createTargetArray.createTargetArray(nums, index);
        System.out.println(Arrays.toString(ans));
    }

    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < index.length; i++) {
            list.add(index[i], nums[i]);
        }

        int[] ans = list.stream().mapToInt(Integer::valueOf).toArray();

        return ans;
    }
}
