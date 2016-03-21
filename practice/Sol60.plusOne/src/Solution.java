import java.util.Arrays;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.21
 Problem : https://leetcode.com/problems/plus-one/
 ==========================================================
 */
public class Solution {
	/*
	 * Given a non-negative number represented as an array of digits, plus one
	 * to the number.
	 * 
	 * The digits are stored such that the most significant digit is at the head
	 * of the list.
	 */
	public static void main(String[] args) {
		int[] num1 = {3, 2, 1, 2};
		num1 = plusOne(num1);
		System.out.println("plusOne " + Arrays.toString(num1));

		int[] num2 = {1, 9};
		num2 = plusOne(num2);
		System.out.println("plusOne " + Arrays.toString(num2));

		int[] num3 = {9, 9, 9};
		num3 = plusOne(num3);
		System.out.println("plusOne " + Arrays.toString(num3));
		
		int[] num4 = {9, 9, 9};
		num4 = plusOneAdvanced(num4);
		System.out.println("plusOne " + Arrays.toString(num4));
	}

	public static int[] plusOne(int[] digits) {
		int carry = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			int sum = (digits[i] + carry) % 10;
			carry = (digits[i] + carry) / 10;
			digits[i] = sum;
		}

		if (carry != 0) {
			int[] num = new int[digits.length + 1];
			num[0] = carry;
			for (int i = 1; i < num.length; i++) {
				num[i] = digits[i - 1];
			}
			return num;
		}
		return digits;
	}

	public static int[] plusOneAdvanced(int[] digits) {
		int n = digits.length;
		for (int i = n - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}

			digits[i] = 0;
		}

		int[] newNumber = new int[n + 1];
		newNumber[0] = 1;

		return newNumber;
	}
}
