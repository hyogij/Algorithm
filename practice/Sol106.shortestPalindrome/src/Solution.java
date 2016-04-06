import java.util.Arrays;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.06
 Problem : https://leetcode.com/problems/shortest-palindrome/
 ==========================================================
 */
public class Solution {
	/*
	 * Given a string S, you are allowed to convert it to a palindrome by adding
	 * characters in front of it. Find and return the shortest palindrome you
	 * can find by performing this transformation.
	 * 
	 * For example:
	 * 
	 * Given "aacecaaa", return "aaacecaaa". Given "abcd", return "dcbabcd".
	 */
	public static void main(String[] args) {
		System.out.println(shortestPalindrome("aacecaaa"));
		System.out.println(shortestPalindromeNaive("aacecaaa"));
		System.out.println(shortestPalindrome("abcd"));
		System.out.println(shortestPalindromeNaive("abcd"));
		System.out.println(shortestPalindrome("aaaaa"));
		System.out.println(shortestPalindromeNaive("aaaaa"));
		System.out.println(shortestPalindrome("aaaa"));
		System.out.println(shortestPalindromeNaive("aaaa"));
	}

	public static String shortestPalindromeNaive(String s) {
		StringBuffer sb = new StringBuffer(s);
		
		if (isPalindrome(s))
			return s;

		for (int i = 0; i < s.length(); i++) {
			String palindrom = sb.reverse().substring(0, i + 1) + s;
			if (isPalindrome(palindrom))
				return palindrom;
		}

		while (true) {
			if (isPalindrome(s)) {
				return s;
			}
			s = s.charAt(s.length() - 1) + s;
		}
	}

	public static boolean isPalindrome(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static String shortestPalindrome(String s) {
		if (s == null || s.length() == 0)
			return "";

		String temp = s + "#" + new StringBuilder(s).reverse().toString();
		int[] table = makeNext(temp);

		// Get the maximum palin part in s starts from 0
		return new StringBuilder(s.substring(table[table.length - 1]))
				.reverse().toString() + s;
	}

	public static int[] makeNext(String s) {
		int[] next = new int[s.length()];

		int index = 0;
		for (int i = 1; i < s.length();) {
			if (s.charAt(index) == s.charAt(i)) {
				next[i] = index + 1;
				index++;
				i++;
			} else {
				if (index != 0) {
					index = next[index - 1];
				} else {
					next[i] = 0;
					i++;
				}
			}
		}
		return next;
	}
}
