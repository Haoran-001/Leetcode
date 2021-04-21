package top.zhouhaoran.leetcode;

public class CheckIfPangram {
    public static void main(String[] args) {
        CheckIfPangram checkIfPangram = new CheckIfPangram();
        String sentence = "thequickbrownfoxjumpsoverthel";
        boolean ans = checkIfPangram.checkIfPangram(sentence);
        System.out.println(ans);
    }

    public boolean checkIfPangram(String sentence) {
        int[] map = new int[26];

        char[] sentenceCharArray = sentence.toCharArray();

        for (int i = 0; i < sentenceCharArray.length; i++) {
            map[sentenceCharArray[i] - 'a']++;
        }

        for (int i = 0; i < map.length; i++) {
            if (map[i] < 1) {
                return false;
            }
        }

        return true;
    }
}
