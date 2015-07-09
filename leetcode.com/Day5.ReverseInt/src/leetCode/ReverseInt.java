package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.09
 Question Number : 21
 Link : https://leetcode.com/problems/reverse-integer/solution/
 ==========================================================
 */
public class ReverseInt {
	/*
	 * Reverse digits of an integer.
	 * 
	 * Example1: x = 123, return 321 Example2: x = -123, return -321
	 */
	public static void main(String[] args) {

		System.out.println("reverse " + reverse(-10));
	}

	// I use long type variable to avoid overflow or underflow. But we can solve
	// this case using another apporach.
	public static int reverse(int x) {
		long result = 0;
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

			result *= 10;
		}

		if (isNegative == true) {
			result *= -1;
		}

		// If given value is overflow or underflow, then returns 0
		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
			return 0;
		} else {
			return (int) result;
		}
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
