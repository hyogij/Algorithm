import java.util.ArrayList;
import java.util.List;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.27
 Link : https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 ==========================================================
 */

public class Solution {
	/*
	 * Suppose a sorted array is rotated at some pivot unknown to you
	 * beforehand.
	 * 
	 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	 * 
	 * You are given a target value to search. If found in the array return its
	 * index, otherwise return -1.
	 * 
	 * You may assume no duplicate exists in the array.
	 * 
	 * Follow up for "Search in Rotated Sorted Array": What if duplicates are
	 * allowed?
	 */
	public static void main(String[] args) {
		int[] nums = { 4, 4, 5, 5, 6, 6, 6, 6, 7, 0, 1, 2, 2, 3 };
		System.out.println("search false " + search(nums, 8));
		System.out.println("search true " + search(nums, 5));
		System.out.println("search true " + search(nums, 1));
		System.out.println("search true " + search(nums, 6));
		System.out.println("search true " + search(nums, 3));
		System.out.println("search true " + search(nums, 4));
	}

	// Edge Case : {1, 3, 1, 1, 1}
	public static boolean search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return false;

		return searchHelper(nums, target, 0, nums.length - 1);
	}

	public static boolean searchHelper(int[] nums, int target, int left, int right) {
		if (left > right)
			return false;

		int mid = (right - left) / 2 + left;
		if (nums[mid] == target)
			return true;

		if (nums[left] < nums[mid]) {
			// Right side is sorted
			if (nums[left] <= target && target < nums[mid])
				return searchHelper(nums, target, left, mid - 1);
			else
				return searchHelper(nums, target, mid + 1, right);
		} else if (nums[mid] < nums[right]) {
			// Right side is sorted
			if (nums[mid] < target && target <= nums[right])
				return searchHelper(nums, target, mid + 1, right);
			else
				return searchHelper(nums, target, left, mid - 1);
		} else {
			return searchHelper(nums, target, mid + 1, right)
					|| searchHelper(nums, target, left, mid - 1);
		}
	}

}
