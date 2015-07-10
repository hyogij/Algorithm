package leetCode;

import java.util.Stack;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.10
 Question Number : 25
 Link : https://leetcode.com/problems/valid-parentheses/
 ==========================================================
 */
public class ValidParentheses {
	/*
	 * Given a string containing just the characters '(', ')', '{', '}', '[' and
	 * ']', determine if the input string is valid.
	 * 
	 * The brackets must close in the correct order, "()" and "()[]{}" are all
	 * valid but "(]" and "([)]" are not.
	 */
	public static void main(String[] args) {
		System.out.println(isValid("()"));
	}

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (isFrontOrder(c) == true) {
				// Pushes the character to the stack
				stack.push(Character.valueOf(c));
			} else {
				if (stack.isEmpty()) {
					return false;
				}

				// Pops the stack and compares two characters
				char top = stack.pop();
				if (c != getReverseParentheses(top)) {
					return false;
				}
			}
		}

		// Checks stack status
		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	// Checks the given parentheses whether front order or not
	private static boolean isFrontOrder(char c) {
		if (c == '(' || c == '{' || c == '[') {
			return true;
		} else {
			return false;
		}
	}

	// Gets a reverse parentheses
	private static char getReverseParentheses(char c) {
		if (c == '(') {
			return ')';
		}
		if (c == '{') {
			return '}';
		}
		if (c == '[') {
			return ']';
		}
		return c;
	}
}
