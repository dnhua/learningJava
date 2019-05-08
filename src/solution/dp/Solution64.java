package solution.dp;

/**
 * 矩阵的最小路径和
 * [[1,3,1],
 *  [1,5,1],
 *  [4,2,1]]
 * Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.
 *
 * 题目描述：求从矩阵的左上角到右下角的最小路径和，每次只能向右和向下移动。
 */
public class Solution64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] ret = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (i == 0 && j==0) {
                    ret[i][j] = grid[i][j];
                }else if (j == 0 && i!=0) {
                    ret[i][j] = grid[i][j] + ret[i-1][j];
                } else if (i == 0 && j!=0) {
                    ret[i][j] = grid[i][j] + ret[i][j-1];
                } else {
                    ret[i][j] = Math.min(ret[i-1][j], ret[i][j-1]) + grid[i][j];
                }
            }
        }
        return ret[m-1][n-1];
    }
}
