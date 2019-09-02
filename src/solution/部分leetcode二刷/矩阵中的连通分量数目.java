package solution.部分leetcode二刷;

public class 矩阵中的连通分量数目 {
    private int m, n;
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        m = grid.length;
        n = grid[0].length;
        int ret = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == '1') {
                    ret++;
                    dfs(grid, i, j);
                }
            }
        }

        return ret;
    }

    public void dfs(char[][] grid, int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == '0') {
            return ;
        }

        grid[r][c] = '0';
        //dfs
        for (int[] dir : direction) {
            dfs(grid, r + dir[0], c + dir[1]);
        }
    }
}
