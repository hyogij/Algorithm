package leetCode;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/*
==========================================================
Author : Hyogi Jung(hyogij@gmail.com)
Date : 2015.07.03
Question Number : 7
Link : https://leetcode.com/problems/spiral-matrix/
==========================================================
*/
public class SpiralMatrix {
	/*
	 * Given a matrix of m x n elements (m rows, n columns), return all elements
	 * of the matrix in spiral order.
	 * 
	 * For example, Given the following matrix: 
	 * [ [ 1, 2, 3 ], 
	 *   [ 4, 5, 6 ], 
	 *   [ 7, 8, 9 ] ] 
	 * You should return [1,2,3,6,9,8,7,4,5].
	 */
	public static void main(String[] args) {
		int[][] matrix = {{1, 2, 3}};
		List<Integer> list = spiralOrder(matrix);
		System.out.println("list = " + list.toString());
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i <= matrix.length / 2; i++) {
			Point leftUp = new Point(i, i);
			Point rightDown = new Point(matrix.length - i - 1, matrix[0].length
					- i - 1);
			spiralOrderHelper(matrix, leftUp, rightDown, list);
		}

		return list;
	}

	public static void spiralOrderHelper(int[][] matrix, Point leftUp,
			Point rightDown, List<Integer> list) {

		// Adds elements from left-up to right-up
		for (int i = leftUp.x, j = leftUp.y; j <= rightDown.y; j++) {
			list.add(matrix[i][j]);
		}
		// Adds elements from right-up to right-down
		for (int i = leftUp.x + 1, j = rightDown.y; i <= rightDown.x; i++) {
			list.add(matrix[i][j]);
		}
		// Adds elements from right-down to left-down
		for (int i = rightDown.x, j = rightDown.y - 1; j >= leftUp.y
				&& i != leftUp.y; j--) {
			list.add(matrix[i][j]);
		}
		// Adds elements from left-down to left-up
		for (int i = rightDown.x - 1, j = leftUp.y; i > leftUp.x; i--) {
			list.add(matrix[i][j]);
		}
	}
}
