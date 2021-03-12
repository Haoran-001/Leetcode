package top.zhouhaoran.leetcode;

public class FindString {
    public static void main(String[] args) {
        FindString findString = new FindString();
        String[] words = {"at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""};
        String s = "ta";
        System.out.println(findString.findString(words, s));
    }

    public int findString(String[] words, String s) {
        int left = 0, right = words.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (words[mid].equals("") && !words[left].equals(s)) {
                left++;
            } else if (words[left].equals(s)) {
                return left;
            } else if (words[mid].equals(s)) {
                return mid;
            } else if (words[mid].compareTo(s) < 0) {
                left = mid + 1;
            } else if (words[mid].compareTo(s) > 0) {
                right = mid - 1;
            }
        }

        return -1;
    }
}
