package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.10.21
 Question Number : 151
 Link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 		  https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 ==========================================================
 */

public class MaxProfit {
	/*
	 * i)Say you have an array for which the ith element is the price of a given
	 * stock on day i.
	 * 
	 * If you were only permitted to complete at most one transaction (ie, buy
	 * one and sell one share of the stock), design an algorithm to find the
	 * maximum profit.
	 * 
	 * For example, if the given array is {100, 180, 260, 310, 40, 535, 695},
	 * the maximum profit can earned by buying on day 0, selling on day 3. Again
	 * buy on day 4 and sell on day 6. If the given array of prices is sorted in
	 * decreasing order, then profit cannot be earned at all.
	 * 
	 * ii) Say you have an array for which the ith element is the price of a
	 * given stock on day i.
	 * 
	 * Design an algorithm to find the maximum profit. You may complete as many
	 * transactions as you like (ie, buy one and sell one share of the stock
	 * multiple times). However, you may not engage in multiple transactions at
	 * the same time (ie, you must sell the stock before you buy again).
	 * 
	 * iii) Say you have an array for which the ith element is the price of a
	 * given stock on day i.
	 * 
	 * Design an algorithm to find the maximum profit. You may complete at most
	 * two transactions.
	 * 
	 * Note: You may not engage in multiple transactions at the same time (ie,
	 * you must sell the stock before you buy again).
	 * 
	 * iv) Say you have an array for which the ith element is the price of a
	 * given stock on day i.
	 * 
	 * Design an algorithm to find the maximum profit. You may complete at most
	 * k transactions.
	 * 
	 * Note: You may not engage in multiple transactions at the same time (ie,
	 * you must sell the stock before you buy again).
	 */
	public static void main(String[] args) {
		int[] prices1 = {2, 1, 4};
		System.out.println(" " + maxProfit1(prices1));
		int[] prices2 = {2, 1, 8, 2, 7, 5, 17, 12}; // 2
		System.out.println("maxProfit2 " + maxProfit2(prices2));
		System.out.println("maxProfit3 " + maxProfit2Solution(prices2));
		int[] prices3 = {1, 6, 5}; // 2
		System.out.println("maxProfit2 " + maxProfit2(prices3));
		System.out.println("maxProfit3 " + maxProfit2Solution(prices3));
	}

	// 1) At most one transaction (ie, buy one and sell one share of the stock).
	// Find the minimum price in array
	public static int maxProfit1(int[] prices) {
		if (prices.length < 2) {
			return 0;
		}

		int max = prices[1] - prices[0];
		if (max < 0) {
			max = 0;
		}
		int minPrice = prices[0];
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] - minPrice > max) {
				max = prices[i] - minPrice;
			}
			if (prices[i] < minPrice) {
				minPrice = prices[i];
			}
		}

		return max;
	}

	// 2) As many transactions as you like (ie, buy one and sell one share of
	// the stock multiple times)
	// int[] prices2 = {2, 1, 2, 0, 1}; // 2
	public static int maxProfit2(int[] prices) {
		if (prices.length < 2) {
			return 0;
		}

		int subMin = Integer.MAX_VALUE, subMax = Integer.MIN_VALUE;
		int max = 0;
		int prev = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prev > prices[i]) {
				max += (subMax - subMin);
				subMin = Integer.MAX_VALUE;
				subMax = Integer.MIN_VALUE;
			}
			if (subMin > prices[i]) {
				subMin = prices[i];
			}
			if (subMax < prices[i]) {
				subMax = prices[i];
			}

			prev = prices[i];
		}

		if (subMin != Integer.MAX_VALUE && subMax != Integer.MIN_VALUE) {
			max += (subMax - subMin);
		}

		return max;
	}

	public static int maxProfit2Solution(int[] prices) {
		int profit = 0;
		for (int i = 1; i < prices.length; i++) {
			int diff = prices[i] - prices[i - 1];
			if (diff > 0) {
				profit += diff;
			}
		}
		return profit;
	}
}
