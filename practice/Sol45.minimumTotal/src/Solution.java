/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.18
 Problem : https://leetcode.com/problems/triangle/
 ==========================================================
 */
public class Solution {
	/*
	 * Given a triangle, find the minimum path sum from top to bottom. Each step
	 * you may move to adjacent numbers on the row below. For example, given the
	 * following triangle [ [2], [3,4], [6,5,7], [4,1,8,3] ] The minimum path
	 * sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
	 */
	public static void main(String[] args) {
		int[][] triangle = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
		System.out.println("minimumTotal " + minimumTotal(triangle));
	}

	public static int minimumTotal(int[][] triangle) {
		if (triangle == null || triangle.length == 0 || triangle[0].length == 0)
			return -1; // There is no path!

		int row = triangle.length;
		int col = triangle[triangle.length - 1].length;

		for (int i = 1; i < row; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					// First entry
					triangle[i][j] += triangle[i - 1][j];
				} else if (j == i) {
					// Last entry
					triangle[i][j] += triangle[i - 1][j - 1];
				} else {
					triangle[i][j] += Math.min(triangle[i - 1][j - 1],
							triangle[i - 1][j]);
				}
			}
		}

		// Find the minimum value in bottom line of a triangle
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < col; i++) {
			if (min > triangle[row - 1][i]) {
				min = triangle[row - 1][i];
			}
		}

		return min;
	}
}