package top.zhouhaoran.leetcode;

public class MaxRepeating {
    public static void main(String[] args) {
        MaxRepeating maxRepeating = new MaxRepeating();
        String sequence = "ababc", word = "ab";
        System.out.println(sequence.indexOf(word));
        System.out.println(maxRepeating.maxRepeating(sequence, word));
    }

    public int maxRepeating(String sequence, String word) {
        int k = 0;
        StringBuilder sb = new StringBuilder(word);
        while (sequence.contains(sb)) {
            k++;
            sb.append(word);
        }
        return k;
    }
}
