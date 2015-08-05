package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.08.05
 Question Number : 25
 Link : https://leetcode.com/problems/search-a-2d-matrix-ii/
 ==========================================================
 */

public class Searcha2DMatrix2 {

	/*
	 * Write an efficient algorithm that searches for a value in an m x n
	 * matrix. This matrix has the following properties:
	 * 
	 * Integers in each row are sorted in ascending from left to right. Integers
	 * in each column are sorted in ascending from top to bottom. For example,
	 * 
	 * Consider the following matrix:
	 * 
	 * [ [1, 4, 7, 11, 15], 
	 * [2, 5, 8, 12, 19], 
	 * [3, 6, 9, 16, 22], 
	 * [10, 13, 14, 17, 24], 
	 * [18, 21, 23, 26, 30] ] 
	 * 
	 * Given target = 5, return true. 
	 * Given target = 20, return false.
	 */
	
	public static void main(String[] args) {
		int[][] matrix = 	 {{1, 4, 7, 11, 15}, 
		                 		  {2, 5, 8, 12, 19}, 
		                 		  {3, 6, 9, 16, 22}, 
		                 	  {10, 13, 14, 17, 24}, 
		                 	  {18, 21, 23, 26, 30}};
		System.out.println("searchMatrix " + searchMatrix(matrix, 20));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		// binary search를 이용한다 
		int start = 0, end = matrix[0].length;
		int row = 0, col = 0;
		
		while(start <= end) {
			int index = binarySearchinRow(matrix, target, start, end, row);
			
			if(matrix[row][index] == target) {
				return true;
			}
			
			col = index;
			end = index;
			
			index = binarySearchinCol(matrix, target, start, end, col);
			if(matrix[index][col] == target) {
				return true;
			}
			row = index;			
			start = index;
		}
		return false;
	}
	
	// Finds a target in row
	public static int binarySearchinRow(int[][] matrix, int target, int start,
			int end, int row) {
		while (start < end) {
			int mid = (start + end) / 2;
			if (matrix[row][mid] == target) {
				return mid;
			} else if (matrix[row][mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return end;
	}

	// Finds a target in column
	public static int binarySearchinCol(int[][] matrix, int target, int start,
			int end, int col) {
		while (start < end) {
			int mid = (start + end) / 2;
			if (matrix[mid][col] == target) {
				return mid;
			} else if (matrix[mid][col] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return end;
	}
}
