package solution.dp;

/**
 * 分割整数的最大乘积
 *
 * 343. Integer Break (Medim)
 *
 * 题目描述：For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 */
public class Solution343 {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[2] = 1;
        for (int i=3; i<n+1; i++) {
            for (int j=2; j<i; j++) {
                dp[i] = Math.max(Math.max(dp[j]*(i-j), j*(i-j)), dp[i]);
            }
        }
        return dp[n];
    }
}
