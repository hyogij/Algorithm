
/*
==========================================================
Author : Hyogi Jung(hyogij@gmail.com)
Date : 2016.04.13
Problem : http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/
==========================================================
*/
public class Solution {
	/*
	 * Given a sequence, find the length of the longest palindromic subsequence
	 * in it. For example, if the given sequence is “BBABCBCAB”, then the output
	 * should be 7 as “BABCBAB” is the longest palindromic subseuqnce in it.
	 * “BBBBB” and “BBCBB” are also palindromic subsequences of the given
	 * sequence, but not the longest ones.
	 */
	public static void main(String[] args) {
		System.out.println("lps " + lps("BBABCBCAB"));
		System.out.println("lps " + lps("BBABCB"));
		System.out.println("lps " + lps("BBCBB"));
		System.out.println("lps " + lps("BBBB"));
	}

	public static int lps(String txt) {
		if (txt == null || txt.length() == 0) {
			return 0;
		}

		int length = txt.length();
		int[][] matrix = new int[length][length];

		// Initialize when length is 0
		for (int i = 0; i < length; i++) {
			matrix[i][i] = 1;
		}

		for (int len = 2; len <= length; len++) {
			for (int row = 0; row < length - len + 1; row++) {
				int col = row + len - 1;
				if (txt.charAt(row) == txt.charAt(col)) {
					if (len == 2) {
						matrix[row][col] = 2;
					} else {
						matrix[row][col] = matrix[row + 1][col - 1] + 2;
					}
				} else {
					matrix[row][col] = Math.max(matrix[row + 1][col], matrix[row][col - 1]);
				}
			}
		}
		return matrix[0][length - 1];
	}
}
