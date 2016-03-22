import java.util.Arrays;
import java.util.Stack;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.22
 Problem : https://leetcode.com/problems/maximal-rectangle/
 ==========================================================
 */
public class Solution {
	/*
	 * Given a 2D binary matrix filled with 0's and 1's, find the largest
	 * rectangle containing all ones and return its area.
	 */
	public static void main(String[] args) {
		char[][] matrix1 = {{'0', '1', '0', '0', '0'},
				{'0', '1', '0', '1', '0'}, {'1', '1', '1', '1', '0'},
				{'1', '1', '1', '1', '0'}, {'0', '1', '1', '0', '1'}};
		System.out.println("largestRectangleArea " + maximalRectangle(matrix1));

		char[][] matrix2 = {{'0', '0', '0', '0', '0'},
				{'0', '0', '0', '0', '0'}, {'0', '0', '1', '1', '0'},
				{'0', '0', '1', '1', '0'}, {'0', '0', '1', '1', '0'}};
		System.out.println("largestRectangleArea " + maximalRectangle(matrix2));
	}

	public static int maximalRectangle(char[][] matrix) {
		int max = 0;
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return max;

		int[] area = new int[matrix[0].length];
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				if (row == 0) {
					if (matrix[row][col] == '0')
						area[col] = 0;
					else
						area[col] = 1;
				} else {
					if (matrix[row][col] == '0')
						area[col] = 0;
					else
						area[col]++;
				}
			}
			max = Math.max(max, largestRectangleArea(area));
		}

		return max;
	}

	public static int largestRectangleArea(int[] heights) {
		int max = 0, area = 0, top = 0, height = 0;
		if (heights == null || heights.length == 0)
			return max;

		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i <= heights.length;) {

			if (i == heights.length)
				height = 0;
			else
				height = heights[i];

			if (stack.isEmpty() == true || heights[stack.peek()] <= height) {
				stack.push(i++);
				continue;
			}

			while (stack.isEmpty() != true && heights[stack.peek()] > height) {
				top = stack.pop();
				// Calculate area
				if (stack.isEmpty()) {
					area = heights[top] * i;
				} else {
					area = heights[top] * (i - stack.peek() - 1);
				}
				max = Math.max(area, max);
			}
		}

		return max;
	}
}
