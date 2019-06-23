package solution.top100;

/**
 * 10. Regular Expression Matching
 * https://leetcode.com/problems/regular-expression-matching/
 */
public class Solution10 {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int j=1; j<=p.length(); j++) {
            dp[0][j] = j > 1 && p.charAt(j-1) == '*' && dp[0][j-2];
        }

        for (int i=1; i<=s.length(); i++) {
            for (int j=1; j<=p.length(); j++) {
                if (p.charAt(j-1) != '*') {
                    dp[i][j] = (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.') && dp[i-1][j-1];
                } else {
                    dp[i][j] = (j>1 && dp[i][j-2]) || ((s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') && dp[i-1][j]);
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
