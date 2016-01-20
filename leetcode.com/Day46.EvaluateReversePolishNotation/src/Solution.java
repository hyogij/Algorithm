import java.util.Stack;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.01.19
 Question Number : 158
 Link : https://leetcode.com/problems/evaluate-reverse-polish-notation/
 ==========================================================
 */
public class Solution {
	/*
	 * Evaluate the value of an arithmetic expression in Reverse Polish
	 * Notation. Valid operators are +, -, *, /. Each operand may be an integer
	 * or another expression.
	 * 
	 * Some examples: 
	 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 
	 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
	 */
	public static void main(String[] args) {
		String[] tokens1 = {"2", "1", "+", "3", "*"};
		System.out.println("evalRPN " + evalRPN(tokens1));
		String[] tokens2 = {"4", "13", "5", "/", "+"};
		System.out.println("evalRPN " + evalRPN(tokens2));
		
		// calculate("2 3 +") # => 5 
		// calculate("12 2 /") #=> 6 
		// calculate("48 4 6 * /") # => 2 
		System.out.println("evalRPNwithString " + evalRPNwithString("2 3 +"));
		System.out.println("evalRPNwithString " + evalRPNwithString("12 2 /"));
		System.out.println("evalRPNwithString " + evalRPNwithString("48 4 6 * /"));
	}

	// Store operands using stack data structure
	// If we meet the operator(+, -, *, /), pop the two operands in the stack.
	// Calculate the result and insert it into the stack
	// Repeat above process, until the end of the tokens
	public static int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		for (String token : tokens) {
			if (token.equals("+") || token.equals("-") || token.equals("*")
					|| token.equals("/")) {
				int operand2 = stack.pop();
				int operand1 = stack.pop();
				int result = 0;
				switch (token.charAt(0)) {
					case '+' :
						result = operand1 + operand2;
						break;
					case '-' :
						result = operand1 - operand2;
						break;
					case '*' :
						result = operand1 * operand2;
						break;
					case '/' :
						result = operand1 / operand2;
						break;
				}
				stack.push(result);
			} else {
				stack.push(Integer.parseInt(token));
			}
		}
		return stack.pop();
	}

	public static int evalRPNwithString(String expression) {
		Stack<Integer> stack = new Stack<Integer>();
		String[] tokens = expression.split("\\s+");
		for (String token : tokens) {
			if (token.equals("+") || token.equals("-") || token.equals("*")
					|| token.equals("/")) {
				int operand2 = stack.pop();
				int operand1 = stack.pop();
				int result = 0;
				switch (token.charAt(0)) {
					case '+' :
						result = operand1 + operand2;
						break;
					case '-' :
						result = operand1 - operand2;
						break;
					case '*' :
						result = operand1 * operand2;
						break;
					case '/' :
						result = operand1 / operand2;
						break;
				}
				stack.push(result);
			} else {
				stack.push(Integer.parseInt(token));
			}
		}
		return stack.pop();
	}
}
