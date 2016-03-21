/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.21
 Problem : http://www.geeksforgeeks.org/longest-common-substring/
 ==========================================================
 */
public class Solution {
	/*
	 * Given two strings ¡®X¡¯ and ¡®Y¡¯, find the length of the longest common
	 * substring. For example, if the given strings are "GeeksforGeeks" and
	 * "GeeksQuiz", the output should be 5 as longest common substring is
	 * "Geeks"
	 */
	public static void main(String[] args) {
		System.out.println("longestCommonString "
				+ longestCommonString("GeeksforGeeks", "GeeksQuiz"));

		System.out.println("longestCommonString "
				+ longestCommonString("Hellonewworld", "GoodbyenewwKorea"));
	}

	// Use 2d matrix to store the number of common string
	public static int longestCommonString(String x, String y) {
		if (x == null || x.length() == 0)
			return 0;
		if (y == null || y.length() == 0)
			return 0;

		int max = 0;
		int[][] mat = new int[y.length() + 1][x.length() + 1];
		for (int i = 1; i < mat.length; i++) {
			char c1 = y.charAt(i - 1);
			for (int j = 1; j < mat[i].length; j++) {
				char c2 = x.charAt(j - 1);
				if (c1 != c2) {
					mat[i][j] = 0;
				} else {
					mat[i][j] = Math.max(mat[i - 1][j], mat[i - 1][j - 1] + 1);
					max = Math.max(max, mat[i][j]);
				}
			}

		return max;
	}
}
