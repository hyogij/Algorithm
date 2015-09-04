package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.09.04
 Question Number : 104
 Link : https://leetcode.com/problems/reverse-bits/
 ==========================================================
 */

public class reverseBits {
	/*
	 * Reverse bits of a given 32 bits unsigned integer.
	 * 
	 * For example, given input 43261596 (represented in binary as
	 * 00000010 10010100 00011110 10011100), return 964176192 (represented in
	 * binary as 
	 * 00111001 01111000 00101001 01000000).
	 * 
	 * Follow up: If this function is called many times, how would you optimize
	 * it?
	 */
	public static void main(String[] args) {
		System.out.println("reverseBits " + reverseBits(43261596));
	}

	// you need treat n as an unsigned value
	public static int reverseBits(int n) {
		int value = 0;
		int bit = 1;
		for (int i = 0; i < 32; i++) {
			if ((n & bit) == bit) {
				value |= (1 << (31 - i));
			}
			bit <<= 1;
		}

		return value;
	}
}
