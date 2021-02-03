package top.zhouhaoran.leetcode;

public class HalvesAreAlike {
    public static void main(String[] args) {
        HalvesAreAlike halvesAreAlike = new HalvesAreAlike();
        String s = "book";
        System.out.println(halvesAreAlike.halvesAreAlike(s));
    }

    public boolean halvesAreAlike(String s) {
        int len = s.length();
        String firstHalf = s.substring(0, len / 2);
        String secondHalf = s.substring(len / 2, len);

        return numOfVowelLetters(firstHalf) == numOfVowelLetters(secondHalf);
    }

    private int numOfVowelLetters(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'
                || c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }

        return count;
    }
}
