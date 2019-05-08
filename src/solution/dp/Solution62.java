package solution.dp;

import java.util.Arrays;

/**
 * 矩阵的总路径数
 *
 * 62. Unique Paths (Medium)
 *
 * 题目描述：统计从矩阵左上角到右下角的路径总数，每次只能向右或者向下移动。
 */
public class Solution62 {
    public int uniquePaths(int m, int n) {
        int[][] ret = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (i==0 || j == 0) {
                    ret[i][j] = 1;
                } else {
                    ret[i][j] = ret[i-1][j] + ret[i][j-1];
                }
            }
        }
        return ret[m-1][n-1];
    }

    public int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    public int uniquePaths3(int m, int n) {
        int S = m + n - 2;  // 总共的移动次数
        int D = m - 1;      // 向下的移动次数
        long ret = 1;
        for (int i = 1; i <= D; i++) {
            ret = ret * (S - D + i) / i;
        }
        return (int) ret;
    }
}
