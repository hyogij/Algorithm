package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.09.11
 Question Number : 113
 Link : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 ==========================================================
 */

public class FindMin {
	/*
	 * Suppose a sorted array is rotated at some pivot unknown to you
	 * beforehand.
	 * 
	 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	 * 
	 * Find the minimum element. You may assume no duplicate exists in the
	 * array.
	 */
	public static void main(String[] args) {
		// int[] A = {3, 4, 5, 6, 7, 8, 10, 11, 0, 1, 2};
		// int[] A = {5,1,2,3,4};
		int[] A = {1, 2};
		System.out.println("findMin " + findMin(A));
	}

	public static int findMin(int[] nums) {
		if (nums.length <= 1) {
			return nums[0];
		}
		return findMinHelper(nums, 0, nums.length - 1);
	}

	public static int findMinHelper(int[] nums, int left, int right) {
		int mid = (right - left) / 2 + left;

		if (left == right) {
			return nums[left];
		}
		if (right - left <= 1) {
			return nums[left] < nums[right] ? nums[left] : nums[right];
		}

		// If array is sorted, then return left element
		if (nums[left] < nums[right]) {
			return nums[left];
		}

		if (nums[left] < nums[mid]) {
			return findMinHelper(nums, mid + 1, right);
		} else {
			return findMinHelper(nums, left, mid);
		}
	}
}
