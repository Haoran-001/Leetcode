package top.zhouhaoran.leetcode;

import java.util.*;

public class ReorderLogFiles {
    public static void main(String[] args) {
        ReorderLogFiles reorderLogFiles = new ReorderLogFiles();
        String[] logs = {"8 hyyq z p", "8 ksif m u"};
        String[] ans = reorderLogFiles.reorderLogFiles(logs);
        System.out.println(Arrays.toString(ans));
    }

    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] log1Array = log1.split(" ", 2);
            String[] log2Array = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(log1Array[1].charAt(0));
            boolean isDigit2 = Character.isDigit(log2Array[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int cmp = log1Array[1].compareTo(log2Array[1]);
                if (cmp != 0) return cmp;
                else log1Array[0].compareTo(log2Array[0]);
            }

            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });

        return logs;
    }
}
