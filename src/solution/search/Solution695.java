package solution.search;

/**
 * 1. 查找最大的连通面积
 *
 * 695. Max Area of Island (Medium)
 *
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 */
public class Solution695 {
    private int m,n;
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        m = grid.length;
        n = grid[0].length;
        int res = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                res = Math.max(res, dfs(grid, i, j));
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0)
            return 0;
        grid[r][c] = 0; //已经访问过就置零
        int area = 1;   //初始化area为1
        for (int d[] : direction) {
            area += dfs(grid, r + d[0], c + d[1]);
        }
        return area;
    }
}
