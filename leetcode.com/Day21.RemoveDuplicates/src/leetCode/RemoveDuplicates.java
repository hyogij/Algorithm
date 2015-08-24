package leetCode;

import java.util.Arrays;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.08.21
 Question Number : 85
 Link : https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 ==========================================================
 */

public class RemoveDuplicates {
	/*
	 * Given a sorted array, remove the duplicates in place such that each
	 * element appear only once and return the new length.
	 * 
	 * Do not allocate extra space for another array, you must do this in place
	 * with constant memory.
	 * 
	 * For example, Given input array nums = [1,1,2],
	 * 
	 * Your function should return length = 2, with the first two elements of
	 * nums being 1 and 2 respectively. It doesn't matter what you leave beyond
	 * the new length.
	 */
	public static void main(String[] args) {
		int[] nums = {1, 2};
		// int[] nums = {1, 1, 2, 2, 4, 5, 6, 7, 7, 9};
		System.out.println("containsDuplicate " + removeDuplicates(nums));
	}

	public static int removeDuplicates(int[] nums) {
		if (nums.length <= 1) {
			return nums.length;
		}

		int read = 1, write = 0;
		int prev = nums[0], current = 0;
		for (; read < nums.length; read++) {
			current = nums[read];
			if (nums[write] != current) {
				nums[write++] = prev;
				nums[write] = current;
			}

			prev = nums[read];
		}

		// The array's size can not be changed once created, there is no way we
		// can return the original array with correct results. So we create an
		// array with all unique elements
		int[] nums2 = Arrays.copyOf(nums, write + 1);
		return nums2.length;
	}

	// Remove the number of duplicated numbers without modify original array
	public int removeDuplicates2(int[] nums) {
		if (nums.length <= 1) {
			return nums.length;
		}

		int prev = nums[0];
		// Number of duplicated numbers
		int count = 0;

		for (int i = 1; i < nums.length; i++) {
			if (prev == nums[i]) {
				count++;
			}
			prev = nums[i];
		}
		return nums.length - count;
	}
}
