package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.09.11
 Question Number : 113
 Link : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 ==========================================================
 */

public class FindMinDuplicated {
	/*
	 * Follow up for "Find Minimum in Rotated Sorted Array": What if duplicates
	 * are allowed?
	 * 
	 * Would this affect the run-time complexity? How and why? Suppose a sorted
	 * array is rotated at some pivot unknown to you beforehand.
	 * 
	 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	 * 
	 * Find the minimum element. The array may contain duplicates.
	 */
	public static void main(String[] args) {
		// int[] A = {5, 6, 7, 7, 8, 10, 11, 11, 11, 11, 11, 11, 11, 11, 0, 0,
		// 1,
		// 1, 1, 1, 1, 2, 2, 2, 3, 4, 5, 5};
		// int[] A = {5,1,2,3,4};
		// int[] A = {3, 3, 1};
		// int[] A = {10, 1, 10, 10, 10};
		int[] A = {2, 2, 2, 3, 3, 1};
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
		} else if (nums[left] == nums[mid]) {
			return findMinHelper(nums, left + 1, right);
			// We can use below expression but it is not effective than above
			// algorithm.
			// return Math.min(findMinHelper(nums, mid + 1, right),
			// findMinHelper(nums, left, mid));
		} else {
			return findMinHelper(nums, left, mid);
		}
	}
}
