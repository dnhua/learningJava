package solution.部分leetcode二刷;

public class 查找最大的连通面积 {
    private int m, n;
    private int[][] direction = {{0, 1},{0, -1},{1, 0},{-1, 0}};
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int maxArea = 0;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0) {
            return 0;
        }

        int area = 1;
        grid[r][c] = 0;
        //dfs搜索
        for (int[] dir : direction) {
            area += dfs(grid, r+dir[0], c+dir[1]);
        }

        return area;
    }
}
