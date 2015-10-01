package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.10.01
 Question Number : 122
 Link : https://leetcode.com/problems/count-and-say/
 ==========================================================
 */

public class CountAndSay {
	/*
	 * The count-and-say sequence is the sequence of integers beginning as
	 * follows: 1, 11, 21, 1211, 111221, 312211, 13112221 ...
	 * 
	 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is
	 * read off as "one 2, then one 1" or 1211. Given an integer n, generate the
	 * nth sequence.
	 * 
	 * Note: The sequence of integers will be represented as a string.
	 */
	public static void main(String[] args) {
		int num = 10;
		System.out.println("countAndSay " + countAndSay(num));
	}

	public static String countAndSay(int n) {
		String count = "1";

		for (int i = 1; i < n; i++) {
			count = countAndSayHelper(count);
		}

		return count;
	}

	public static String countAndSayHelper(String input) {
		if (input.length() <= 0) {
			return "";
		}

		StringBuffer result = new StringBuffer();
		int count = 1;
		char prev = input.charAt(0);

		// Count the current charcter in string and write the number of current
		// charcter's frequence if current character is changed
		for (int i = 1; i < input.length(); i++) {
			char current = input.charAt(i);
			if (prev == current) {
				count++;
			} else {
				result.append(String.valueOf(count) + String.valueOf(prev));
				count = 1;
				prev = current;
			}
		}

		// Append the last charcter's frequence
		result.append(String.valueOf(count) + String.valueOf(prev));
		return result.toString();
	}
}
