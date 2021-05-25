package top.zhouhaoran.leetcode;

public class TranslateNum {
    public static void main(String[] args) {
        TranslateNum translateNum = new TranslateNum();
        int ans = translateNum.translateNum(1223);
        System.out.println(ans);
    }

    public int translateNum(int num) {
        if (num <= 9) return 1;

        // 获取输入数字的余数, 然后递归计算翻译方案
        int ba = num % 100;
        // 如果小于等于9或者大于等于26的时候, 余数不能按照2位数字的组合, 比如56只能拆分成5和6
        // 反例, 25能够拆分成2和5也可以拆分成一个25
        if (ba <= 9 || ba >= 26) return translateNum(num / 10);
        // ba = [10, 25]，既可以当做一个字母, 也可以当做两个字母
        else return translateNum(num / 10) + translateNum(num / 100);
    }
}
