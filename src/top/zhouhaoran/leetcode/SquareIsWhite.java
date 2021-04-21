package top.zhouhaoran.leetcode;

public class SquareIsWhite {
    public static void main(String[] args) {
        SquareIsWhite squareIsWhite = new SquareIsWhite();
        String coordinates = "c7";
        System.out.println(squareIsWhite.squareIsWhite(coordinates));
    }

    public boolean squareIsWhite(String coordinates) {
        int row = coordinates.charAt(0) - 'a';
        int col = coordinates.charAt(1) - '1';

        // 偶数行的奇数列和奇数行的偶数列均为白色
        // 相反为黑色
        if (((row & 1) == 0 && (col & 1) == 1) || ((row & 1) == 1 && (col & 1) == 0)) {
            return true;
        }

        return false;
    }
}
