package top.zhouhaoran.leetcode;

public class GuessNumber {
    public static void main(String[] args) {
        GuessNumber guessNumber = new GuessNumber();
        System.out.println(guessNumber.guessNumber(10));
    }

    public int guessNumber(int n) {
        int left = 1, right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int guessValue = guess(mid);
            if (guessValue == 0) {
                return mid;
            } else if (guessValue == -1) {
                right = mid - 1;
            } else if (guessValue == 1) {
                left = mid + 1;
            }
        }

        return -1;
    }

    private int guess(int num) {
        if (num == 6) {
            return 0;
        } else if (num < 6) {
            return 1;
        } else {
            return -1;
        }
    }
}
