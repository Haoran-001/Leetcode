package top.zhouhaoran.leetcode;

import java.util.*;

public class FindLadders {
    public static void main(String[] args) {
        FindLadders findLadders = new FindLadders();
//        String beginWord = "qa";
//        String endWord = "sq";
//        String[] words = {"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"};
        String beginWord = "hot";
        String endWord = "dog";
        String[] words = {"hot", "dot", "dog"};
        List<String> wordList = new ArrayList<>();
        for (String word : words) {
            wordList.add(word);
        }
        List<String> ans = findLadders.findLadders(beginWord, endWord, wordList);
        System.out.println(ans);
    }

    private boolean[] visited;
    private Set<String> history2 = new HashSet<>();
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        visited = new boolean[n];
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        if (dfs(beginWord, endWord, wordList, path) == true) {
            return path;
        }

        return new ArrayList<String>();
    }

    private boolean dfs(String curWord, String endWord, List<String> wordList, List<String> path) {
        if (curWord.equals(endWord)) {
            return true;
        }

        if (!wordList.contains(endWord)) {
            return false;
        }


        int n = wordList.size();
        for (int i = 0; i < n; i++) {
            if (visited[i] == true || canTranslateOtherWord(curWord, wordList.get(i)) == false) {
                continue;
            }
            visited[i] = true;
            path.add(wordList.get(i));
            if (dfs(wordList.get(i), endWord, wordList, path) == true) {
                return true;
            }
            path.remove(path.size() - 1);
        }

        return false;
    }

    private boolean canTranslateOtherWord(String curWord, String nextWord) {
        if (curWord.length() != nextWord.length()) {
            return false;
        }

        int n = curWord.length();
        int diffCount = 0;
        for (int i = 0; i < n; i++) {
            if (curWord.charAt(i) != nextWord.charAt(i)) {
                diffCount++;
            }
        }

        return diffCount == 1;
    }

    private List<String> path = new ArrayList<>();
    private Set<String> history = new HashSet<>();

    public List<String> findLadders2(String beginWord, String endWord, List<String> wordList) {
        if (finish(beginWord, endWord, wordList)) {
            path.add(0, beginWord);
        }

        return path;
    }

    private boolean finish(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) return true;
        if (!wordList.contains(endWord) || history.contains(beginWord)) return false;
        Iterator<String> iterator = wordList.iterator();
        int i = wordList.size() - 1;
        while (iterator.hasNext() && i >= 0) {
            String cur = wordList.get(i);
            if (near(beginWord, cur)) {
                wordList.remove(i);
                path.add(cur);
                if (finish(cur, endWord, wordList)) return true;
                history.add(cur);
                path.remove(path.size() - 1);
                wordList.add(cur);
            }
            i--;
        }
        return false;
    }

    private boolean near(String str1, String str2) {
        int diff = 0;
        for (int i = 0; i < str1.length() && diff <= 1; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                diff++;
            }
        }

        return diff == 1;
    }
}
