package top.zhouhaoran.leetcode;

import java.util.*;

public class FindOcurrences {
    public static void main(String[] args) {
        FindOcurrences findOcurrences = new FindOcurrences();
        String text = "we will we will rock you", first = "we", second = "will";
        String[] ans = findOcurrences.findOcurrences(text, first, second);
        System.out.println(Arrays.toString(ans));
    }

    public String[] findOcurrences(String text, String first, String second) {
        String[] textArray = text.split(" ");
        List<String> list = new ArrayList<>();

        for (int i = 0; i < textArray.length - 2;) {
            if (textArray[i].equals(first) && textArray[i + 1].equals(second)) {
                list.add(textArray[i + 2]);
                i = i + 2;
            } else {
                i++;
            }
        }

        return list.toArray(new String[list.size()]);
    }
}
