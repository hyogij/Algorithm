import java.util.Stack;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.22
 Problem : https://leetcode.com/problems/largest-rectangle-in-histogram/
 ==========================================================
 */
public class Solution {
	/*
	 * Given n non-negative integers representing the histogram's bar height
	 * where the width of each bar is 1, find the area of largest rectangle in
	 * the histogram.
	 * 
	 * Above is a histogram where width of each bar is 1, given height =
	 * [2,1,5,6,2,3]. The largest rectangle is shown in the shaded area, which
	 * has area = 10 unit.
	 * 
	 * For example, Given heights = [2,1,5,6,2,3], return 10.
	 */
	public static void main(String[] args) {
		int[] heights = {2, 1, 5, 6, 2, 3};
		System.out.println("largestRectangleArea "
				+ largestRectangleArea(heights));

		int[] heights1 = {1};
		System.out.println("largestRectangleArea "
				+ largestRectangleArea(heights1));
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
