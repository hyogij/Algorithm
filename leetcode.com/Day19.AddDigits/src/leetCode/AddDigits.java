package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.08.19
 Question Number : 74
 Link : https://leetcode.com/problems/add-digits/
 ==========================================================
 */

public class AddDigits {
	/*
	 * Given a non-negative integer num, repeatedly add all its digits until the
	 * result has only one digit.
	 * 
	 * For example: Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2.
	 * Since 2 has only one digit, return it.
	 * 
	 * Follow up: Could you do it without any loop/recursion in O(1) runtime? A
	 * naive implementation of the above process is trivial. Could you come up
	 * with other methods? What are all the possible results? How do they occur,
	 * periodically or randomly? You may find this Wikipedia article useful.
	 */
	public static void main(String[] args) {
		System.out.println("addDigits : " + addDigits(38));
		System.out.println("addDigits : " + addDigits(175));

		System.out.println("addDigits : " + addDigitsRecursive(38));
		System.out.println("addDigits : " + addDigitsRecursive(175));
	}

	public static int addDigits(int num) {
		while (num >= 10) {
			num = addDigitsHelper(num);
		}
		return num;
	}

	public static int addDigitsHelper(int num) {
		int digit = 0;
		// Add each digits until given number is zero and return result value
		while (num > 0) {
			digit += num % 10;
			num /= 10;
		}
		return digit;
	}

	// Implement add digits method through recursive. It looks like iterative
	// method.
	public static int addDigitsRecursive(int num) {
		int digit = 0;

		// Base case
		if (num < 10) {
			return num;
		}

		// Add each digits until given number is zero and return result value
		while (num > 0) {
			digit += num % 10;
			num /= 10;
		}

		return addDigitsRecursive(digit);
	}
}
