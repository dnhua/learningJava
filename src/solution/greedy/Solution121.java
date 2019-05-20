package solution.greedy;

/**
 * 121. Best Time to Buy and Sell Stock (Easy)
 *
 * 题目描述：一次股票交易包含买入和卖出，只进行一次交易，求最大收益。
 *
 * 只要记录前面的最小价格，将这个最小价格作为买入价格，然后将当前的价格作为售出价格，查看当前收益是不是最大收益。
 */
public class Solution121 {
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}
