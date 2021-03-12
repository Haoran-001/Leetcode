package top.zhouhaoran.leetcode;

public class FirstBadVersion {
    public static void main(String[] args) {

    }

    public int firstBadVersion(int n) {
        int left = 1, right = n;
// A A A B B B B
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean isBadVersion(int i) {
        return true;
    }
}
