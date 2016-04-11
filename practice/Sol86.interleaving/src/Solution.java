import java.util.Arrays;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.01
 Problem : https://leetcode.com/problems/interleaving-string/
 ==========================================================
 */
public class Solution {
	/*
	 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and
	 * s2.
	 * 
	 * For example, Given: s1 = "aabcc", s2 = "dbbca", When s3 = "aadbbcbcac",
	 * return true. When s3 = "aadbbbaccc", return false.
	 */
	public static void main(String[] args) {
		System.out.println("isInterleave "
				+ isInterleave("abc", "axz", "aabxzc"));
		System.out.println("isInterleave "
				+ isInterleave("abk", "axz", "aabxzc"));
		System.out.println("isInterleave "
				+ isInterleave("aabcc", "dbbca", "aadbbcbcac"));
		System.out.println("isInterleave "
				+ isInterleave("a", "a", "b"));
		System.out.println("isInterleave "
				+ isInterleave("aabc", "abad", "aabadabc"));
	}

	public static boolean isInterleave(String s1, String s2, String s3) {
		if(s1 == null || s2 == null || s3 == null)
			return false;
			
		if(s1.length() + s2.length() != s3.length())
			return false;
		
		boolean[][] matrix = new boolean[s1.length() + 1][s2.length() + 1];

		// Initialize first col
		matrix[0][0] = true;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == s3.charAt(i))
				matrix[i + 1][0] = true;
		}

		// Initialize first row
		for (int i = 0; i < s2.length(); i++) {
			if (s2.charAt(i) == s3.charAt(i))
				matrix[0][i + 1] = true;
		}

		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s3.charAt(i + j - 1))
					matrix[i][j] = matrix[i - 1][j];
				else if (s2.charAt(j - 1) == s3.charAt(i + j - 1))
					matrix[i][j] = matrix[i][j - 1];
			}
		}

		print2dArray(matrix);
		
		return matrix[s1.length()][s2.length()];
	}

	private static void print2dArray(boolean[][] matrix) {
		for (boolean[] row : matrix) {
			System.out.println(Arrays.toString(row));
		}
	}
}
