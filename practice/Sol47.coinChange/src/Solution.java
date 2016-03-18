/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.18
 Problem : https://leetcode.com/problems/coin-change/
 ==========================================================
 */
public class Solution {
	/*
	 * You are given coins of different denominations and a total amount of
	 * money amount. Write a function to compute the fewest number of coins that
	 * you need to make up that amount. If that amount of money cannot be made
	 * up by any combination of the coins, return -1.
	 * 
	 * Example 1: coins = [1, 2, 5], amount = 11 return 3 (11 = 5 + 5 + 1)
	 * Example 2: coins = [2], amount = 3 return -1.
	 * 
	 * Note: You may assume that you have an infinite number of each kind of
	 * coin.
	 */
	public static void main(String[] args) {
		int[] coins1 = {5, 1, 2};
		int[] coins2 = {2, 4};
		int[] coins3 = {1, 5, 6, 8};
		int[] coins4 = {186, 419, 83, 408};
		System.out.println("coinChange " + coinChange(coins1, 11));
		System.out.println("coinChange " + coinChange(coins1, 13));
		System.out.println("coinChange " + coinChange(coins2, 3));
		System.out.println("coinChange " + coinChange(coins3, 11));
		System.out.println("coinChange " + coinChange(coins4, 6249));
	}

	public static int coinChange(int[] coins, int amount) {
		int[][] mat = new int[coins.length][amount + 1];

		for (int i = 0; i < coins.length; i++) {
			int coin = coins[i];
			for (int j = 1; j < amount + 1; j++) {
				if (i == 0) {
					if (j % coin != 0)
						// Amount of money cannot be made up by this coin
						mat[i][j] = Integer.MAX_VALUE;
					else
						mat[i][j] = j / coin;
				} else {
					if (coin <= j) {
						int tmp = mat[i][j - coin];
						if (mat[i][j - coin] != Integer.MAX_VALUE) {
							tmp += 1;
						}

						mat[i][j] = Math.min(mat[i - 1][j], tmp);
					} else {
						mat[i][j] = mat[i - 1][j];
					}
				}
			}
		}

		// Amount of money cannot be made up by any combination
		if (mat[coins.length - 1][amount] == Integer.MAX_VALUE)
			return -1;

		return mat[coins.length - 1][amount];
	}

	public static void printMatrix(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}
}
