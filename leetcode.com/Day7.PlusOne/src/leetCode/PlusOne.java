package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.13
 Question Number : 31
 Link : https://leetcode.com/problems/plus-one/
 ==========================================================
 */
public class PlusOne {
	/*
	 * Given a non-negative number represented as an array of digits, plus one
	 * to the number.
	 * 
	 * The digits are stored such that the most significant digit is at the head
	 * of the list.
	 */
	public static void main(String[] args) {
		int digits[] = {9};
		int[] newDigits = plusOne(digits);
		for (int num : newDigits) {
			System.out.print(num);
		}
	}

	public static int[] plusOne(int[] digits) {
		int carry = 1;
		int sum = 0;
		for (int i = digits.length - 1; i >= 0; i--) {
			sum = digits[i] + carry;
			digits[i] = sum % 10;
			carry = sum / 10;
		}

		int[] newDigits = null;

		// If result value is overflowed the current array size the, makes new
		// array to store result value.
		if (carry == 1) {
			newDigits = new int[digits.length + 1];
			newDigits[0] = carry;
			for (int i = 1; i < digits.length + 1; i++) {
				newDigits[i] = digits[i - 1];
			}
		} else {
			newDigits = digits;
		}
		return newDigits;
	}

	// Below solution is not perfect because there is overflow error.
	public static int[] plusOneBasic(int[] digits) {
		double value = 0;
		for (int i = 0; i < digits.length; i++) {
			value *= 10;
			value += digits[i];
		}

		value += 1;
		int digitsLength = getDigitsLength(value);

		int[] newValue = new int[digitsLength];
		for (int i = 0; i < digitsLength; i++) {
			int divisor = (int) (Math.pow(10, digitsLength - i - 1));
			newValue[i] = (int) (value / divisor);
			value = value % divisor;
		}
		return newValue;
	}

	public static int getDigitsLength(double value) {
		int digitsLength = 0;
		while (value >= 1) {
			value /= 10.0;
			digitsLength++;
		}
		return digitsLength;
	}
}
