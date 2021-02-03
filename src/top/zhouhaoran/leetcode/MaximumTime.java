package top.zhouhaoran.leetcode;

import java.util.Arrays;

public class MaximumTime {
    public static void main(String[] args) {
        MaximumTime maximumTime = new MaximumTime();
        String ans = maximumTime.maximumTime("2?:?0");
        System.out.println(ans);
    }

    public String maximumTime(String time) {
        char[] times = time.toCharArray();
        int len = time.length();

        for (int i = len - 1; i >= 0; i--) {
            if (times[i] == '?') {
                if (i == len - 1)
                    times[i] = '9';
                else if (i == len - 2)
                    times[i] = '5';
                else if (i == 1) {
                    if (times[0] == '?' || times[0] == '2')
                        times[i] = '3';
                    else
                        times[i] = '9';
                }
                // 只剩时位情况
                else {
                    if (times[1] > '3')
                        times[i] = '1';
                    else
                        times[i] = '2';
                }
            }
        }

        return String.valueOf(times);
    }
}
