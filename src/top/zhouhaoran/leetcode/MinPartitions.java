package top.zhouhaoran.leetcode;

public class MinPartitions {
    public static void main(String[] args) {
        MinPartitions minPartitions = new MinPartitions();
        System.out.println(minPartitions.minPartitions("32"));
    }

    public int minPartitions(String n) {
        int max = 0;

        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) - '0' > max) {
                max = n.charAt(i) - '0';
            }
        }

        return max;
    }
}
