/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.06
 Problem : https://leetcode.com/problems/longest-palindromic-substring/
 ==========================================================
 */
public class Solution {
	/*
	 * Given a string S, find the longest palindromic substring in S. You may
	 * assume that the maximum length of S is 1000, and there exists one unique
	 * longest palindromic substring.
	 */
	public static void main(String[] args) {
		System.out.println("longestPalindrome "
				+ longestPalindrome("forgeeksskeegfor"));
	}

	public static String longestPalindrome(String s) {
		if (s == null || s.length() == 0)
			return "";

		String longest = "";
		boolean[][] matrix = new boolean[s.length()][s.length()];

		// initialize
		for (int i = 0; i < s.length(); i++)
			matrix[i][i] = true;

		for (int i = 1; i < s.length(); i++) {
			for (int row = 0; row < s.length(); row++)
				if (s.charAt(row) == s.charAt(i) && matrix[row + 1][i - 1]) {
					matrix[i][row] = true;
					String sub = s.substring(i, row + 1);
					if (sub.length() > longest.length()) {
						longest = sub;
					} else {
						matrix[i][row] = false;
					}
				}
		}
		return longest;
	}
}