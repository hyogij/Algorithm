package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.02.11
 Question Number : 161
 Link : https://leetcode.com/problems/power-of-three/
 ==========================================================
 */
public class Solution {
	/*
	 * Given an integer, write a function to determine if it is a power of
	 * three. Follow up: Could you do it without using any loop / recursion?
	 */
	public static void main(String[] args) {
		// System.out.println("isPowerOfTwo " + isPowerOfTwo(16));
		// System.out.println("isPowerOfTwo " + isPowerOfTwo(8));
		// System.out.println("isPowerOfTwo " + isPowerOfTwo(12));

		System.out.println("isPowerOfThree " + isPowerOfThree(45));
		System.out.println("isPowerOfThree " + isPowerOfThree(9));
		System.out.println("isPowerOfThree " + isPowerOfThree(81));
	}

	public static boolean isPowerOfThree(int n) {
		while (n >= 3 && n % 3 == 0) {
			n /= 3;
		}

		if (n == 1) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isPowerOfTwo(int n) {
		// Use bit operator such as & and shift
		int i = 2;
		while (i <= n) {
			if ((i & n) == n) {
				return true;
			}
			i <<= 1;
		}

		return false;
	}
}
