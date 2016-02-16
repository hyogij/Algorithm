/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.02.16
 Link : http://www.geeksforgeeks.org/given-a-string-find-its-first-non-repeating-character/
 ==========================================================
 */
public class Solution {
	/*
	 * Given a string, find the first non-repeating character in it. For
	 * example, if the input string is "GeeksforGeeks", then output should be
	 * 'f' and if input string is "GeeksQuiz", then output should be 'G'.
	 */
	public static void main(String[] args) {
		System.out.println("findFirstNonRepatingChar : "
				+ findFirstNonRepatingChar("GeeksforGeeks"));
		System.out.println("findFirstNonRepatingChar : "
				+ findFirstNonRepatingChar("GeeksQuiz"));
	}

	public static char findFirstNonRepatingChar(String str) {
		int[] ascii = new int[256];

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			ascii[c]++;
		}

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (ascii[c] == 1) {
				return c;
			}
		}

		return ' ';
	}
}
