package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.09
 Question Number : 22
 Link : https://leetcode.com/problems/palindrome-number/
 ==========================================================
 */
public class Palindrome {
	/*
	 * Determine whether an integer is a palindrome. Do this without extra
	 * space.
	 */
	public static void main(String[] args) {

		System.out.println("isPalindrome " + isPalindrome(-2147447412));
		System.out.println("reverseInt " + reverseInt(-2147447412));
	}

	// Reverse integer and compare two values
	public static boolean isPalindrome(int x) {
		if(x < 0 ) {
			return false;
		}
		return x == reverseInt(x);
	}

	public static int reverseInt(int x) {
		int result = 0;
		boolean isNegative = false;

		if (x < 0) {
			isNegative = true;
			x *= -1;
		}

		int digit = 0;
		while (true) {
			digit = x % 10;
			result += digit;
			x /= 10;

			if (x == 0) {
				break;
			}

			// If given value is overflow or underflow, then returns 0
			if (result > Integer.MAX_VALUE / 10
					|| result < Integer.MIN_VALUE / 10) {
				return 0;
			}

			result *= 10;
		}

		if (isNegative == true) {
			result *= -1;
		}

		return result;
	}
}
