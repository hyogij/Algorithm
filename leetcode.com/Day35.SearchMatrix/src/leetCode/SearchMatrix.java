package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.10.07
 Question Number : 138
 Link : https://leetcode.com/problems/search-a-2d-matrix/
 ==========================================================
 */

public class SearchMatrix {
	/*
	 * Write an efficient algorithm that searches for a value in an m x n
	 * matrix. This matrix has the following properties:
	 * 
	 * Integers in each row are sorted from left to right. The first integer of
	 * each row is greater than the last integer of the previous row. For
	 * example,
	 * 
	 * Consider the following matrix:
	 * 
	 * [ [1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50] ]
	 * 
	 * Given target = 3, return true.
	 */
	public static void main(String[] args) {
		int[][] matrix = {{1, 3, 5, 7}};
		// , {10, 11, 16, 20}, {23, 30, 34, 50}};

		System.out.println("searchMatrix : " + searchMatrix(matrix, 1));
		System.out.println("searchMatrix : " + searchMatrix(matrix, 2));
		System.out.println("searchMatrix : " + searchMatrix(matrix, 3));
		System.out.println("searchMatrix : " + searchMatrix(matrix, 7));
		System.out.println("searchMatrix : " + searchMatrix(matrix, 8));
		System.out.println("searchMatrix : " + searchMatrix(matrix, 22));
		System.out.println("searchMatrix : " + searchMatrix(matrix, 24));
		System.out.println("searchMatrix : " + searchMatrix(matrix, 34));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0) {
			return false;
		}

		for (int i = 0; i < matrix.length; i++) {
			// Compare the target with right side of matrix
			if (target == matrix[i][matrix[i].length - 1]) {
				return true;
			} else if (target < matrix[i][matrix[i].length - 1]) {
				// If the target value is less than element in certain row, then
				// find that row.
				return binarySearch(matrix, i, target);
			}
		}
		return false;
	}

	public static boolean binarySearch(int[][] matrix, int row, int target) {
		int left = 0, right = matrix[row].length - 1;
		while (left <= right) {
			int middle = (right - left) / 2 + left;
			if (target == matrix[row][middle]) {
				return true;
			} else if (target > matrix[row][middle]) {
				left = middle + 1;
			} else if (target < matrix[row][middle]) {
				right = middle - 1;
			}
		}
		return false;
	}
}
