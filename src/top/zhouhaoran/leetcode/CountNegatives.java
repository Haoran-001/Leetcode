package top.zhouhaoran.leetcode;

public class CountNegatives {
    public static void main(String[] args) {
        int[][] grid2 = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        int[][] grid = {{3, 2}, {1, 0}};
        CountNegatives countNegatives = new CountNegatives();
        
        System.out.println(countNegatives.countNegatives2(grid));
    }

    public int countNegatives(int[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0) {
                    count++;
                }
            }
        }

        return count;
    }

    public int countNegatives2(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            int left = 0, right = grid[i].length - 1;
            int start = binarySearch(grid[i], left, right);
            count = count + (right - start + 1);
        }

        return count;
    }
    // 4 2 1 -1 -2   0 4 mid = 2 ->3 4 mid = 3 -> 3  true
    // 4 2 1 -1      0 3 mid = 1 -> 2 3 mid = 2 -> 3 3 true
    // 3 2 1         0 2 mid = 1 -> 2 2 mid = 2 -> 3 2
    // -3 -2 -1      0 2 mid = 1 -> 0 0 mid = 0 -> 0 -1 true
    private int binarySearch(int[] nums, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
