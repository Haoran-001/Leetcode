package top.zhouhaoran.leetcode;

public class Calculate {
    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        System.out.println(calculate.calculate("AB"));
    }

    public int calculate(String s) {
        int x = 1, y = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                x = 2 * x + y;
            } else if (c == 'B') {
                y = 2 * y + x;
            }
        }

        return x + y;
    }
}
