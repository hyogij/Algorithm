import java.util.ArrayList;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.11.30
 Problem : Match the braces and verify weather all the opening braces has the closing braces in right order.
 Reference : http://www.snippetexample.com/2015/03/parentheses-brackets-check/
 ==========================================================
 */
public class Solution {
	private static final String YES = "YES";
	private static final String NO = "NO";

	public static void main(String[] args) {
		String[] values = {"()", "({({()})})", "(((((((", ")))))(((((",
				"))))))"};
		String[] results = Braces(values);

		for (int i = 0; i < results.length; i++) {
			String value = results[i];
			System.out.println(value);
		}
		return;
	}

	static String[] Braces(String[] values) {
		String[] results = new String[values.length];
		for (int i = 0; i < values.length; i++) {
			String value = values[i];
			results[i] = BracesHelper(value);
		}
		return results;
	}

	static String BracesHelper(String value) {
		ArrayList<Character> list = new ArrayList<Character>();
		for (int i = 0; i < value.length(); i++) {
			char c = value.charAt(i);
			if (c == '(' || c == '{' || c == '[') {
				list.add(c);
			} else {
				if (list.size() == 0) {
					return NO;
				}
				char top = list.get(list.size() - 1);
				if (c == ')' && top == '(') {
					list.remove(list.size() - 1);
				} else if (c == '}' && top == '{') {
					list.remove(list.size() - 1);
				} else if (c == ']' && top == '[') {
					list.remove(list.size() - 1);
				} else {
					return NO;
				}
			}
		}

		if (list.size() == 0) {
			return YES;
		} else {
			return NO;
		}
	}
}