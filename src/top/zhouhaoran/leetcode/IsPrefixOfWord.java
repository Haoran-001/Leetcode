package top.zhouhaoran.leetcode;

public class IsPrefixOfWord {
    public static void main(String[] args) {
        IsPrefixOfWord isPrefixOfWord = new IsPrefixOfWord();
        String sentence = "i love eating burger", searchWord = "burg";
        int ans = isPrefixOfWord.isPrefixOfWord(sentence, searchWord);
        System.out.println(ans);
    }

    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] wordArray = sentence.split(" ");

        for (int i = 0; i < wordArray.length; i++) {
            if (wordArray[i].indexOf(searchWord) == 0) {
                return i + 1;
            }
        }

        return -1;
    }
}
