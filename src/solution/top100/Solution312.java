package solution.top100;

/**
 * 312. Burst Balloons
 * https://leetcode.com/problems/burst-balloons/
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 *
 * Find the maximum coins you can collect by bursting the balloons wisely.
 *
 * Note:
 *
 *     You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 *     0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 *
 * Example:
 *
 * Input: [3,1,5,8]
 * Output: 167
 * Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *              coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */
public class Solution312 {
    public int maxCoins(int[] nums) {
        //思路：惭愧，又是不会写，网上看来的思路。解法：动态规划DP，
        //State: dp[i][j]，表示打爆区间[i,j]中的所有气球能得到的最多金币。题目中说明了边界情况，
        // 当气球周围没有气球的时候，旁边的数字按1算，这样我们可以在原数组两边各填充一个1，这样
        // 方便于计算。
        //Function: dp[left][right] = Math.max(dp[left][right], nums[left] * nums[i] * nums[right]
        //                              + dp[left][i] + dp[i][right]); (left < i < right)
        //1.扩充数组
        int n = nums.length;
        int[] inums = new int[n+2];
        for (int i=0; i<n; i++)
            inums[i+1] = nums[i];
        inums[0] = 1;
        inums[n+1] = 1;

        int[][] dp = new int[n+2][n+2];
        for (int k=2; k<n+2; k++) {   //k为数组间隔
            for (int left=0; left<n+2-k; left++) {
                int right = left + k;   //确定了左边界之后，右边界为left+间隔k
                for (int i=left+1; i<right; i++) {
                    dp[left][right] = Math.max(dp[left][right], inums[left] * inums[i] * inums[right]
                                        + dp[left][i] + dp[i][right]);
                }
            }
        }

        return dp[0][n+1];
    }

    public static void main(String[] args) {
        Solution312 solution312 = new Solution312();
        int[] nums = new int[]{3,1,5,8};
        int i = solution312.maxCoins(nums);
        System.out.println(i);
    }
}
