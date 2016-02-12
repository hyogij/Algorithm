/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.02.12
 Question Number : 05
 Link : https://leetcode.com/problems/edit-distance/
 https://leetcode.com/problems/one-edit-distance
http://www.programcreek.com/2013/12/edit-distance-in-java/
https://segmentfault.com/a/1190000003906621
 ==========================================================
 */
public class Solution {
	public static void main(String[] args) {
		System.out.println("minDistance : " + minDistance("abc", "dec"));
		System.out.println("minDistance : " + minDistance("sitten", "sitti"));
		System.out.println("isOneEditDistance : "
				+ isOneEditDistance("sitten", "sitti"));
		System.out.println("isOneEditDistance : "
				+ isOneEditDistance("sitten", "sitte"));
		System.out.println("isOneEditDistance : "
				+ isOneEditDistance("sitten", "sitted"));
		System.out.println("isOneEditDistance : "
				+ isOneEditDistance("siten", "sitten"));
		System.out.println("isOneEditDistance : "
				+ isOneEditDistance("siten", "sitken"));
		System.out.println("isOneEditDistance : "
				+ isOneEditDistance("siten", "sikken"));
	}

	// Given two strings S and T, determine if they are both one edit distance
	// apart.
	public static boolean isOneEditDistance(String s, String t) {
		if (s == null || t == null) {
			return false;
		}

		if (Math.abs(s.length() - t.length()) > 1) {
			return false;
		}

		if (s.length() == t.length()) {
			return modifyOneCharacter(s, t);
		}
		if (s.length() > t.length()) {
			return deleteOneCharacter(s, t);
		} else {
			return deleteOneCharacter(t, s);
		}
	}

	private static boolean modifyOneCharacter(String s, String t) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char s1 = s.charAt(i);
			char t1 = t.charAt(i);
			if (s1 != t1) {
				count++;
			}
		}

		if (count <= 1) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean deleteOneCharacter(String s, String t) {
		// s is longer than t
		for (int i = 0; i < t.length(); i++) {
			char s1 = s.charAt(i);
			char t1 = t.charAt(i);
			if (s1 != t1) {
				if (t.substring(i).equals(s.substring(i + 1))) {
					return true;
				} else {
					return false;
				}
			}
		}
		return true;
	}

	public static int minDistance(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();

		// len1+1, len2+1, because finally return dp[len1][len2]
		int[][] dp = new int[len1 + 1][len2 + 1];

		for (int i = 0; i <= len1; i++) {
			dp[i][0] = i;
		}

		for (int j = 0; j <= len2; j++) {
			dp[0][j] = j;
		}

		// Iterate though, and check last char
		for (int i = 0; i < len1; i++) {
			char c1 = word1.charAt(i);
			for (int j = 0; j < len2; j++) {
				char c2 = word2.charAt(j);

				// If last two chars equal
				if (c1 == c2) {
					// Update dp value for +1 length
					dp[i + 1][j + 1] = dp[i][j];
				} else {
					int replace = dp[i][j] + 1;
					int insert = dp[i][j + 1] + 1;
					int delete = dp[i + 1][j] + 1;

					dp[i + 1][j + 1] = Math.min(Math.min(replace, insert),
							delete);
				}
			}
		}

		return dp[len1][len2];
	}
}
