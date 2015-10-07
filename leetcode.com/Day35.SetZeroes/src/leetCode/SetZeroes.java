package leetCode;

import java.util.BitSet;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.10.07
 Question Number : 136
 Link : https://leetcode.com/problems/set-matrix-zeroes/
 ==========================================================
 */

public class SetZeroes {
	/*
	 * Given a m x n matrix, if an element is 0, set its entire row and column
	 * to 0. Do it in place.
	 * 
	 * click to show follow up.
	 * 
	 * Follow up: Did you use extra space? A straight forward solution using
	 * O(mn) space is probably a bad idea. A simple improvement uses O(m + n)
	 * space, but still not the best solution. Could you devise a constant space
	 * solution?
	 */
	public static void main(String[] args) {
		int[][] matrix = {{1, 1, 1, 1, 0}, {1, 1, 1, 0, 1}, {1, 1, 1, 1, 1},
				{0, 1, 1, 1, 1}, {1, 1, 1, 1, 1}};
		printArray(matrix);
		setZeroes(matrix);
		printArray(matrix);
	}

	public static void setZeroesBitSet(int[][] matrix) {
		// Use the bitsets to store of existence of 0 in given array. It uses a
		// constant space because it uses the bit operations.
		BitSet bitsCol = new BitSet();
		BitSet bitsRow = new BitSet();

		// Find 0 in the matrix
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					bitsCol.set(j);
					bitsRow.set(i);
				}
			}
		}

		// Set 0 entire row and column if an element is 0
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (bitsCol.get(j) || bitsRow.get(i)) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	public static void setZeroes(int[][] matrix) {
		boolean firstRowZero = false;
		boolean firstColumnZero = false;

		// Set the variables when there are 0 in first row and column.
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				firstColumnZero = true;
				break;
			}
		}

		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i] == 0) {
				firstRowZero = true;
				break;
			}
		}

		// Find 0 in the matrix except first row and column and if there is 0
		// then marks into first row and column.
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		// Set 0 entire row and column if first row and column values are 0
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		// Set 0 entire row and column if the variables are 0
		if (firstColumnZero) {
			for (int i = 0; i < matrix.length; i++)
				matrix[i][0] = 0;
		}

		if (firstRowZero) {
			for (int i = 0; i < matrix[0].length; i++)
				matrix[0][i] = 0;
		}

	}

	// Prints the matrix
	private static void printArray(int[][] matrix) {
		System.out.println("printArray");
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}