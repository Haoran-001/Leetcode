package top.zhouhaoran.leetcode;

import java.util.Arrays;

public class ReorderSpaces {
    public static void main(String[] args) {
        ReorderSpaces reorderSpaces = new ReorderSpaces();
        String text = " world";
        String ans = reorderSpaces.reorderSpaces(text);
        System.out.println(ans);
    }

    public String reorderSpaces(String text) {
        int blankCount = 0, wordCount = 0;
        char[] charArray = text.toCharArray();

        if (charArray[0] == ' ') blankCount++;
        else if (charArray[0] != ' ') wordCount++;

        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] == ' ') {
                blankCount++;
            } else if (charArray[i] != ' ' && charArray[i - 1] == ' ') {
                wordCount++;
            }
        }

        StringBuilder ans = new StringBuilder();

        int segmentBlankCount = wordCount - 1 == 0 ? 0 : blankCount / (wordCount - 1);
        int remainderBlankCount = wordCount - 1 == 0 ? blankCount : blankCount % (wordCount - 1);

        String[] noBlankStringArray = getNoBlankStringArray(text, wordCount);

        for (int i = 0; i < noBlankStringArray.length - 1; i++) {
            ans.append(noBlankStringArray[i]);
            for (int j = 0; j < segmentBlankCount; j++) {
                ans.append(" ");
            }
        }
        ans.append(noBlankStringArray[noBlankStringArray.length - 1]);

        if (remainderBlankCount != 0) {
            for (int j = 0; j < remainderBlankCount; j++) {
                ans.append(" ");
            }
        }

        return ans.toString();

    }

    private String[] getNoBlankStringArray(String text, int wordCount) {
        String[] stringArray = text.split(" ");
        String[] noBlankStringArray = new String[wordCount];
        int i = 0;

        for (String string : stringArray) {
            if (!string.equals("")) {
                noBlankStringArray[i++] = string;
            }
        }

        return noBlankStringArray;
    }
}
