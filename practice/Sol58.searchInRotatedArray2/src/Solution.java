/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.21
 Problem : https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 ==========================================================
 */
public class Solution {
	/*
	 * Suppose a sorted array is rotated at some pivot unknown to you
	 * beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). You are
	 * given a target value to search. If found in the array return its index,
	 * otherwise return -1. You may assume no duplicate exists in the array.
	 * What if duplicates are allowed?
	 */
	public static void main(String[] args) {
		int[] nums = {4, 5, 6, 7, 0, 1, 1, 1, 2, 2, 3, 3};
		System.out.println("search " + search(nums, 2));
		System.out.println("search " + search(nums, 10));
		System.out.println("search " + search(nums, 0));
		System.out.println("search " + search(nums, 6));

		int[] num1 = {1, 3, 1, 1, 1};
		System.out.println("search " + search(num1, 3));
		System.out.println("search " + search(num1, 1));
	}

	public static boolean search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return false;

		return helper(nums, 0, nums.length - 1, target);
	}

	public static boolean helper(int[] nums, int left, int right, int target) {
		if (left > right)
			return false;

		int mid = (right - left) / 2 + left;
		if (nums[mid] == target) {
			return true;
		}

		if (nums[left] <= nums[mid]) {
			// Left side is sorted
			if (nums[left] <= target && target < nums[mid])
				return helper(nums, left, mid - 1, target);
			else
				return helper(nums, mid + 1, right, target);
		} else {
			// Right side is sorted
			if (nums[mid] < target && target <= nums[right])
				return helper(nums, mid + 1, right, target);
			else
				return helper(nums, left, mid - 1, target);
		}
	}
}
