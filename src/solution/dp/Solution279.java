package solution.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 按平方数来分割整数
 * 题目描述：For example, given n = 12, return 3 because 12 = 4 + 4 + 4;
 * given n = 13, return 2 because 13 = 4 + 9.
 */
public class Solution279 {
    public int numSquares(int n) {
        List<Integer> squareList = generateSquareList(n);
        int[] dp = new int[n+1];
        for (int i=1; i<n+1; i++) {
            int min = Integer.MAX_VALUE;
            for (int square : squareList) {
                if (square>i)
                    break;
                min = Math.min(min, dp[i-square] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }

    private List<Integer> generateSquareList(int n) {
        int square = 1;
        int diff = 3;
        List<Integer> squareList = new ArrayList<>();
        while (square <= n) {
            squareList.add(square);
            square += diff;
            diff += 2;
        }
        return squareList;
    }

    public int numSquares2(int n) {
        int[] res = new int[n+1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                res[i] = Math.min(res[i], res[i - j * j] + 1);
            }
        }
        return res[n];
    }
}
