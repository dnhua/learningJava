package solution.search;

/**
 * 在矩阵中寻找字符串
 * 79. Word Search (Medium)
 * https://leetcode.com/problems/word-search/
 * For example,
 * Given board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 */
class Solution79 {
    int[][] direction = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int m,n;

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0)
            return true;
        if (board == null || board.length == 0 || board[0].length == 0)
            return false;
        m = board.length;
        n = board[0].length;
        boolean[][] hasVisited = new boolean[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (doFind(board, hasVisited, i, j, 0, word))
                    return true;
            }
        }
        return false;
    }

    private boolean doFind (char[][] board, boolean[][] hasVisited, int i, int j, int k, final String word) {
        if (k == word.length())
            return true;
        char c = word.charAt(k);    //拿出匹配的k个字符
        if (i < 0 || i >= m || j < 0 || j >= n || hasVisited[i][j] || board[i][j] != c)
            return false;

        hasVisited[i][j] = true;
        for (int[] dir : direction) {
            if (doFind(board, hasVisited, i+dir[0], j+dir[1], k+1, word))
                return true;
        }
        hasVisited[i][j] = false;
        return false;
    }
}