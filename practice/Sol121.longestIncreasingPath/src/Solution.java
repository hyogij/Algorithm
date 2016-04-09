import java.util.Arrays;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.09
 Link : https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 ==========================================================
 */
public class Solution {
	/*
	 * Given an integer matrix, find the length of the longest increasing path.
	 * 
	 * From each cell, you can either move to four directions: left, right, up
	 * or down. You may NOT move diagonally or move outside of the boundary
	 * (i.e. wrap-around is not allowed).
	 * 
	 * Example 1:
	 * 
	 * nums = [ [9,9,4], [6,6,8], [2,1,1] ] Return 4 The longest increasing path
	 * is [1, 2, 6, 9].
	 * 
	 * Example 2:
	 * 
	 * nums = [ [3,4,5], [3,2,6], [2,2,1] ] Return 4 The longest increasing path
	 * is [3, 4, 5, 6]. Moving diagonally is not allowed.
	 * 
	 */
	public static void main(String[] args) {
		int[][] nums1 = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
		int[][] nums2 = { { 3, 4, 5 }, { 3, 2, 6 }, { 2, 2, 1 } };
		System.out.println(longestIncreasingPath(nums1));
	}

	public static int longestIncreasingPath(int[][] matrix) {
		int[] height = { 0 };
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return height[0];

		int max = 1;
		int[][] cache = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				int current = helper(matrix, i, j, cache, matrix[i][j]);
				max = Math.max(max, current);
			}
		}

		return max;
	}

	public static final int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	public static int helper(int[][] matrix, int row, int col, int[][] cache, int current) {
		if (cache[row][col] != 0)
			return cache[row][col];

		int max = 1;
		for (int i = 0; i < dirs.length; i++) {
			int x = row + dirs[i][0];
			int y = col + dirs[i][1];

			if (isValid(matrix, x, y) && matrix[x][y] > current) {
				int len = helper(matrix, x, y, cache, matrix[x][y]) + 1;
				max = Math.max(max, len);
			}
		}
		cache[row][col] = max;
		return max;
	}

	public static boolean isValid(int[][] matrix, int row, int col) {
		if (row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length)
			return true;
		return false;
	}
}
