
/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.11
 Problem : https://leetcode.com/problems/wildcard-matching/
 ==========================================================
 */
public class Solution {
	/*
	 * Implement wildcard pattern matching with support for '?' and '*'.
	 * 
	 * '?' Matches any single character. '*' Matches any sequence of characters
	 * (including the empty sequence).
	 * 
	 * The matching should cover the entire input string (not partial).
	 * 
	 * The function prototype should be: bool isMatch(const char *s, const char
	 * *p)
	 * 
	 * Some examples: 
	 * isMatch("aa","a") ¡æ false 
	 * isMatch("aa","aa") ¡æ true
	 * isMatch("aaa","aa") ¡æ false 
	 * isMatch("aa", "*") ¡æ true 
	 * isMatch("aa", "a*") ¡æ true 
	 * isMatch("ab", "?*") ¡æ true 
	 * isMatch("aab", "c*a*b") ¡æ false
	 */
	public static void main(String[] args) {
		System.out.println("isMatch " + isMatchRecursive("aa", "a"));
		System.out.println("isMatch " + isMatchRecursive("aa", "aa"));
		System.out.println("isMatch " + isMatchRecursive("aaa", "aa"));
		System.out.println("isMatch " + isMatchRecursive("aa", "*"));
		System.out.println("isMatch " + isMatchRecursive("aa", "a*"));
		System.out.println("isMatch " + isMatchRecursive("ab", "?*"));
		System.out.println("isMatch " + isMatchRecursive("aab", "c*a*b"));
	}

	// Dynamic Programming
//	public static boolean isMatch(String s, String p) {
//
//	}

	// Recursive method
	public static boolean isMatchRecursive(String s, String p) {
		return isMatchHelper(s, p, 0, 0);
	}

	private static boolean isMatchHelper(String s, String p, int idx1, int idx2) {
		if (s.length() == idx1 && p.length() == idx2)
			return true;

		if (s.length() == idx1 && p.length() != idx2)
			return false;

		if (s.length() != idx1 && p.length() == idx2)
			return false;

		char c1 = s.charAt(idx1);
		char c2 = p.charAt(idx2);

		if (c2 == '*') {
			return isMatchHelper(s, p, idx1 + 1, idx2)
					|| isMatchHelper(s, p, idx1 + 1, idx2 + 1);
		} else if (c2 == '?' || c1 == c2) {
			return isMatchHelper(s, p, idx1 + 1, idx2 + 1);
		} 
		return false;
	}
	
	public boolean isMatchDP(String s, String p) {
		int m = s.length(), n = p.length();
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (p.charAt(i) == '*')
				count++;
		}
		if (count == 0 && m != n)
			return false;
		else if (n - count > m)
			return false;

		boolean[] match = new boolean[m + 1];
		match[0] = true;
		for (int i = 0; i < m; i++) {
			match[i + 1] = false;
		}
		for (int i = 0; i < n; i++) {
			if (p.charAt(i) == '*') {
				for (int j = 0; j < m; j++) {
					match[j + 1] = match[j] || match[j + 1];
				}
			} else {
				for (int j = m - 1; j >= 0; j--) {
					match[j + 1] = (p.charAt(i) == '?' || p.charAt(i) == s.charAt(j)) && match[j];
				}
				match[0] = false;
			}
		}
		return match[m];
	}
}
