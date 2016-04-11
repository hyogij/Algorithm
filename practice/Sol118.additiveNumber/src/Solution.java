import java.util.Arrays;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.09
 Link : https://leetcode.com/problems/additive-number/
 ==========================================================
 */
public class Solution {
	/*
	 * Additive number is a string whose digits can form additive sequence.
	 * 
	 * A valid additive sequence should contain at least three numbers. Except
	 * for the first two numbers, each subsequent number in the sequence must be
	 * the sum of the preceding two.
	 * 
	 * For example: "112358" is an additive number because the digits can form
	 * an additive sequence: 1, 1, 2, 3, 5, 8.
	 * 
	 * 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8 "199100199" is also an
	 * additive number, the additive sequence is: 1, 99, 100, 199. 1 + 99 = 100,
	 * 99 + 100 = 199 Note: Numbers in the additive sequence cannot have leading
	 * zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
	 * 
	 * Given a string containing only digits '0'-'9', write a function to
	 * determine if it's an additive number.
	 * 
	 */
	public static void main(String[] args) {
		System.out.println("isAdditiveNumber " + isAdditiveNumber("101"));
		System.out.println("isAdditiveNumber " + isAdditiveNumber("1023"));
		System.out.println("isAdditiveNumber " + isAdditiveNumber("112358"));
		System.out.println("isAdditiveNumber " + isAdditiveNumber("199100199"));
		System.out.println("isAdditiveNumber " + isAdditiveNumber("198019823962"));
		System.out.println("isAdditiveNumber " + isAdditiveNumber("12012122436"));
	}

	public static boolean isAdditiveNumber(String num) {
		// To handle integer overflow
		long[] numbers = new long[2];
		for (int i = 2; i < num.length(); i++) {
			for (int j = 1; j <= i / 2; j++) {
				getNumber(num, j, i - j, numbers);
				if (j < num.length()) {
					if (checkRemainString(num.substring(i), numbers))
						return true;
				}
			}
		}
		return false;
	}

	private static void getNumber(String num, int len1, int len2, long[] numbers) {
		numbers[0] = Long.valueOf(num.substring(0, len1));

		String num2 = num.substring(len1, len1 + len2);
		if (num2.length() != 1 && num2.charAt(0) == '0')
			numbers[1] = -1;
		else
			numbers[1] = Long.valueOf(num2);
	}

	private static boolean checkRemainString(String num, long[] numbers) {
		int index = 0;
		while (index < num.length()) {
			long sum = numbers[0] + numbers[1];
			int length = String.valueOf(sum).length();

			if (index + length <= num.length()) {
				String result = num.substring(index, index + length);
				if (!result.equals(String.valueOf(sum))) {
					return false;
				}
			} else {
				return false;
			}

			index += length;
			numbers[0] = numbers[1];
			numbers[1] = sum;
		}
		return true;
	}
}
