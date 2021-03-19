package top.zhouhaoran.leetcode;

public class FindComplement {
    public static void main(String[] args) {
        FindComplement findComplement = new FindComplement();
        System.out.println(findComplement.findComplement(1));
    }

    public int findComplement(int num) {
        int ans = 0;
        int index = 0;

        while (num > 0) {
            int bit = num & 1;
            if (bit == 0) {
                ans += (int)Math.pow(2, index);
            }

            num = num >> 1;
            index++;
        }

        return ans;
    }
}
