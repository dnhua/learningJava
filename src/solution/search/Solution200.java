package solution.search;

/**
 * 矩阵中的连通分量数目
 *
 * 200. Number of Islands (Medium)
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 *
 * 可以将矩阵表示看成一张有向图。
 */
public class Solution200 {
    int m,n;
    int direction[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        m = grid.length;
        n = grid[0].length;
        int res = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == '0')
            return ;
        grid[r][c] = '0';
        for (int[] dir : direction) {
            dfs(grid, r + dir[0], c + dir[1]);
        }
    }
}
