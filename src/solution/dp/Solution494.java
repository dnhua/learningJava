package solution.dp;

/**
 * 改变一组数的正负号使得它们的和为一给定数
 * https://leetcode.com/problems/target-sum/
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 * Output: 5
 * Explanation:
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 */
public class Solution494 {
    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWays(nums, S, 0);
    }

    public int findTargetSumWays(int[] nums, int S, int start) {
        if(start == nums.length) {
            return S == 0 ? 1 : 0;
        }

        return findTargetSumWays(nums, S-nums[start], start+1) +
                findTargetSumWays(nums, S+nums[start], start+1);
    }
}
