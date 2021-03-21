package top.zhouhaoran.leetcode;

public class CountPrimeSetBits {
    public static void main(String[] args) {
        CountPrimeSetBits countPrimeSetBits = new CountPrimeSetBits();
        int ans = countPrimeSetBits.countPrimeSetBits(842, 888);
        System.out.println(ans);
    }

    public int countPrimeSetBits(int L, int R) {
        int count = 0;
        for (int i = L; i <= R; i++) {
            if (isSmallPrime(bitCount(i))) {
                count++;
            }
        }

        return count;
    }

    private boolean isSmallPrime(int num) {
        return num == 2 || num == 3 || num == 5 || num == 7 || num == 11
                || num == 13 || num == 17 || num == 19;
    }

    private int bitCount(int num) {
        int count = 0;
        while (num > 0) {
            int bit = num & 1;
            count = bit == 1 ? count + 1 : count;
            num >>= 1;
        }

        return count;
    }
}
