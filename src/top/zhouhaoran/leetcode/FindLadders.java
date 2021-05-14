package top.zhouhaoran.leetcode;

import java.util.*;

public class FindLadders {
    public static void main(String[] args) {
        FindLadders findLadders = new FindLadders();
        String beginWord = "qa";
        String endWord = "sq";
        String[] words = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
        List<String> wordList = new ArrayList<>();
        for (String word : words) {
            wordList.add(word);
        }
        List<String> ans = findLadders.findLadders(beginWord, endWord, wordList);
        System.out.println(ans);
    }

    private boolean[] visited;
    List<String> path = new ArrayList<>();
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        visited = new boolean[n];

        path.add(beginWord);
        if (dfs(beginWord, endWord, wordList)) {
            return path;
        }

        return new ArrayList<String>();
    }

    private boolean dfs(String curWord, String endWord, List<String> wordList) {
        if (curWord.equals(endWord)) {
            return true;
        }

        if (!wordList.contains(endWord)) {
            return false;
        }

        int n = wordList.size();

        for (int i = 0; i < n; i++) {
            String nextWord = wordList.get(i);
            if (visited[i] || !canTranslateNextWord(curWord, nextWord)) {
                continue;
            }
            visited[i] = true;
            path.add(nextWord);
            if (dfs(nextWord, endWord, wordList)) {
                return true;
            }
            path.remove(path.size() - 1);
        }

        return false;
    }

    private boolean canTranslateNextWord(String curWord, String nextWord) {
        if (curWord.length() != nextWord.length()) {
            return false;
        }

        int count = 0;

        int n = curWord.length();
        for (int i = 0; i < n; i++) {
            if (curWord.charAt(i) != nextWord.charAt(i)) {
                count++;
            }
        }

        return count == 1;
    }
}
