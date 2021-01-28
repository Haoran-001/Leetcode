package top.zhouhaoran.leetcode;

import java.util.Arrays;

public class Decrypt {
    public static void main(String[] args) {
        Decrypt decrypt = new Decrypt();
        int[] code = {5, 7, 1, 4};
        int k = -3;
        System.out.println(Arrays.toString(decrypt.decrypt(code, k)));
    }

    public int[] decrypt(int[] code, int k) {
        int[] ans = new int[code.length];
        if (k > 0) {
            for (int i = 0; i < ans.length; i++) {
                int index = (i + 1) % code.length;
                for (int j = 0; j < k; j++) {
                    ans[i] += code[index];
                    index = (index + 1) % code.length;
                }
            }
        } else if (k < 0) {
            for (int i = 0; i < ans.length; i++) {
                int index = (i - 1 + code.length) % code.length;
                for (int j = 0; j < -k; j++) {
                    ans[i] += code[index];
                    index = (index - 1 + code.length) % code.length;
                }
            }
        } else {
            Arrays.fill(ans, 0);
        }

        return ans;
    }
}
