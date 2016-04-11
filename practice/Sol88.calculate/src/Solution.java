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
	 * Some examples: "1 + 1" = 2 " 2-1 + 2 " = 3 "(1+(4+5+2)-3)+(6+8)" = 23
	 */
	public static void main(String[] args) {
		List<Object> list = infixTopostfix("0");
		System.out.println(calculatePostfix(list));

		list = infixTopostfix("0");
		System.out.println(calculatePostfix(list));
//		list = infixTopostfix("0-2147483647");
//		System.out.println(calculatePostfix(list));
//		list = infixTopostfix(" 2-1 + 2 ");
//		System.out.println(calculatePostfix(list));
//		list = infixTopostfix("(1+(4+5+2)-3)+(6+8)");
//		System.out.println(calculatePostfix(list));
//		list = infixTopostfix("3+2*2");
//		System.out.println(calculatePostfix(list));
//		list = infixTopostfix("3/2");
//		System.out.println(calculatePostfix(list));
//		list = infixTopostfix("3+5 / 2");
//		System.out.println(calculatePostfix(list));
//		list = infixTopostfix("2147483647");
//		System.out.println(calculatePostfix(list));
//		list = infixTopostfix("1*2-3/4+5*6-7*8+9/10");
//		System.out.println(calculatePostfix(list));
	}

	public static List<Object> infixTopostfix(String input) {
		List<Object> list = new ArrayList<Object>();
		Stack<Character> stack = new Stack<Character>();
		int num = 0;
		boolean isCreatedNum = false;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (Character.isDigit(c)) {
				isCreatedNum = true;
				num *= 10;
				num += (c - '0');
			} else {
				if (isCreatedNum) {
					list.add(num);
					num = 0;
					isCreatedNum = false;
				}
				if (c == '(') {
					stack.push(c);
				} else if (c == ')') {
					while (stack.isEmpty() != true && stack.peek() != '(') {
						list.add(stack.pop());
					}
					stack.pop(); // pop '('
				} else if (c == '*' || c == '/' || c == '^') {
					if (stack.isEmpty()) {
						stack.push(c);
						continue;
					}
					while (stack.isEmpty() != true && (stack.peek() != '+' && stack.peek() != '-')
							&& stack.peek() != '(') {
						list.add(stack.pop());
					}
					stack.push(c);
				} else if (c == '+' || c == '-') {
					if (stack.isEmpty()) {
						stack.push(c);
						continue;
					}
					while (stack.isEmpty() != true && stack.peek() != '(') {
						list.add(stack.pop());
					}
					stack.push(c);
				}
			}
		}
		if (isCreatedNum) {
			list.add(num);
		}

		while (stack.isEmpty() != true) {
			if (stack.peek() != '(') {
				list.add(stack.pop());
			} else {
				stack.pop();
			}

		}
		return list;
	}

	public static int calculatePostfix(List<Object> list) {
		System.out.println(list.toString());
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) instanceof Character) {
				char c = (char) list.get(i);
				if (c == '+') {
					stack.push(stack.pop() + stack.pop());
				} else if (c == '-') {
					int a = stack.pop();
					int b = stack.pop();
					stack.push(b - a);
				} else if (c == '*') {
					stack.push(stack.pop() * stack.pop());
				} else if (c == '/') {
					int a = stack.pop();
					int b = stack.pop();
					stack.push(b / a);
				}
			} else {
				stack.push((Integer) list.get(i));
			}
		}
		
		if(stack.isEmpty() == true)
			return 0;
		return stack.pop();
	}
}
