package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.08.24
 Question Number : 87
 Link : https://leetcode.com/problems/number-of-digit-one/
 ==========================================================
 */

public class CountDigitOne {
	/*
	 * Given an integer n, count the total number of digit 1 appearing in all
	 * non-negative integers less than or equal to n.
	 * 
	 * For example: Given n = 13, Return 6, because digit 1 occurred in the
	 * following numbers: 1, 10, 11, 12, 13.
	 */
	public static void main(String[] args) {
		System.out.println("countDigitOne " + countDigitOne(13));
		System.out.println("countDigitOne " + countDigitOne(824883294));
	}

	// TODO(hyogij): It needs more effective algorithm to count the total number
	// of digit 1
	public static int countDigitOne(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			count += countDigitOneHelper(i);
		}
		return count;
	}

	public static int countDigitOneHelper(int n) {
		int count = 0;
		while (n != 0) {
			if (n % 10 == 1) {
				count++;
			}
			n /= 10;
		}

		return count;
	}
}