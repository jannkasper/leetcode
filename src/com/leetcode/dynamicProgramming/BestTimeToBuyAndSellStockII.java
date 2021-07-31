package com.leetcode.dynamicProgramming;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int idx = 1; idx < prices.length; idx++) {
            if (prices[idx-1] < prices[idx]) result += prices[idx] - prices[idx-1];
        }
        return result;
    }
}
