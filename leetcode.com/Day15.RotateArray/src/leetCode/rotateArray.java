package leetCode;


/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.08.07
 Question Number : 62
 Link : https://leetcode.com/problems/rotate-array/
 ==========================================================
 */

public class rotateArray {
	/*
	 * Rotate an array of n elements to the right by k steps.
	 * 
	 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated
	 * to [5,6,7,1,2,3,4].
	 * 
	 * Note: Try to come up as many solutions as you can, there are at least 3
	 * different ways to solve this problem.
	 * 
	 * [show hint]
	 * 
	 * Hint: Could you do it in-place with O(1) extra space? Related problem:
	 * Reverse Words in a String II
	 */
	public static void main(String[] args) {
		int[] nums = {1, 2};
		rotate(nums, 3);
	}

	public static void rotate(int[] nums, int k) {
		if (nums.length <= 1) {
			return;
		}

		// If k is bigger than length of array, then modifies rotate number of k
		if (nums.length < k) {
			k = k % nums.length;
		}

		rotateHelper(nums, 0, nums.length - 1);
		rotateHelper(nums, 0, k - 1);
		rotateHelper(nums, k, nums.length - 1);
	}

	public static void rotateHelper(int[] nums, int left, int right) {
		if (left >= right) {
			return;
		}

		for (int i = 0; i <= (right - left) / 2; i++) {
			int tmp = nums[left + i];
			nums[left + i] = nums[right - i];
			nums[right - i] = tmp;
		}
	}

	public static void printArray(int[] nums) {
		for (int num : nums) {
			System.out.print(" " + num);
		}
		System.out.println();
	}
}
