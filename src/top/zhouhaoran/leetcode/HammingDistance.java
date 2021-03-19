package top.zhouhaoran.leetcode;

public class HammingDistance {
    public static void main(String[] args) {
        HammingDistance hammingDistance = new HammingDistance();
        System.out.println(hammingDistance.hammingDistance(1, 4));
    }

    public int hammingDistance(int x, int y) {
        int bit1 = 0, bit2 = 0;
        int count = 0;

        while (x > 0 && y > 0) {
            bit1 = x & 1;
            bit2 = y & 1;

            if ((bit1 ^ bit2) == 1) {
                count++;
            }

            x = x >> 1;
            y = y >> 1;
        }

        while (x > 0) {
            bit1 = x & 1;
            if (bit1 == 1) {
                count++;
            }
            x = x >> 1;
        }

        while (y > 0) {
            bit2 = y & 1;
            if (bit2 == 1) {
                count++;
            }
            y = y >> 1;
        }

        return count;
    }
}
