package solution.top100;

/**
 * 72. Edit Distance
 * https://leetcode.com/problems/edit-distance/
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 * You have the following 3 operations permitted on a word:
 *
 *     Insert a character
 *     Delete a character
 *     Replace a character
 * Example 1:
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 */
public class Solution72 {
    public int minDistance(String word1, String word2) {
        //思路：可以说是非常经典的一道题目了dp来做还是不难的
        int n1 = word1.length(), n2 = word2.length();
        int[][] dp = new int[n1+1][n2+1];
        //初始化
        for (int i=0; i<n1+1; i++) dp[i][0] = i;  //word2为空串
        for (int j=0; j<n2+1; j++) dp[0][j] = j;  //word1为空串
        char c1,c2;
        for (int i=1; i<n1+1; i++) {
            for (int j=1; j<n2+1; j++) {
                c1 = word1.charAt(i-1);
                c2 = word2.charAt(j-1);
                dp[i][j] = c1 == c2 ? dp[i-1][j-1] : Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
            }
        }
        return dp[n1][n2];
    }
}
