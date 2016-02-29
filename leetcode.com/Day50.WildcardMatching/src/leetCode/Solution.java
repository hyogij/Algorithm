package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.02.29
 Question Number : 168
 Link : https://leetcode.com/problems/wildcard-matching/
 ==========================================================
 */
public class Solution {
	/*
	 * Implement wildcard pattern matching with support for '?' and '*'.
	 * 
	 * '?' Matches any single character. '*' Matches any sequence of characters
	 * (including the empty sequence). The matching should cover the entire
	 * input string (not partial). The function prototype should be: bool
	 * isMatch(const char *s, const char *p) 
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
		System.out.println(isMatch("aa", "a"));
		System.out.println(isMatch("aa", "aa"));
		System.out.println(isMatch("aaa", "aa"));
		System.out.println(isMatch("aa", "*"));
		System.out.println(isMatch("aa", "a*"));
		System.out.println(isMatch("ab", "?*"));
		System.out.println(isMatch("aab", "c*a*b"));
		System.out.println(isMatch("aaacab", "a*a*a"));
		System.out.println(isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******a"));		
	}
	
	// iterative method
	public static boolean isMatch(String s, String p) {
		int i = 0;
		int j = 0;
		int starIndex = -1;
		int iIndex = -1;

		while (i < s.length()) {
			if (j < p.length()
					&& (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
				++i;
				++j;
			} else if (j < p.length() && p.charAt(j) == '*') {
				starIndex = j;
				iIndex = i;
				j++;
			} else if (starIndex != -1) {
				j = starIndex + 1;
				i = iIndex + 1;
				iIndex++;
			} else {
				return false;
			}
		}

		while (j < p.length() && p.charAt(j) == '*') {
			++j;
		}

		return j == p.length();
	}

	// recursive method
	public static boolean isMatchRecursive(String s, String p) {
		return isMatchHepler(s, p, 0, 0);
	}

	private static boolean isMatchHepler(String s, String p, int index1,
			int index2) {
		if (index1 < s.length() && index2 == p.length()) {
			return false;
		}

		if (index1 == s.length() && index2 == p.length()) {
			return true;
		}

		if (index1 == s.length() && index2 < p.length()) {
			return false;
		}

		char c1 = s.charAt(index1);
		char c2 = p.charAt(index2);

		if (c2 == '*') {
			return isMatchHepler(s, p, index1 + 1, index2 + 1)
					|| isMatchHepler(s, p, index1 + 1, index2);
		} else if (c2 == '?' || c1 == c2) {
			return isMatchHepler(s, p, index1 + 1, index2 + 1);
		}
		return false;
	}
}
