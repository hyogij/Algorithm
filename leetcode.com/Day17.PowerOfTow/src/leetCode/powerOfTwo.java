package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.08.13
 Question Number : 67
 Link : https://leetcode.com/problems/power-of-two/
 ==========================================================
 */

public class powerOfTwo {
	/*
	 * Given an integer, write a function to determine if it is a power of two.
	 */
	public static void main(String[] args) {
		System.out.println("isPowerOfTwo " + isPowerOfTwo(0));
		System.out.println("isPowerOfTwo " + isPowerOfTwo(1));
		System.out.println("isPowerOfTwo " + isPowerOfTwo(16));
		System.out.println("isPowerOfTwo " + isPowerOfTwo(15));
	}

	public static boolean isPowerOfTwo(int n) {
		if (n > 0 && (n & (n - 1)) == 0) {
			return true;
		}
		return false;
	}
}
