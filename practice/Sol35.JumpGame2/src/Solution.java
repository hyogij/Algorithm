/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.14
 Problem : https://leetcode.com/problems/jump-game-ii/
 ==========================================================
 */
public class Solution {
	/*
	 * Given an array of non-negative integers, you are initially positioned at
	 * the first index of the array. Each element in the array represents your
	 * maximum jump length at that position. Your goal is to reach the last
	 * index in the minimum number of jumps.
	 * 
	 * For example: Given array A = [2,3,1,1,4]
	 * 
	 * The minimum number of jumps to reach the last index is 2. (Jump 1 step
	 * from index 0 to 1, then 3 steps to the last index.)
	 * 
	 * Note: You can assume that you can always reach the last index.
	 */
	public static void main(String[] args) {
		int[] nums1 = {2, 3, 1, 1, 4};
		System.out.println("canJump " + canJump(nums1));
		System.out.println("minJumpRecursive " + minJumpRecursive(nums1, 0));
	}

	// Time complexity is O(n^2). This solution exceed time limitation.
	public static int canJump(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int[] jump = new int[nums.length];
		for (int i = 1; i < nums.length; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				if (i <= nums[j] + j && jump[j] + 1 < min)
					min = jump[j] + 1;
			}

			if (min != Integer.MAX_VALUE)
				jump[i] = min;
		}

		return jump[nums.length - 1];
	}

	// Returns minimum number of jumps to reach arr[h] from arr[l]
	// http://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
	public static int minJumpRecursive(int arr[], int start) {
		// Base case: when source and destination are same
		if (start == arr.length - 1)
			return 0;

		// When nothing is reachable from the given source
		if (arr[start] == 0)
			return Integer.MAX_VALUE;

		// Traverse through all the points reachable from arr[l]. Recursively
		// get the minimum number of jumps needed to reach arr[h] from these
		// reachable points.
		int min = Integer.MAX_VALUE;
		for (int i = start + 1; i <= arr.length - 1 && i <= start + arr[start]; i++) {
			int jumps = minJumpRecursive(arr, i);
			if (jumps != Integer.MAX_VALUE && jumps + 1 < min)
				min = jumps + 1;
		}

		return min;
	}
}
