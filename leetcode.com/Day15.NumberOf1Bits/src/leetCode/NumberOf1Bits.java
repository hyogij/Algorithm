package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.08.07
 Question Number : 65
 Link : https://leetcode.com/problems/number-of-1-bits/
 ==========================================================
 */

public class NumberOf1Bits {
	/*
	 * Write a function that takes an unsigned integer and returns the number of
	 * ¡¯1' bits it has (also known as the Hamming weight).
	 * 
	 * For example, the 32-bit integer ¡¯11' has binary representation
	 * 00000000000000000000000000001011, so the function should return 3.
	 */
	public static void main(String[] args) {
		System.out.println("hammingWeight " + hammingWeight(11));
	}

	// you need to treat n as an unsigned value
	public static int hammingWeight(int n) {
		int number = 0;
		int bit = 1;
		for (int i = 0; i < 32; i++) {
			if ((n & bit) != 0) {
				number++;
			}
			bit = bit << 1;
		}
		return number;
	}
}
