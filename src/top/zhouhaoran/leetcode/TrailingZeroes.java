package top.zhouhaoran.leetcode;

import java.math.BigInteger;

public class TrailingZeroes {
    public static void main(String[] args) {
        TrailingZeroes trailingZeroes = new TrailingZeroes();
        System.out.println(trailingZeroes.trailingZeroes3(100));
    }

    public int trailingZeroes(int n) {
        BigInteger nFactorial = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            nFactorial = nFactorial.multiply(BigInteger.valueOf(i));
        }

        int zeroCount = 0;

        while (nFactorial.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
            zeroCount++;
            nFactorial = nFactorial.divide(BigInteger.TEN);
        }

        return zeroCount;
    }

    public int trailingZeroes2(int n) {
        int zeroCount = 0;

        for (int i = 5; i <= n; i = i + 5) {
            int currentFactor = i;
            while (currentFactor % 5 == 0) {
                zeroCount++;
                currentFactor = currentFactor / 5;
            }
        }

        return zeroCount;
    }

    public int trailingZeroes3(int n) {
        int zeroCount = 0;
        int powerOf5 = 5;

        while (n >= powerOf5) {
            zeroCount = zeroCount + n / powerOf5;
            powerOf5 *= 5;
        }

        return zeroCount;
    }

    public int trailingZeroes4(int n) {
        int zeroCount = 0;
        int i = 1;

        while (n > 0) {
            zeroCount += n / 5;
            n = n / 5;
        }

        return zeroCount;
    }
}
