/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.11
 Problem : https://leetcode.com/problems/course-schedule/
 ==========================================================
 */
public class Solution {
	/*
	 * Given an array of non-negative integers, you are initially positioned at
	 * the first index of the array.
	 * 
	 * Each element in the array represents your maximum jump length at that
	 * position.
	 * 
	 * Determine if you are able to reach the last index.
	 * 
	 * For example: A = [2,3,1,1,4], return true.
	 * 
	 * A = [3,2,1,0,4], return false.
	 */
	public static void main(String[] args) {
		int[] nums1 = {2, 3, 1, 1, 4};
		System.out.println("canJump " + canJump(nums1));
		int[] nums2 = {3, 2, 1, 0, 4};
		System.out.println("canJump " + canJump(nums2));
	}

	public static boolean canJump(int[] nums) {
		if (nums == null || nums.length == 0)
			return false;

		return canJumpHelper(nums, 0, nums[0]);
	}

	public static boolean canJumpHelper(int[] nums, int current, int jump) {
		if(current + jump >= nums.length - 1) 
			return true;
		if(jump == 0 && current != nums.length - 1)
			return false;
		
		boolean can = false;
		for(int i = current; i < current + jump; i++) {
			can |= canJumpHelper(nums, i, nums[i]);
		}
		return can;
	}
}
