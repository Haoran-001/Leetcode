package top.zhouhaoran.leetcode;

public class ConvertToBase7 {
    public static void main(String[] args) {
        ConvertToBase7 convertToBase7 = new ConvertToBase7();
        String ans = convertToBase7.convertToBase7(-7);
        System.out.println(ans);
    }

    public String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        int numCopy = num;

        if (num == 0) {
            sb.append(0);
        }

        while (numCopy != 0) {
            int remainder = mod(numCopy, 7);
            int quotient = numCopy / 7;
            sb.append(remainder);
            numCopy = quotient;
        }

        if (num < 0) {
            sb.append('-');
        }
        return sb.reverse().toString();
    }

    private int mod(int num1, int num2) {
        if (num1 > 0) {
            return num1 % num2;
        }

        return -num1 % num2;
    }
}
