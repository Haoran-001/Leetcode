package top.zhouhaoran.leetcode;

public class TruncateSentence {
    public static void main(String[] args) {
        TruncateSentence truncateSentence = new TruncateSentence();
        String s = "Hello how are you Contestant";
        String ans = truncateSentence.truncateSentence(s, 4);
        System.out.println(ans);
    }

    public String truncateSentence(String s, int k) {
        StringBuilder ans = new StringBuilder();
        int count = 0;
        char[] charArray = s.toCharArray();

        int i;
        for (i = 0; i < charArray.length; i++) {
            if (charArray[i] == ' ') {
                count++;
            }
            ans.append(charArray[i]);
            if (count == k - 1) {
                break;
            }
        }

        i++;

        for (; i < charArray.length; i++) {
            if (charArray[i] == ' ') {
                break;
            }
            ans.append(charArray[i]);
        }

        return ans.toString();
    }
}
