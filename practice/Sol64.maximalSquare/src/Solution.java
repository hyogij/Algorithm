import java.util.Arrays;
import java.util.Stack;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.22
 Problem : https://leetcode.com/problems/maximal-square/
 ==========================================================
 */
public class Solution {
	/*
	 * Given a 2D binary matrix filled with 0's and 1's, find the largest square
	 * containing all 1's and return its area.
	 * 
	 * For example, given the following matrix:
	 * 
	 * 1 0 1 0 0 1 0 1 1 1 1 1 1 1 1 1 0 0 1 0 Return 4.
	 */
	public static void main(String[] args) {
		char[][] matrix1 = {{'0', '1', '0', '0', '0'},
				{'0', '1', '0', '1', '0'}, {'1', '1', '1', '1', '0'},
				{'1', '1', '1', '1', '0'}, {'0', '1', '1', '0', '1'}};
		System.out.println("maximalSquare " + maximalSquare(matrix1));

		char[][] matrix2 = {{'0', '0', '0', '0', '0'},
				{'0', '0', '0', '0', '0'}, {'0', '0', '1', '1', '0'},
				{'0', '0', '1', '1', '0'}, {'0', '0', '1', '1', '0'}};
		System.out.println("maximalSquare " + maximalSquare(matrix2));
	}

	public static int maximalSquare(char[][] matrix) {
		int max = 0;
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return max;

		int row = matrix.length, col = matrix[0].length;
		int[][] count = new int[row + 1][col + 1];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == '0') {
					count[i + 1][j + 1] = 0;
				} else {
					count[i + 1][j + 1] = Math.min(count[i][j],
							Math.min(count[i + 1][j], count[i][j + 1])) + 1;
				}
				max = Math.max(max, count[i + 1][j + 1]);
			}
		}
		return max * max;
	}
}
