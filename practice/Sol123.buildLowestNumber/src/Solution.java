/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.10
 Link : http://www.geeksforgeeks.org/build-lowest-number-by-removing-n-digits-from-a-given-number/
 ==========================================================
 */
public class Solution {
	/*
	 * Given a string ‘str’ of digits and an integer ‘n’, build the lowest
	 * possible number by removing ‘n’ digits from the string and not changing
	 * the order of input digits.
	 * 
	 * Examples:
	 * 
	 * Input: str = "4325043", n = 3 Output: "2043" Input: str = "765028321", n
	 * = 5 Output: "0221" Input: str = "121198", n = 2 Output: "1118"
	 * 
	 */
	public static void main(String[] args) {
		System.out.println(buildLowestNumber("4325043", 3));
		System.out.println(buildLowestNumber("765028321", 5));
		System.out.println(buildLowestNumber("121198", 2));
	}

	public static String buildLowestNumber(String input, int d) {
		if (input == null || input.length() == 0 || input.length() < d)
			return null;

		StringBuffer sb = new StringBuffer();
		helper(input, d, sb);
		return sb.toString();
	}

	public static void helper(String input, int d, StringBuffer sb) {
		// There is nothing to remove. Append the whole 'str' to 'res'
		if (d == 0) {
			sb.append(input);
			return;
		}

		// Everything can be removed
		if (input.length() <= d) {
			return;
		}

		int min = findSmallestChar(input, d);
		sb.append(input.charAt(min));
		helper(input.substring(min + 1), d - min, sb);
	}

	// Find the smallest character index within d+1 window
	public static int findSmallestChar(String input, int d) {
		int min = 0;
		char c = input.charAt(0);
		for (int i = 1; i <= d; i++) {
			if (c > input.charAt(i)) {
				c = input.charAt(i);
				min = i;
			}
		}
		return min;
	}
}