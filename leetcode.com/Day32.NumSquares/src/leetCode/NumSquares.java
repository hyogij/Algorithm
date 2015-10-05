package leetCode;


/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.10.05
 Question Number : 131
 Link : https://leetcode.com/problems/perfect-squares/
 ==========================================================
 */
public class NumSquares {
	/*
	 * Given a positive integer n, find the least number of perfect square
	 * numbers (for example, 1, 4, 9, 16, ...) which sum to n.
	 * 
	 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13,
	 * return 2 because 13 = 4 + 9.
	 */
	public static void main(String[] args) {
		int n = 13;
		System.out.println("numSquares " + numSquares(n));
	}

	// http://buttercola.blogspot.kr/2015/09/leetcode-perfect-squares.html
	public static int numSquares(int n) {
		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			dp[i] = Integer.MAX_VALUE;
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
			}
		}
		return dp[n];
	}
}
