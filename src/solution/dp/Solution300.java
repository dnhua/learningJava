package solution.dp;

/**
 * 最长递增子序列
 * 300. Longest Increasing Subsequence (Medium)
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int res = 0;
        for (int i=0; i<nums.length; i++) {
            int max = 1;
            for (int j=0; j<i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            res = max > res ? max : res;
        }

        return res;
    }
}
