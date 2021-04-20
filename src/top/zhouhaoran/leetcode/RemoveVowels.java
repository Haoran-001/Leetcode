package top.zhouhaoran.leetcode;

public class RemoveVowels {
    public static void main(String[] args) {
        RemoveVowels remvoeVowels = new RemoveVowels();
        String s = "leetcodeisacommunityforcoders";
        System.out.println(remvoeVowels.removeVowels(s));
    }

    public String removeVowels(String s) {
        return s.replaceAll("[aeiou]", "");
    }
}
