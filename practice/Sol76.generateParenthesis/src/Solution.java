import java.util.ArrayList;
import java.util.List;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.10.14
 Link : https://leetcode.com/problems/generate-parentheses/
 ==========================================================
 */

public class Solution {
	/*
	 * Given a collection of numbers, return all possible permutations.
	 * 
	 * Given n pairs of parentheses, write a function to generate all
	 * combinations of well-formed parentheses.
	 * 
	 * For example, given n = 3, a solution set is:
	 * 
	 * "((()))", "(()())", "(())()", "()(())", "()()()"
	 * 
	 * Subscribe to see which companies asked this question
	 */
	public static void main(String[] args) {
		List<String> parenthesis = generateParenthesis(3);
		System.out.println(parenthesis.toString());
	}

	public static List<String> generateParenthesis(int n) {
		List<String> parenthesis = new ArrayList<String>();
		if (n == 0)
			return parenthesis;
		generateParenthesisHelper(0, n, parenthesis, new StringBuffer());
		return parenthesis;
	}

	public static void generateParenthesisHelper(int index, int n, List<String> list,
			StringBuffer sb) {
		if (index == n) {
			if (list.contains(sb.toString()) == false)
				list.add(sb.toString());
			return;
		}

		for (int i = index; i <= sb.toString().length(); i++) {
			StringBuffer sb1 = new StringBuffer(sb.toString());
			sb1.insert(i, "()");
			generateParenthesisHelper(index + 1, n, list, sb1);
		}
	}
}
