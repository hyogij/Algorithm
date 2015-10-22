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
	 * [ 
	 * [1, 4, 7, 11, 15], 
	 * [2, 5, 8, 12, 19], 
	 * [3, 6, 9, 16, 22], 
	 * [5, 7, 10, 17, 24], 
	 * [18, 21, 23, 26, 30] 
	 * ] 
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
		System.out.println("searchMatrix " + searchMatrix(matrix, 5));
		System.out.println("searchMatrix " + searchMatrix(matrix, 12));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) {
			return false;
		}

		return searchHelper(matrix, target, 0, 0, matrix.length - 1,
				matrix[0].length - 1);
	}
	
	public static boolean searchHelper(int[][] matrix, int target, int leftX,
			int leftY, int rightX, int rightY) {

		int xMid = (leftX + rightX) / 2;
		int yMid = (leftY + rightY) / 2;

		if (leftX == rightX && leftY == rightY) {
			return matrix[xMid][yMid] == target;
		}
		if (leftX > rightX || leftY > rightY) {
			return false;
		}

		if (matrix[xMid][yMid] == target) {
			return true;
		}

		int nextXMid = xMid + 1;
		int nextYMid = yMid + 1;

		return searchHelper(matrix, target, leftX, leftY, xMid, yMid)
				|| searchHelper(matrix, target, leftX, nextYMid, xMid, rightY)
				|| searchHelper(matrix, target, nextXMid, leftY, rightX, rightY);
	}
}
