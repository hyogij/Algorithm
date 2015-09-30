package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.09.30
 Question Number : 119
 Link : https://leetcode.com/problems/move-zeroes/
 ==========================================================
 */

public class moveZeroes {
	/*
	 * Given an array nums, write a function to move all 0's to the end of it
	 * while maintaining the relative order of the non-zero elements.
	 * 
	 * For example, given nums = [0, 1, 0, 3, 12], after calling your function,
	 * nums should be [1, 3, 12, 0, 0].
	 * 
	 * Note: You must do this in-place without making a copy of the array.
	 * Minimize the total number of operations.
	 */
	public static void main(String[] args) {
		int[] nums = {0, 1, 0, 3, 12};
		moveZeroes(nums);
		for(int num : nums) {
			System.out.print(num + " ");
		}
	}

	public static void moveZeroes(int[] nums) {
		// There is two indexes. One is pointing to the reading index of array
		// and another is pointing to the writing index of array.
		int readIndex = 0, writeIndex = 0, count = 0;
		
		for (; readIndex < nums.length; readIndex++) {
			int num = nums[readIndex];
			if (num == 0) {
				count++;
			} else {
				nums[writeIndex++] = num;
			}
		}
		
		// Writes zero elements to the end of list
		for (int i=0; i < count; i++) {
			nums[writeIndex++] = 0;
		}
	}
}
