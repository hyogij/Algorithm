/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.25
 Problem : https://leetcode.com/problems/search-a-2d-matrix-ii/
 http://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/
 http://articles.leetcode.com/searching-2d-sorted-matrix-part-ii
 ==========================================================
 */
public class Solution {
	/*
	 * Write an efficient algorithm that searches for a value in an m x n
	 * matrix. This matrix has the following properties:
	 * 
	 * Integers in each row are sorted in ascending from left to right. Integers
	 * in each column are sorted in ascending from top to bottom. For example,
	 * 
	 * Consider the following matrix:
	 * 
	 * [ [ 1, 4, 7, 11, 15], [ 2, 5, 8, 12, 19], [ 3, 6, 9, 16, 22], [10, 13,
	 * 14, 17, 24], [18, 21, 23, 26, 30] ]
	 * 
	 * Given target = 5, return true. Given target = 20, return false.
	 */
	public static void main(String[] args) {
		int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19},
				{3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};

		System.out.println("searchMatrix : " + searchMatrix(matrix, 5));
		System.out.println("searchMatrix : " + searchMatrix(matrix, 9));
		System.out.println("searchMatrix : " + searchMatrix(matrix, 22));
		System.out.println("searchMatrix : " + searchMatrix(matrix, 21));
		System.out.println("searchMatrix : " + searchMatrix(matrix, 30));
	}

	// 대각선에 있는 값은 해당 영역에서 가장 큰 값이다.
	// 대각선으로 하면, 왼쪽으로 긴 matrix는 범위가 크게 줄어들지 않으니 문제가 될 수 있다.
	// 재귀적으로 만든다. 시작 위치와 끝 위치가 주어지면, 어느 부분을 제외해야 하는지 알 수 있다.
	public static boolean searchMatrix(int[][] matrix, int target) {
		return searchMatrixHelper(matrix, 0, 0, matrix.length,
				matrix[0].length, target);
	}

	public static boolean searchMatrixHelper(int[][] matrix, int top, int left,
			int bottom, int right, int target) {
		if (left >= right || top >= bottom)
			return false;

		int midx = (right - left) / 2 + left;
		int midy = (bottom - top) / 2 + top;

		if (matrix[midx][midy] == target)
			return true;
		else if (matrix[midx][midy] > target)
			return searchMatrixHelper(matrix, top, left, midy, midx, target)
					|| searchMatrixHelper(matrix, midy + 1, left, bottom, midx,
							target)
					|| searchMatrixHelper(matrix, top, midx + 1, midy - 1,
							right, target);
		else
			return searchMatrixHelper(matrix, midy + 1, midx + 1, midy, midx,
					target)
					|| searchMatrixHelper(matrix, midy + 1, left, bottom, midx,
							target)
					|| searchMatrixHelper(matrix, top, midx + 1, midy - 1,
							right, target);
	}
}