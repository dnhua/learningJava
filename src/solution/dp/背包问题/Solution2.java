package solution.dp.背包问题;

/**
 * 简单背包问题的空间优化
 */
public class Solution2 {
    public int solution(int Weight, int[] weights, int[] values) {
        if (Weight <= 0)
            return 0;
        int m = weights.length, n = Weight;
        int[] dp = new int[n+1];
        for (int i=1; i<=m; i++) {
            int w = weights[i-1];
            for (int j=n; j>w; j--) {
                dp[j] = Math.max(dp[j-1], dp[j-w] + values[i-1]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int Weight = 1000;
        int[] weights = new int[]{200, 600, 100, 180, 300, 450};
        int[] value = new int[]{6, 10, 3, 4, 5, 8};
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.solution(Weight, weights, value));
    }
}
