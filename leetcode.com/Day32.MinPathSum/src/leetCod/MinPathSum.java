package leetCod;

import java.util.Arrays;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.10.05
 Question Number : 130
 Link : https://leetcode.com/problems/minimum-path-sum/
 ==========================================================
 */
public class MinPathSum {
	/*
	 * Given a m x n grid filled with non-negative numbers, find a path from top
	 * left to bottom right which minimizes the sum of all numbers along its
	 * path.
	 * 
	 * Note: You can only move either down or right at any point in time.
	 */
	public static void main(String[] args) {
		int[][] grid = {{1, 1, 2, 3, 4}, {1, 1, 2, 3, 4}, {1, 1, 2, 3, 4}};
		System.out.println("minPathSum " + minPathSum(grid));
	}

	// Find a minimum path sum from bottom right to top left.
	public static int minPathSum(int[][] grid) {
		if (grid.length == 0 || (grid.length != 0 && grid[0].length == 0)) {
			return -1;
		}

		// First, calculate the border lines path sum in grid array
		// From bottom right to top right
		for (int i = grid.length - 2; i >= 0; i--) {
			grid[i][grid[i].length - 1] += grid[i + 1][grid[i + 1].length - 1];
		}
		// From bottom right to bottom left
		for (int i = grid[grid.length - 1].length - 2; i >= 0; i--) {
			grid[grid.length - 1][i] += grid[grid.length - 1][i + 1];
		}

		// Second, choose the minimum path between right path or down path in
		// certain position
		for (int i = grid.length - 2; i >= 0; i--) {
			for (int j = grid[i].length - 2; j >= 0; j--) {
				grid[i][j] += Math.min(grid[i + 1][j], grid[i][j + 1]);
			}
		}

		for (int i = 0; i < grid.length; i++) {
			System.out.println(Arrays.toString(grid[i]));
		}
		return grid[0][0];
	}
}