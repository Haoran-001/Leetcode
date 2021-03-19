package top.zhouhaoran.leetcode;

public class HammingWeight {
    public static void main(String[] args) {
        HammingWeight hammingWeight = new HammingWeight();
        int ans = hammingWeight.hammingWeight(-3);
        System.out.println(ans);
    }

    public int hammingWeight(int n) {
        long completeCode = getCompleteCode2(n);
        int count = 0;

        for (int i = 0; i < 32; i++) {
            if ((completeCode & 1) == 1) {
                count++;
            }
            completeCode = completeCode >> 1;
        }

        return count;
    }

    private long getCompleteCode(int n) {
        long num = n;
        StringBuilder sb = new StringBuilder();

        if (n >= 0) {
            return n;
        }

        for (int i = 0; i < 32; i++) {
            long temp = (n & 0x80000000 >>> i) >>> (31 - i);
            sb.append(temp);
        }

        return Long.parseLong(sb.toString(), 2);
    }

    private long getCompleteCode2(int n) {
        long num = n;
        long ans = 0;

        if (n >= 0) {
            return n;
        }

        for (int i = 0; i < 32; i++) {
            int bit = ((n & 0x80000000 >>> i) >>> (31 - i));
            if (bit == 1) {
                ans += (long)(Math.pow(2, 31 - i));
            }
        }

        return ans;
    }
}
