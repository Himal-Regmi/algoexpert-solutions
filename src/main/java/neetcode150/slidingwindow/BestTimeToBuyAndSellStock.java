package neetcode150.slidingwindow;

public class BestTimeToBuyAndSellStock {
  class Solution {
    public int maxProfit(int[] prices) {
      int buyIdx = 0;
      int sellIdx = 1;

      int maxProfit = 0;

      while (sellIdx < prices.length) {
        maxProfit = Math.max(prices[sellIdx] - prices[buyIdx], maxProfit);
        if (prices[sellIdx] < prices[buyIdx]) {
          buyIdx = sellIdx;
          sellIdx = buyIdx + 1;
        } else {
          sellIdx++;
        }
      }

      return maxProfit;
    }
  }
}
