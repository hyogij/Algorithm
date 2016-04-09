import java.util.Arrays;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.09
 Link : https://leetcode.com/problems/maximum-product-subarray/
 ==========================================================
 */
public class Solution {
	/*
	 * Find the contiguous subarray within an array (containing at least one
	 * number) which has the largest product.
	 * 
	 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3]
	 * has the largest product = 6.
	 */
	public static void main(String[] args) {
		// int[] nums = { 2, 3, -2, 4, 2, 1, 5 };
		int[] nums = { 2, -5, -2, -4, 3 };
		System.out.println(maxProductNaive(nums));
		System.out.println(maxProduct(nums));
	}

	public static int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int min, max, global = 0;
		min = max = global = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int tmp = min;
			min = Math.min(Math.min(nums[i] * max, nums[i] * min), nums[i]);
			max = Math.max(Math.max(nums[i] * max, nums[i] * tmp), nums[i]);
			global = Math.max(max, global);
		}

		return global;
	}

	// Use 2d matrix to find the maximum product of continuous integers
	public static int maxProductNaive(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int max = Integer.MIN_VALUE;
		int[][] matrix = new int[nums.length][nums.length];

		// Initialize the value when length is 1
		for (int i = 0; i < nums.length; i++) {
			matrix[i][i] = nums[i];
			max = Math.max(max, matrix[i][i]);
		}

		for (int i = 1; i < nums.length; i++) {
			for (int row = 0; row < nums.length; row++) {
				int col = row + i;
				if (col < nums.length) {
					matrix[row][col] = matrix[row][col - 1] * nums[col];
					max = Math.max(max, matrix[row][col]);
				}
			}
		}

		return max;
	}
}
