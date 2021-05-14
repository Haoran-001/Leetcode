package top.zhouhaoran.leetcode;

import java.util.*;

public class GetValidT9Words {
    public static void main(String[] args) {
        GetValidT9Words getValidT9Words = new GetValidT9Words();
        System.out.println(getValidT9Words.getValidT9Words("9675973753", new String[]{"ymrkxqdrlf","zopjysdqke"}));
    }

    // "9675973753"
    //["alasvnpzur", "znwdgoiwso", "wduzrpnqrv", "ymrkxqdrlf", "epsqjclyqe", "zopjysdqke", "zhfxsdeimz", "eitgrsdnvt"]
    public List<String> getValidT9Words(String num, String[] words) {
        Map<Character, Character> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        boolean ifAdd = true;

        map.put('a', '2'); map.put('b', '2'); map.put('c', '2');
        map.put('d', '3'); map.put('e', '3'); map.put('f', '3');
        map.put('g', '4'); map.put('h', '4'); map.put('i', '4');
        map.put('j', '5'); map.put('k', '5'); map.put('l', '5');
        map.put('m', '6'); map.put('n', '6'); map.put('o', '6');
        map.put('p', '7'); map.put('q', '7'); map.put('r', '7'); map.put('s', '7');
        map.put('t', '8'); map.put('u', '8'); map.put('v', '8');
        map.put('w', '9'); map.put('x', '9'); map.put('y', '9'); map.put('z', '9');

        for (String word : words) {
            ifAdd = true;
            if (word.length() != num.length()) {
                continue;
            }

            for (int i = 0; i < word.length(); i++) {
                if (map.get(word.charAt(i)) != num.charAt(i)) {
                    ifAdd = false;
                    break;
                }
            }

            if (ifAdd) {
                ans.add(word);
            }
        }

        return ans;
    }

    public List<String> getValidT9Words2(String num, String[] words) {
        char[] arr = "22233344455566677778889999".toCharArray();
        List<String> ans = new ArrayList<>();

        for (String word : words) {
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                if (arr[word.charAt(i) - 'a'] != num.charAt(i)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                ans.add(word);
            }
        }

        return ans;
    }
}