package solution.部分leetcode二刷;

public class 最长递增子序列 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int max = 0;
        for (int i=0; i<nums.length; i++) {
            dp[i] = 1;  //这里一定不要漏了
            for (int j=0; j<i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
