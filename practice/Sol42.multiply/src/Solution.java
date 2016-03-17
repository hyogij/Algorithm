import java.util.Arrays;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.17
 Problem : https://leetcode.com/problems/multiply-strings/
 ==========================================================
 */
public class Solution {
	/*
	 * Given two numbers represented as strings, return multiplication of the
	 * numbers as a string. Note: The numbers can be arbitrarily large and are
	 * non-negative.
	 */
	public static void main(String[] args) {
		System.out.println("multiply : " + multiply("14", "27"));
		System.out.println("multiply : " + multiply("579", "124"));
		System.out.println("multiply : " + multiply("0", "0"));
	}

	public static String multiply(String num1, String num2) {
		int[] array = new int[num1.length() + num2.length()];

		// Reverse string to multiply from the last number of string
		StringBuffer sb1 = new StringBuffer(num1);
		num1 = sb1.reverse().toString();
		StringBuffer sb2 = new StringBuffer(num2);
		num2 = sb2.reverse().toString();

		for (int i = 0; i < num1.length(); i++) {
			int a = num1.charAt(i) - '0';
			for (int j = 0; j < num2.length(); j++) {
				int index = i + j;
				int b = num2.charAt(j) - '0';
				int tmp = (a * b) + array[index];

				array[index] = (tmp) % 10;
				array[index + 1] += ((tmp) / 10);
			}
		}

		// Make a string value using numbers in array
		System.out.println(Arrays.toString(array));

		StringBuffer sb = new StringBuffer();
		for (int num : array)
			sb.append(num);

		// Remove '0' string in front of number
		String number = sb.reverse().toString();
		int index = 0;
		for (; index < number.length(); index++)
			if (number.charAt(index) != '0')
				break;

		number = number.substring(index, number.length());
		if (number.length() == 0)
			return "0";
		return number;
	}
}
