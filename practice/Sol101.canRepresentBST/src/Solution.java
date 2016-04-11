/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.05
 Problem : http://www.geeksforgeeks.org/check-if-a-given-array-can-represent-preorder-traversal-of-binary-search-tree/
 ==========================================================
 */
public class Solution {
	/*
	 * Given an array of numbers, return true if given array can represent
	 * preorder traversal of a Binary Search Tree, else return false. Expected
	 * time complexity is O(n).
	 * 
	 * Examples: Input: pre[] = {2, 4, 3} Output: true Given array can represent
	 * preorder traversal of below tree 2 \ 4 / 3
	 * 
	 * Input: pre[] = {2, 4, 1} Output: false Given array cannot represent
	 * preorder traversal of a Binary Search Tree.
	 * 
	 * Input: pre[] = {40, 30, 35, 80, 100} Output: true Given array can
	 * represent preorder traversal of below tree 40 / \ 30 80 \ \ 35 100
	 * 
	 * Input: pre[] = {40, 30, 35, 20, 80, 100} Output: false Given array cannot
	 * represent preorder traversal of a Binary Search Tree.
	 */
	public static void main(String[] args) {
		int[] preorder1 = {2, 4, 3};
		System.out.println("canBuildTree " + canBuildTree(preorder1));
		int[] preorder2 = {2, 4, 1};
		System.out.println("canBuildTree " + canBuildTree(preorder2));
		int[] preorder3 = {40, 30, 35, 80, 100};
		System.out.println("canBuildTree " + canBuildTree(preorder3));
		int[] preorder4 = {40, 30, 35, 20, 80, 100};
		System.out.println("canBuildTree " + canBuildTree(preorder4));
	}

	public static class Range {
		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		public Range() {
		}

		public Range(int min, int max) {
			this.max = max;
			this.min = min;
		}
	}

	public static boolean canBuildTree(int[] array) {
		Range range = new Range();
		return helper(array, 0, array.length - 1, 0, range);
	}

	public static boolean helper(int[] array, int left, int right, int index,
			Range range) {
		if (left > right || index >= array.length)
			return true;

		int value = array[index];
		int mid = left;

		for (; mid <= right; mid++) {
			if (value < array[mid])
				break;
		}

		// Remain elements are less than mid value
		for (int i = mid; i < right; i++) {
			if (array[mid] > array[i]) {
				return false;
			}
		}

		if (value > range.min && value < range.max) {
			Range leftRange = new Range(range.min, value);
			Range rightRange = new Range(value, range.max);
			return helper(array, left + 1, mid - 1, index + 1, leftRange)
					&& helper(array, mid, right, index + (mid - left),
							rightRange);
		}
		return false;
	}
}
