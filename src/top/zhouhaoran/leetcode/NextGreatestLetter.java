package top.zhouhaoran.leetcode;

public class NextGreatestLetter {
    public static void main(String[] args) {
        NextGreatestLetter nextGreatestLetter = new NextGreatestLetter();
        char[] letters = {'a', 'b'};
        char target = 'z';
        char ans = nextGreatestLetter.nextGreatestLetter3(letters, target);
        System.out.println(ans);
    }

    public char nextGreatestLetter(char[] letters, char target) {
        boolean[] seen = new boolean[26];

        for (char c : letters) {
            seen[c - 'a'] = true;
        }

        while (true) {
            target++;
            if (target > 'z') target = 'a';
            if (seen[target - 'a']) return target;
        }
    }

    public char nextGreatestLetter2(char[] letters, char target) {
        for (char c : letters) {
            if (c > target) return c;
        }

        return letters[0];
    }
    // z a b c
    public char nextGreatestLetter3(char[] letters, char target) {
        int left = 0, right = letters.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) left = mid + 1;
            else right = mid - 1;
        }

        return letters[left % letters.length];
    }
}
