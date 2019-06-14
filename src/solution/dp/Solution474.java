package solution.dp;

/**
 * 字符构成最多的字符串
 * Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 * Output: 4
 * Explanation: There are totally 4 strings can be formed by the
 * using of 5 0s and 3 1s, which are "10","0001","1","0"
 */
public class Solution474 {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0)
            return 0;
        int[][] dp = new int[m+1][n+1]; //m是0的个数, n是1的个数

        for (String s : strs) {
            int zeros = 0, ones = 0;
            //统计0和1的cnt数
            for (char c : s.toCharArray()) {
                if (c == '0')
                    zeros++;
                if (c == '1')
                    ones++;
            }

            //规划
            for (int i=m; i>=zeros; i--) {
                for (int j=n; j>=ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-zeros][j-ones]+1);
                }
            }
        }
        return dp[m][n];
    }
}
