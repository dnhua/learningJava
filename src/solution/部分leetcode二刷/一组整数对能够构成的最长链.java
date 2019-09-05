package solution.部分leetcode二刷;

import java.util.Arrays;

public class 一组整数对能够构成的最长链 {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0)
            return 0;
        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.sort(pairs, (pair1, pair2)->(pair2[0] - pair1[0]));  //排序
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i=1; i<n; i++) {
            for (int j=0; j<i; j++) {
                if (pairs[j][0] > pairs[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
