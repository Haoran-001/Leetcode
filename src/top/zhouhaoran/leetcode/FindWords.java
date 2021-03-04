package top.zhouhaoran.leetcode;

import java.util.*;

public class FindWords {
    public static void main(String[] args) {
        FindWords findWords = new FindWords();
        String[] words = {"Hello","Alaska","Dad","Peace"};
        System.out.println(Arrays.toString(findWords.findWords2(words)));
    }

    public String[] findWords(String[] words) {
        // qwertyuiop
        Set<Character> set1 = new HashSet<>(){{
            add('q'); add('w'); add('e'); add('r'); add('t'); add('y'); add('u'); add('i'); add('o'); add('p');
        }};
        // asdfghjkl
        Set<Character> set2 = new HashSet<>(){{
            add('a'); add('s'); add('d'); add('f'); add('g'); add('h'); add('j'); add('k'); add('l');
        }};
        // zxcvbnm
        Set<Character> set3 = new HashSet<>(){{
            add('z'); add('x'); add('c'); add('v'); add('b'); add('n'); add('m');
        }};

        List<String> list = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (canFindOneWord(words[i], set1)) {
                list.add(words[i]);
            } else if (canFindOneWord(words[i], set2)) {
                list.add(words[i]);
            } else if (canFindOneWord(words[i], set3)) {
                list.add(words[i]);
            }
        }

        return list.toArray(new String[list.size()]);
    }

    public boolean canFindOneWord(String s, Set<Character> set) {
        for (char c : s.toLowerCase().toCharArray()) {
            if (!set.contains(c)) {
                return false;
            }
        }

        return true;
    }


    public String[] findWords2(String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        String[] lines = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        List<String> list = new ArrayList<>();

        for (int i = 0; i < lines.length; i++) {
            writeMap(lines[i], i + 1, map);
        }

        for (String word : words) {
            if (canfindOneWord2(word.toLowerCase(), map)) {
                list.add(word);
            }
        }

        return list.toArray(new String[list.size()]);
    }

    private void writeMap(String line, int i, Map<Character, Integer> map) {
        for (char c : line.toCharArray()) {
            map.put(c, i);
        }
    }

    private boolean canfindOneWord2(String s,  Map<Character, Integer> map) {
        char firstChar = s.charAt(0);
        int firstCharLine = map.get(firstChar);

        for (char c : s.toCharArray()) {
            if (map.get(c) != firstCharLine) {
                return false;
            }
        }

        return true;
    }
}
