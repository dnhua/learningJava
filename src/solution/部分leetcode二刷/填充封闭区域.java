package solution.部分leetcode二刷;

public class 填充封闭区域 {
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int m, n;
    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;
        m = board.length;
        n = board[0].length;
        //上下两行
        for (int i=0; i<n; i++) {
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }
        //左右两列
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

    public void dfs(char[][] board, int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] != 'O') {
            return ;
        }

        board[r][c] = 'T';
        //dfs
        for (int[] dir : direction) {
            dfs(board, r + dir[0], c + dir[1]);
        }
    }
}
