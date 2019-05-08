package solution.dp;

/**
 * 强盗抢劫
 *
 * 198. House Robber (Easy)
 *
 * 题目描述：抢劫一排住户，但是不能抢邻近的住户，求最大抢劫量。
 *
 * 定义 dp 数组用来存储最大的抢劫量，其中 dp[i] 表示抢到第 i 个住户时的最大抢劫量。
 *
 * 由于不能抢劫邻近住户，如果抢劫了第 i -1 个住户，那么就不能再抢劫第 i 个住户，所以
 */
public class Solution198 {
    public int rob(int[] nums) {
        int n_1 = 0, n_2 = 0;
        for (int i=0; i<nums.length; i++) {
            int cur = Math.max(n_1, n_2+nums[i]);
            n_2 = n_1;
            n_1 = cur;
        }
        return n_1;
    }
}
