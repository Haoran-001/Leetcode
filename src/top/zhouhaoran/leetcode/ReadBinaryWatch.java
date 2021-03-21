package top.zhouhaoran.leetcode;

import java.util.*;

public class ReadBinaryWatch {
    public static void main(String[] args) {
        ReadBinaryWatch readBinaryWatch = new ReadBinaryWatch();
        System.out.println(readBinaryWatch.readBinaryWatch(1));
    }

    private int[] hours = new int[]{1, 2, 4, 8, 0, 0, 0, 0, 0, 0};
    private int[] minutes = new int[]{0, 0, 0, 0, 1, 2, 4, 8, 16, 32};
    List<String> res = new ArrayList<>();

    public List<String> readBinaryWatch(int num) {
        backtrack(num, 0, 0, 0);
        return res;
    }

    private void backtrack(int num, int index, int hour, int minute) {
        if (hour > 11 || minute > 59) {
            return;
        }

        if (num == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(hour).append(':');
            if (minute < 10) {
                sb.append('0');
            }
            sb.append(minute);
            res.add(sb.toString());

            return;
        }

        for (int i = index; i < 10; i++) {
            backtrack(num - 1, i + 1, hour + hours[i], minute + minutes[i]);
        }
    }
}
