package top.zhouhaoran.leetcode;

public class MinCostToMoveChips {
    public static void main(String[] args) {
        MinCostToMoveChips minCostToMoveChips = new MinCostToMoveChips();
        int[] position = {2, 2, 2, 3, 3};
        System.out.println(minCostToMoveChips.minCostToMoveChips(position));
    }

    public int minCostToMoveChips(int[] position) {
        int odd = 0, even = 0;

        for (int pos : position) {
            if (pos % 2 == 1) {
                odd++;
            } else if (pos % 2 == 0) {
                even++;
            }
        }

        return Math.min(odd, even);
    }
}
