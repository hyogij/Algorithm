import java.util.Stack;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.01
 Problem : https://leetcode.com/problems/basic-calculator/
 ==========================================================
 */
public class Solution {
	/*
	 * Implement a basic calculator to evaluate a simple expression string.
	 * 
	 * The expression string may contain open ( and closing parentheses ), the
	 * plus + or minus sign -, non-negative integers and empty spaces .
	 * 
	 * You may assume that the given expression is always valid.
	 * 
	 * Some examples: 
	 * "1 + 1" = 2 
	 * " 2-1 + 2 " = 3 
	 * "(1+(4+5+2)-3)+(6+8)" = 23
	 */
	public static void main(String[] args) {
		System.out.println("calculate " + calculate("1 + 1"));
		System.out.println("calculate " + calculate(" 2-1 + 2 "));
		System.out.println("calculate " + calculate("(1+(4+5+2)-3)+(6+8)"));
	}

	public static int calculate(String s) {
		int value = 0;
		
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Character> stack2 = new Stack<Character>();
		
		int num = 0, count = 0;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(Character.isDigit(c)) {
				num *= 10;
				num += Integer.valueOf(c);
			} else {
				if(num != 0) {
					stack1.push(num);
				}
				
				num = 0;
			}
			
			if(c == '+' || )
		}
		
		
		return value;
	}
}
