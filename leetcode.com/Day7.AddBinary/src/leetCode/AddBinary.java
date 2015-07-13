package leetCode;

import java.util.Stack;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.13
 Question Number : 28
 Link : https://leetcode.com/problems/count-and-say/
 ==========================================================
 */
public class AddBinary {
	/*
	 * Given two binary strings, return their sum (also a binary string).
	 * 
	 * For example, a = "11" b = "1" Return "100".
	 */
	public static void main(String[] args) {
		String a = "100";
		String b = "110010";
		System.out.println("addBinary " + addBinary(a, b));
	}

	// Adds two binary numbers without stack or list
	public static String addBinary(String a, String b) {
		StringBuffer stringBuffer = new StringBuffer();
		int minLength = 0;

		if (a.length() < b.length()) {
			minLength = a.length();
		} else {
			minLength = b.length();
		}

		int sum, carry = 0;
		int num1, num2;

		// Adds two binary numbers
		for (int i = 0; i < minLength; i++) {
			num1 = Integer
					.parseInt(String.valueOf(a.charAt(a.length() - i - 1)));
			num2 = Integer
					.parseInt(String.valueOf(b.charAt(b.length() - i - 1)));

			sum = num1 + num2 + carry;
			carry = (sum) / 2;
			stringBuffer.insert(0, sum % 2);
		}

		// Adds remain numbers
		String remaining = null;
		if (a.length() < b.length()) {
			remaining = b;
		} else {
			remaining = a;
		}

		for (int i = remaining.length() - minLength - 1; i >= 0; i--) {
			num1 = Integer.parseInt(String.valueOf(remaining.charAt(i)));

			sum = num1 + carry;
			carry = (sum) / 2;
			stringBuffer.insert(0, sum % 2);
		}

		// When there is remain carry, adds to the stack
		if (carry == 1) {
			stringBuffer.insert(0, carry);
		}

		return stringBuffer.toString();
	}

	// Adds two binary numbers using 2 stacks
	public static String addBinaryStack(String a, String b) {
		StringBuffer stringBuffer = new StringBuffer();

		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		Stack<Integer> result = new Stack<Integer>();

		// Adds digits to stack
		for (int i = 0; i < a.length(); i++) {
			stack1.push(Integer.parseInt(String.valueOf(a.charAt(i))));
		}

		for (int i = 0; i < b.length(); i++) {
			stack2.push(Integer.parseInt(String.valueOf(b.charAt(i))));
		}

		int carry = 0, sum;
		int num1, num2;

		// Adds two stacks
		while (!stack1.isEmpty() && !stack2.isEmpty()) {
			num1 = stack1.pop();
			num2 = stack2.pop();

			sum = num1 + num2 + carry;
			carry = sum / 2;
			result.push(sum % 2);
		}

		// Adds remain numbers
		while (!stack1.isEmpty()) {
			num1 = stack1.pop();

			sum = num1 + carry;
			carry = sum / 2;
			result.push(sum % 2);
		}
		while (!stack2.isEmpty()) {
			num2 = stack2.pop();

			sum = num2 + carry;
			carry = sum / 2;
			result.push(sum % 2);
		}

		// When there is remain carry, adds to the stack
		if (carry == 1) {
			result.push(carry);
		}

		while (!result.isEmpty()) {
			num1 = result.pop();
			stringBuffer.append(num1);
		}

		return stringBuffer.toString();
	}
}
