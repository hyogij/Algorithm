
/*
==========================================================
Author : Hyogi Jung(hyogij@gmail.com)
Date : 2016.04.13
Problem : http://www.geeksforgeeks.org/count-possible-decodings-given-digit-sequence/
==========================================================
*/
public class Solution {
	/*
	 * Let 1 represent ‘A’, 2 represents ‘B’, etc. Given a digit sequence, count
	 * the number of possible decodings of the given digit sequence.
	 * 
	 * Examples:
	 * 
	 * Input: digits[] = "121" Output: 3 // The possible decodings are "ABA",
	 * "AU", "LA"
	 * 
	 * Input: digits[] = "1234" Output: 3 // The possible decodings are "ABCD",
	 * "LCD", "AWD"
	 * 
	 * An empty digit sequence is considered to have one decoding. It may be
	 * assumed that the input contains valid digits from 0 to 9 and there are no
	 * leading 0’s, no extra trailing 0’s and no two or more consecutive 0’s.
	 */
	public static void main(String[] args) {
		System.out.println("countDecoding " + countDecoding("121"));
		System.out.println("countDecodingDp " + countDecodingDp("121"));
		System.out.println("countDecoding " + countDecoding("1234"));
		System.out.println("countDecodingDp " + countDecodingDp("1234"));
		System.out.println("countDecoding " + countDecoding("12341"));
		System.out.println("countDecodingDp " + countDecodingDp("12341"));
		System.out.println("countDecoding " + countDecoding("1211"));
		System.out.println("countDecodingDp " + countDecodingDp("1211"));
	}

	public static int countDecoding(String input) {
		return helper(input, input.length());
	}

	public static int helper(String input, int index) {
		if (index <= 1)
			return 1;

		int value = Integer.valueOf(input.substring(index - 2, index));
		if (value <= 26) {
			return helper(input, index - 2) + helper(input, index - 1);
		}
		return helper(input, index - 1);
	}

	public static int countDecodingDp(String input) {
		int num1 = 1, num2 = 1, num3 = 0;
		for (int i = 1; i < input.length(); i++) {
			int value = Integer.valueOf(input.substring(i - 1, i + 1));
			if (value <= 26)
				num3 = num2 + num1;
			num1 = num2;
			num2 = num3;
		}
		return num2;
	}
}