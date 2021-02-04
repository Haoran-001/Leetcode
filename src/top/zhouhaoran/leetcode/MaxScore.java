package top.zhouhaoran.leetcode;

public class MaxScore {
    public static void main(String[] args) {
        MaxScore maxScore = new MaxScore();
        String s = "011101";
        System.out.println(maxScore.maxScore2(s));
    }

    /**
     * 算法思想:
     * 定义两个变量cnt0记录左侧0的个数, cnt1记录右侧1的个数
     * 先统计右侧1的个数, 保存在cnt1变量中
     * 接着从左侧顺序扫描到倒数第二个位置, 判断每次的下标位置元素如果是0, 则让cnt0自增1;
     * 如果是1, 则让cnt1自减1, 然后将cnt0和cnt1加起来表示当前情况下的分值, 然后与最大分值作比较;
     * 选择最大的，直到遍历完s.length()-1个下标元素。(因为左右部分元素都至少有1个, 当前i遍历的位左端最后一个元素)
     * @param s
     * @return int
     */
    public int maxScore(String s) {
        int cnt0 = 0, cnt1 = 0;
        int maxScore = 0, curScore = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') cnt1++;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') cnt0++;
            else if (s.charAt(i) == '1') cnt1--;
            curScore = cnt0 + cnt1;
            maxScore = Math.max(maxScore, curScore);
        }

        return maxScore;
    }

    public int maxScore2(String s) {
        int cnt0 = 0, cnt1 = 0;
        int maxScore = 0, curScore = 0;

        for (char c : s.toCharArray()) {
            if (c == '0')
                cnt0++;
        }

        for (int i = s.length() - 1; i > 0; i--) {
            if (s.charAt(i) == '1') cnt1++;
            else if (s.charAt(i) == '0') cnt0--;
            curScore = cnt0 + cnt1;
            maxScore = Math.max(maxScore, curScore);
        }

        return maxScore;
    }
}
