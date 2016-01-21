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

		System.out.println("isPalindrome " + isPalindromePractice(2147447412));
		System.out.println("isPalindrome " + isPalindromePractice(12344321));
		System.out.println("isPalindrome " + isPalindromePractice(123454321));
		System.out.println("isPalindrome " + isPalindromePractice(123457321));
		System.out.println("reverseInt " + reverseIntPractice(2147447412));
	}

	public static boolean isPalindromePractice(int x) {
		// Questions. If the number is negative value, then return false? Am I
		// right?
		if (x < 0) {
			return false;
		}

		return x == reverseIntPractice(x);
	}

	public static int reverseIntPractice(int x) {
		int number = 0;
		while (x != 0) {
			number *= 10;
			number += (x % 10);
			x /= 10;
		}
		return number;
	}

	// Reverse integer and compare two values
	public static boolean isPalindrome(int x) {
		if (x < 0) {
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
