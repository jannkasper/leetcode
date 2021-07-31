package com.leetcode.dynamicProgramming;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        int result = 0;
        for (int price : prices) {
            if (price < min) {
                min = price;
                max = 0;
            } else if (price > max) {
                max = price;
                result = Math.max(result, max-min);
            }
        }

        return result;
    }
}
