package top.zhouhaoran.leetcode;

public class CountOdds {
    public static void main(String[] args) {
        CountOdds countOdds = new CountOdds();
        System.out.println(countOdds.countOdds2(8, 10));
    }

    public int countOdds(int low, int high) {
        int oddsCount = 0;
        for (int i = low; i <= high; i++) {
            if (i % 2 == 1) {
                oddsCount++;
            }
        }

        return oddsCount;
    }

    // 0-1 1, 0-2 1, 0-3 2, 0-4 2, 0-5 3  0-(low-1), 0-high
    public int countOdds2(int low, int high) {
        int oddsCOunt = 0;
        int zeroToLowOddsCount = (int)Math.ceil((low - 1) / 2.0);
        int zeroToHighOddsCount = (int)Math.ceil(high / 2.0);
        oddsCOunt = zeroToHighOddsCount - zeroToLowOddsCount;

        return oddsCOunt;
    }
}
