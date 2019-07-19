package solution.dp.背包问题;

/**
 * 完全背包问题
 */
public class Solution3 {
    public int solution(int Weight, int[] weights, int[] values) {
        if (Weight <= 0)
            return 0;
        int m = weights.length, n = Weight;
        int[] dp = new int[n+1];
        for (int i=1; i<=m; i++) {
            int w = weights[i-1];
//            for (int j=1; j<=n; j++) {
//                if (j < w) {
//                    dp[j] = dp[j];
//                } else {
//                    dp[j] = Math.max(dp[j], dp[j-w] + values[i-1]);
//                }
//            }
            for (int j=w; j<=n; j++) {
                dp[j] = Math.max(dp[j], dp[j-w] + values[i-1]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int Weight = 1000;
        int[] weights = new int[]{200, 600, 100, 180, 300, 450};
        int[] value = new int[]{6, 10, 3, 4, 5, 8};
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.solution(Weight, weights, value));
    }
}
