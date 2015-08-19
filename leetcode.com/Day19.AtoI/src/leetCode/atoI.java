package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.08.19
 Question Number : 78
 Link : https://leetcode.com/problems/string-to-integer-atoi/
 ==========================================================
 */

public class atoI {
	/*
	 * Implement atoi to convert a string to an integer.
	 * 
	 * Hint: Carefully consider all possible input cases. If you want a
	 * challenge, please do not see below and ask yourself what are the possible
	 * input cases.
	 * 
	 * Notes: It is intended for this problem to be specified vaguely (ie, no
	 * given input specs). You are responsible to gather all the input
	 * requirements up front.
	 * 
	 * Update (2015-02-10): The signature of the C++ function had been updated.
	 * If you still see your function signature accepts a const char * argument,
	 * please click the reload button to reset your code definition.
	 * 
	 * spoilers alert... click to show requirements for atoi.
	 * 
	 * Requirements for atoi: The function first discards as many whitespace
	 * characters as necessary until the first non-whitespace character is
	 * found. Then, starting from this character, takes an optional initial plus
	 * or minus sign followed by as many numerical digits as possible, and
	 * interprets them as a numerical value.
	 * 
	 * The string can contain additional characters after those that form the
	 * integral number, which are ignored and have no effect on the behavior of
	 * this function.
	 * 
	 * If the first sequence of non-whitespace characters in str is not a valid
	 * integral number, or if no such sequence exists because either str is
	 * empty or it contains only whitespace characters, no conversion is
	 * performed.
	 * 
	 * If no valid conversion could be performed, a zero value is returned. If
	 * the correct value is out of the range of representable values, INT_MAX
	 * (2147483647) or INT_MIN (-2147483648) is returned.
	 */
	public static void main(String[] args) {
		System.out.println("myAtoi " + myAtoi("-12"));
		System.out.println("myAtoi " + myAtoi("+1"));
		System.out.println("myAtoi " + myAtoi("1002"));
		System.out.println("myAtoi " + myAtoi("1231232"));
		System.out.println("myAtoi " + myAtoi("02"));
		System.out.println("myAtoi " + myAtoi("        02"));
		System.out.println("myAtoi " + myAtoi("  -0012a42"));
		System.out.println("myAtoi " + myAtoi("2147483648"));
		System.out.println("myAtoi " + myAtoi("1191973035"));
		System.out.println("myAtoi " + myAtoi("-2147483647"));
		System.out.println("myAtoi " + myAtoi("-2147483648"));
		System.out.println("myAtoi " + myAtoi("-11919730356x"));
	}

	public static int myAtoi(String str) {
		boolean isNegative = false;
		int index = 0, digit = 0;
		double number = 0;

		if (str == null || str.length() <= 0) {
			return (int) number;
		}

		// Discard the whitespace characters in str
		while (str.charAt(index) == ' ') {
			index++;
		}

		char sign = str.charAt(index);
		if (sign == '-') {
			isNegative = true;
			index++;
		} else if (sign == '+') {
			index++;
		}

		for (int i = index; i < str.length(); i++) {
			digit = str.charAt(i) - '0';
			// Return 0 value if digit number is not valid
			if (digit < 0 || digit > 9) {
				break;
			}

			number *= 10;
			number += digit;
		}

		if (isNegative == true) {
			number *= (-1);
		}

		if (number > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		} else if (number < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}

		return (int) number;
	}
}