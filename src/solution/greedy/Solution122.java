package solution.greedy;

/**
 * 122. Best Time to Buy and Sell Stock II (Easy)
 *
 * 题目描述：可以进行多次交易，多次交易之间不能交叉进行，可以进行多次交易。
 *
 * 对于 [a, b, c, d]，如果有 a <= b <= c <= d ，那么最大收益为 d - a。而
 * d - a = (d - c) + (c - b) + (b - a) ，因此当访问到一个 prices[i] 且 prices[i] - prices[i-1] > 0，
 * 那么就把 prices[i] - prices[i-1] 添加到收益中。
 */
public class Solution122 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += (prices[i] - prices[i - 1]);
            }
        }
        return profit;
    }
}
