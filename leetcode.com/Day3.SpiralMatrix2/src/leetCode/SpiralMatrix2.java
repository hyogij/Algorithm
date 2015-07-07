package leetCode;

import java.util.Arrays;

/*
==========================================================
Author : Hyogi Jung(hyogij@gmail.com)
Date : 2015.07.07
Question Number : 15
Link : https://leetcode.com/problems/spiral-matrix-ii/
==========================================================
*/
public class SpiralMatrix2 {
	/*
	 * Given an integer n, generate a square matrix filled with elements from 1
	 * to n2 in spiral order.
	 * 
	 * For example, Given n = 3,
	 * 
	 * You should return the following matrix: 
	 * [ [ 1, 2, 3 ], 
	 *   [ 8, 9, 4 ], 
	 *   [ 7, 6, 5 ] ]
	 */
	public static void main(String[] args) {
		int[][] matrix = generateMatrix(5);
		if(matrix != null) {
			System.out.println(Arrays.deepToString(matrix));
		}
	}

	public static int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		int count = 1;
		
		if (n == 0) {
			return new int[0][0];
		} else if (n == 1) {
			matrix[0][0] = count;
			return matrix;
		} else {
			for (int i = 0; i <= n / 2; i++) {
				count = generateMatrixHelper(matrix, i, n, count);
			}
			return matrix;
		}
	}

	public static int generateMatrixHelper(int[][] matrix, int index, int n,
			int count) {
		// from upper left to upper right
		for (int i = index; i < n - index; i++) {
			matrix[index][i] = count++;
		}
		// from upper right to lower right
		for (int i = index + 1; i < n - index; i++) {
			matrix[i][n - index - 1] = count++;
		}
		// from lower right to lower left
		for (int i = n - index - 2; i >= index; i--) {
			matrix[n - index - 1][i] = count++;
		}
		// from lower left to upper left
		for (int i = n - index - 2; i > index; i--) {
			matrix[i][index] = count++;
		}
		return count;
	}
}