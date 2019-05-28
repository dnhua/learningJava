package solution.search;

/**
 * 填充封闭区域
 * 130. Surrounded Regions (Medium)
 * https://leetcode.com/problems/surrounded-regions/
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 *
 * After running your function, the board should be:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 *
 * 题目描述：使被 'X' 包围的 'O' 转换为 'X'。
 *
 * 先填充最外侧，剩下的就是里侧了。
 */
public class Solution130 {
    int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int m;
    int n;

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;
        m = board.length;
        n = board[0].length;

        //最外层往内进行扫描
        //扫描上下两层
        for (int j=0; j<n; j++) {
            dfs(board, 0, j);
            dfs(board, m-1, j);
        }
        //扫描左右两层
        for (int i=0; i<m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n-1);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j>= n || board[i][j] != 'O')
            return ;
        board[i][j] = 'T';
        for (int[] dir : direction) {
            dfs(board, i+dir[0], j+dir[1]);
        }
    }
}
