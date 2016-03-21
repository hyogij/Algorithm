/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.21
 Problem : http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
 ==========================================================
 */
public class Solution {
	/*
	 * We have discussed Overlapping Subproblems and Optimal Substructure
	 * properties in Set 1 and Set 2 respectively. We also discussed one example
	 * problem in Set 3. Let us discuss Longest Common Subsequence (LCS) problem
	 * as one more example problem that can be solved using Dynamic Programming.
	 * 
	 * LCS Problem Statement: Given two sequences, find the length of longest
	 * subsequence present in both of them. A subsequence is a sequence that
	 * appears in the same relative order, but not necessarily contiguous. For
	 * example, ¡°abc¡±, ¡°abg¡±, ¡°bdf¡±, ¡°aeg¡±, ¡®¡±acefg¡±, .. etc are subsequences of
	 * ¡°abcdefg¡±. So a string of length n has 2^n different possible
	 * subsequences.
	 * 
	 * It is a classic computer science problem, the basis of diff (a file
	 * comparison program that outputs the differences between two files), and
	 * has applications in bioinformatics.
	 * 
	 * Examples: 
	 * LCS for input Sequences ¡°ABCDGH¡± and ¡°AEDFHR¡± is ¡°ADH¡± of length 3. 
	 * LCS for input Sequences ¡°AGGTAB¡± and ¡°GXTXAYB¡± is ¡°GTAB¡± of length 4.
	 */
	public static void main(String[] args) {
		System.out.println("longestCommonSubsequence "
				+ longestCommonSubsequence("ABCDGH", "AEDFHR"));

		System.out.println("longestCommonSubsequence "
				+ longestCommonSubsequence("AGGTAB", "GXTXAYB"));
	}

	// Use 2d matrix to store the number of common string
	public static int longestCommonSubsequence(String x, String y) {
		if (x == null || x.length() == 0)
			return 0;
		if (y == null || y.length() == 0)
			return 0;

		int[][] mat = new int[y.length() + 1][x.length() + 1];
		for (int i = 1; i < mat.length; i++) {
			char c1 = y.charAt(i - 1);
			for (int j = 1; j < mat[i].length; j++) {
				char c2 = x.charAt(j - 1);
				if (c1 != c2) {
					mat[i][j] = Math.max(mat[i - 1][j], mat[i][j - 1]);
				} else {
					mat[i][j] = mat[i - 1][j - 1] + 1;
				}
			}
		}
		
		return mat[y.length()][x.length()];
		
		
		
		
	}
}