/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.18
 Problem : https://leetcode.com/problems/minimum-path-sum/
 ==========================================================
 */
public class Solution {
	/*
	 * Given a m x n grid filled with non-negative numbers, find a path from top
	 * left to bottom right which minimizes the sum of all numbers along its
	 * path.
	 * 
	 * Note: You can only move either down or right at any point in time.
	 */
	public static void main(String[] args) {
		// int[][] grid = {{1, 4, 5}, {2, 5, 6}, {5, 2, 1}};
		int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
		System.out.println("minPathSum " + minPathSum(grid));
		printMatrix(grid);
	}

	public static int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0)
			return -1;
		int col = grid[0].length;
		int row = grid.length;

		// Initialize the values on first row and col
		for (int i = 1; i < col; i++) {
			grid[0][i] += grid[0][i - 1];
		}

		for (int i = 1; i < row; i++) {
			grid[i][0] += grid[i - 1][0];
		}

		// Find the minimum sum on the path
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
			}
		}

		return grid[col - 1][row - 1];
	}

	public static void printMatrix(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

}
