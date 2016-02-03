import java.util.HashMap;
import java.util.Stack;

/* 
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *  Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *   Some examples:
 *   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *    
 * http://www.cs.man.ac.uk/~pjj/cs212/fix.html
 * Infix notation : A * B + C / D
 * Postfix notation(also known as "Reverse Polish notation") : A B * C D / +
 * Prefix notation(also known as "Polish notation") : + * A B / C D

 values: true, false
 variables: a, b, c, ... (booleans)
 operators: &&, ||, !

 a && b
 a || b
 !a

 !(a || (!b && c))

 evaluate(expr, map of variables names --> boolean values) --> true/false
 evaluate(a || b, {"a": true, "b": false}) --> true
 evaluate(!!a, {"a": false}) --> false

 "a && (b || c)" ==> ["a", "b", "c", "||", "&&"]
 ()
 evaluate(["a", "b", "c", "||", "&&"], map) --> true/false
 */

class Solution {
	public static void main(String[] args) {
		String exp[] = {"a", "b", "c", "||", "&&", "!", "!"};
//		String exp[] = {"a", "!", "!"};
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("a", true);
		map.put("b", false);
		map.put("c", true);

		// Expected result is true
		System.out.println("evaluate : " + evaluate(exp, map));
	}

	public static boolean evaluate(String[] exp, HashMap<String, Boolean> map) {
		if (exp == null || exp.length == 0) {
			return false;
		}

		Stack<Boolean> stack = new Stack<Boolean>();
		for (int i = 0; i < exp.length; i++) {
			String variable = exp[i];

			// Operators : &&, ||, !
			if (variable.equals("&&") || variable.equals("||")) {
				Boolean first = stack.pop(), second = stack.pop();
				if (variable.equals("&&")) {
					stack.push(first && second);
				} else if (variable.equals("||")) {
					stack.push(first || second);
				}
			} else if (variable.equals("!")) {
				stack.push(!stack.pop());
			} else {
				// variables: a, b, c, ... (booleans)
				stack.push(map.get(variable));
			}
		}
		return stack.pop();
	}
}
