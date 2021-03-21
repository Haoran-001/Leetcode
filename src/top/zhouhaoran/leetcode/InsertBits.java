package top.zhouhaoran.leetcode;

public class InsertBits {
    public static void main(String[] args) {
        InsertBits insertBits = new InsertBits();
        System.out.println(insertBits.insertBits(1143207437, 1017033, 11, 31));
    }

    public int insertBits(int N, int M, int i, int j) {
        for(int k = i; k <= j; k++) {
            N &= ~(1 << k);
        }

        return N + (M << i);
    }
}
