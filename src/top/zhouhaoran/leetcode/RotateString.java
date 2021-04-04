package top.zhouhaoran.leetcode;

public class RotateString {
    public static void main(String[] args) {
        RotateString rotateString = new RotateString();
        String A = "abcde";
        String B = "cdeab";
        boolean ans = rotateString.rotateString(A, B);
        System.out.println(ans);
    }

    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }

        boolean ans = (A + A).contains(B);
        return ans;
    }
}
