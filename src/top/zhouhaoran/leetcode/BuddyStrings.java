package top.zhouhaoran.leetcode;

public class BuddyStrings {
    public static void main(String[] args) {
        BuddyStrings buddyStrings = new BuddyStrings();
        String A = "abcd", B = "abcd";
        System.out.println(buddyStrings.buddyStrings(A, B));
    }

    /**
     * 不相等的情况包括:
     * 1. A, B两个字符串的长度不相等
     * 2. A, B两个字符串完全相同, 但是所包含的字符均只出现了1次, 则交换后一定不相等
     * 相等的情况:
     * 1. A, B两个字符串完全相同, 且所包含的字符中至少有一个至少出现了2次, 则交换后一定相等
     * 2. A, B两个字符串长度相等, 只存在一处不同, 假设为A[i] != B[i], A[j] != B[j],
     * 但是通过A[i]=B[j], A[j]=B[i], 其余情况则仍然不相等
     * @param A
     * @param B
     * @return boolean
     */
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        if (A.equals(B)) {
            int[] count = new int[26];
            for (char c : A.toCharArray()) {
                count[c - 'a']++;
            }
            for (int num : count) {
                if (num > 1) return true;
            }
            return false;
        }

        int first = -1, second = -1;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == B.charAt(i)) {
                continue;
            }
            if (first == -1) {
                first = i;
            } else if (second == -1) {
                second = i;
            } else {
                return false;
            }
        }

        return (first != -1 && second != -1 && (A.charAt(first) == B.charAt(second)
                && A.charAt(second) == B.charAt(first)));
    }
}
