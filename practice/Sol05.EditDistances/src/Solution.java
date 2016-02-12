/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.02.12
 Question Number : 05
 Link : https://leetcode.com/problems/edit-distance/
http://www.programcreek.com/2013/12/edit-distance-in-java/
 ==========================================================
 */
public class Solution {
	public static void main(String[] args) {
		System.out.println("minDistance : " + minDistance("abc", "dec"));
		System.out.println("minDistance : " + minDistance("sitten", "sitti"));
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
