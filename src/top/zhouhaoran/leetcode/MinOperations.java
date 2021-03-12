package top.zhouhaoran.leetcode;

public class MinOperations {
    public static void main(String[] args) {
        MinOperations minOperations = new MinOperations();
        System.out.println(minOperations.minOperations("110010"));
    }

    public int minOperations(String s) {
        // 1010...需要的修改次数记录在diff1中
        // 0101...需要的修改次数记录在diff2中
        int diff1 = 0, diff2 = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                // 对于1010...情况, i不在偶数位则diff1加1, 0101...情况, i不在奇数位则diff2加1
                diff1 += i % 2 == 1 ? 1 : 0;
                diff2 += i % 2 == 0 ? 1 : 0;
            } else if (s.charAt(i) == '0') {
                // 对于1010...情况, i不在奇数位则diff1加1, 对于0101...情况, i不在偶数位则diff2加1
                diff1 += i % 2 == 0 ? 1 : 0;
                diff2 += i % 2 == 1 ? 1 : 0;
            }
        }

        return Math.min(diff1, diff2);
    }

    public int minOperations2(String s) {
        int n = s.length(), cnt1 = 0, cnt2 = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) % 2 == i % 2) {
                cnt1++;
            } else if (s.charAt(i) % 2 != i % 2) {
                cnt2++;
            }
        }

        return Math.min(cnt1, cnt2);
    }
}
