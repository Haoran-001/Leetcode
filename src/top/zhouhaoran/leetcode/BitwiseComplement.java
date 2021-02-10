package top.zhouhaoran.leetcode;

public class BitwiseComplement {
    public static void main(String[] args) {
        BitwiseComplement bitwiseComplement = new BitwiseComplement();
        int ans = bitwiseComplement.bitwiseComplement(10);
        System.out.println(ans);
    }

    public int bitwiseComplement(int N) {
        if (N == 0) {
            return 1;
        }


        StringBuilder sb = new StringBuilder();

        int remainder = 0, quotient = 0;

        while (N != 0) {
            remainder = N % 2;
            quotient = N / 2;
            sb.append(remainder);
            N = quotient;
        }

        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '0') {
                sb2.append(1);
            } else {
                sb2.append(0);
            }
        }

        int ans = 0;

        for (int i = 0; i < sb2.length(); i++) {
            ans += (sb2.charAt(i) - '0') * (int)(Math.pow(2, i));
        }

        return ans;
    }
}
