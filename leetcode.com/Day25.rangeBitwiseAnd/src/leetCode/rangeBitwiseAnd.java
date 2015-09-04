package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.09.04
 Question Number : 103
 Link : https://leetcode.com/problems/bitwise-and-of-numbers-range/
 ==========================================================
 */

public class rangeBitwiseAnd {
	/*
	 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise
	 * AND of all numbers in this range, inclusive.
	 * 
	 * For example, given the range [5, 7], you should return 4.
	 */
	public static void main(String[] args) {
		System.out.println("rangeBitwiseAnd " + rangeBitwiseAnd(5, 7));
	}

	public static int rangeBitwiseAnd(int m, int n) {
		int and = m;
		for (int i = m + 1; i <= n; i++) {
			and &= i;
		}
		return and;
	}
}
