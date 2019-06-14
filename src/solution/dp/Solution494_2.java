package solution.dp;

public class Solution494_2 {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = computeArraySum(nums);

        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }

        int W = (S + sum) / 2;
        int[] dp = new int[W+1];
        dp[0] = 1;

        for (int num : nums) {
            for (int i=W; i>=num; i--) {
                dp[i] = dp[i]+dp[i-num];
            }
        }

        return dp[W];
    }

    private int computeArraySum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
