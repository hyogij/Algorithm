package leetCode;

import java.util.ArrayList;
import java.util.Stack;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.08.24
 Question Number : 93
 Link : https://leetcode.com/problems/basic-calculator/
 ==========================================================
 */

public class Calculate {
	/*
	 * Implement a basic calculator to evaluate a simple expression string.
	 * 
	 * The expression string may contain open ( and closing parentheses ), the
	 * plus + or minus sign -, non-negative integers and empty spaces .
	 * 
	 * You may assume that the given expression is always valid.
	 * 
	 * Some examples: "1 + 1" = 2 " 2-1 + 2 " = 3 "(1+(4+5+2)-3)+(6+8)" = 23
	 * 
	 * Note: Do not use the eval built-in library function.
	 */
	public static void main(String[] args) {
		System.out.println("calculate " + calculate("1 + 1"));
		System.out.println("calculate " + calculate(" 2-1 + 2 "));
		System.out.println("calculate " + calculate("(1+(4+5+2)-3)+(6+8)"));
	}

	public static int calculate(String s) {
		Stack<Integer> numbers = new Stack<Integer>();
		int num = 0, res = 0, sign = 1;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				num = num * 10 + s.charAt(i) - '0';
			} else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
				res += num * sign;
				sign = (s.charAt(i) == '+') ? 1 : -1;
				num = 0;// reset
			} else if (s.charAt(i) == '(') { 
				// push the result to the stack
				numbers.push(res);
				numbers.push(sign);
				res = 0;// reset
				sign = 1;// reset
			} else if (s.charAt(i) == ')') { 
				// remove () and pop the pre-result from the stack
				res += num * sign;
				res *= numbers.pop();
				res += numbers.pop();
				num = 0;// reset
			}
		}
		if (num != 0)
			res += num * sign;
		return res;
	}
}
