/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.01
 Problem : http://www.geeksforgeeks.org/searching-for-patterns-set-3-rabin-karp-algorithm/
 ==========================================================
 */

public class Solution {
	/*
	 * Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function
	 * search(char pat[], char txt[]) that prints all occurrences of pat[] in
	 * txt[]. You may assume that n > m.
	 * 
	 * Examples: 1) Input: txt[] = "THIS IS A TEST TEXT" pat[] = "TEST" Output:
	 * Pattern found at index 10
	 * 
	 * 2) Input: txt[] = "AABAACAADAABAAABAA" pat[] = "AABA" Output: Pattern
	 * found at index 0 Pattern found at index 9 Pattern found at index 13
	 */

	public static void main(String[] args) {
		search("THIS IS A TEST TEXT", "TEST");
		search("AABAACAADAABAAABAA", "AABA");
	}

	public static void search(String text, String pattern) {
		if (text == null || pattern == null)
			return;

		System.out.println(text + " : " + pattern);

		int hash = generateHashValue(pattern);
		int value = 0;
		for (int i = 0; i <= text.length() - pattern.length(); i++) {
			if (i == 0) {
				value = generateHashValue(text.substring(i, pattern.length()));
			} else {
				value = modifyHashValue(value, text.charAt(i - 1),
						text.charAt(i + pattern.length() - 1), pattern.length());
			}

			if (hash == value
					&& compare(text.substring(i, i + pattern.length()), pattern)) {
				System.out.println(i + " "
						+ text.substring(i, i + pattern.length()));
			}
		}
		return;
	}

	private static int PRIME_VALUE = 7;
	private static int generateHashValue(String input) {
		int hash = 0;

		for (int i = input.length() - 1; i >= 0; i--) {
			hash *= PRIME_VALUE;
			hash += input.charAt(i) - 'A';
		}

		return hash;
	}

	// If input string is "abc" then the hash value will be (a*prime^2 + b*prime
	// + c)
	private static int modifyHashValue(int old, char prev, char last, int length) {
		int hash = old - (prev - 'A');
		hash /= PRIME_VALUE;
		hash += ((last - 'A') * Math.pow(PRIME_VALUE, length - 1));
		return hash;
	}

	private static boolean compare(String str1, String str2) {
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				return false;
			}
		}
		return true;
	}
}
