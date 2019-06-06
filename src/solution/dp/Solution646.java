package solution.dp;

import java.util.Arrays;

/**
 * 一组整数对能够构成的最长链
 * 646. Maximum Length of Pair Chain (Medium)
 * https://leetcode.com/problems/maximum-length-of-pair-chain/
 * Input: [[1,2], [2,3], [3,4]]
 * Output: 2
 * Explanation: The longest chain is [1,2] -> [3,4]
 *
 * 题目描述：对于 (a, b) 和 (c, d) ，如果 b < c，则它们可以构成一条链。
 */
public class Solution646 {
    //dp
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0)
            return 0;
        int n = pairs.length;
        int res = 0;
        int[] dp = new int[n];

        Arrays.sort(pairs, (o1, o2)->(o1[0]-o2[0]));
        for (int i=0; i<n; i++) {
            int max = 1;
            for (int j=0; j<i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            res = Math.max(max, res);
        }

        return res;
    }

    //greedy
    public int findLongestChain2(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int cur = Integer.MIN_VALUE, ans = 0;
        for (int[] pair: pairs) if (cur < pair[0]) {
            cur = pair[1];
            ans++;
        }
        return ans;
    }
}
