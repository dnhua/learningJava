package solution.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 最短单词路径
 * 127. Word Ladder (Medium)
 * https://leetcode.com/problems/word-ladder/solution/
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 *
 * 题目描述：找出一条从 beginWord 到 endWord 的最短路径，每次移动规定为改变一个字符，并且改变之后的
 * 字符串必须在 wordList 中。
 */
public class Solution127todo {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        int N = wordList.size();
        int start = N - 1;
        int end = 0;
        while (end < N && !wordList.get(end).equals(endWord)) {
            end++;
        }
        if (end == N) {
            return 0;
        }
        List<Integer>[] graphic = buildGraphic(wordList);
        return getShortestPath(graphic, start, end);
    }

    private List<Integer>[] buildGraphic(List<String> wordList) {
        int N = wordList.size();
        List<Integer>[] graphic = new List[N];
        for (int i = 0; i < N; i++) {
            graphic[i] = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                if (isConnect(wordList.get(i), wordList.get(j))) {
                    graphic[i].add(j);
                }
            }
        }
        return graphic;
    }

    private boolean isConnect(String s1, String s2) {
        int diffCnt = 0;
        for (int i = 0; i < s1.length() && diffCnt <= 1; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCnt++;
            }
        }
        return diffCnt == 1;
    }

    private int getShortestPath(List<Integer>[] graphic, int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[graphic.length];
        queue.add(start);
        marked[start] = true;
        int path = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            path++;
            while (size-- > 0) {
                int cur = queue.poll();
                for (int next : graphic[cur]) {
                    if (next == end) {
                        return path;
                    }
                    if (marked[next]) {
                        continue;
                    }
                    marked[next] = true;
                    queue.add(next);
                }
            }
        }
        return 0;
    }
}
