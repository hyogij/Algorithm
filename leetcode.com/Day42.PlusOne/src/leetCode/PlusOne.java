package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.02
 Question Number : 2
 Link : https://leetcode.com/problems/plus-one/
 ==========================================================
 */

public class PlusOne {
	/*
	 * Given a non-negative number represented as an array of digits, plus one
	 * to the number. The digits are stored such that the most significant digit
	 * is at the head of the list.
	 */
	public static void main(String[] args) {
		int[] nums = {9,8,7,6,5,4,3,2,1,0};
		int[] result = plusOne(nums);
		for (int num : result) {
			System.out.print(num);
		}
	}

	public static int[] plusOne(int[] digits) {
		if (digits == null || digits.length == 0) {
			return null;
		}

		int[] result = new int[digits.length];

		// Plus one
		int carry = 1, sum = 0;

		for (int i = digits.length - 1; i >= 0; i--) {
			sum = digits[i] + carry;
			carry = (sum) / 10;
			result[i] = sum % 10;
		}

		// Increase the array size if there is remain carry
		if (carry != 0) {
			int[] newResult = new int[result.length + 1];
			newResult[0] = carry;
			System.arraycopy(result, 0, newResult, 1, result.length);
			result = null;
			return newResult;
		}

		return result;
	}
}