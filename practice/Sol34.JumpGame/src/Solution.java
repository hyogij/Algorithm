import java.util.Arrays;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.14
 Problem : https://leetcode.com/problems/jump-game/
 ==========================================================
 */
public class Solution {
	/*
	 * Given an array of non-negative integers, you are initially positioned at
	 * the first index of the array. Each element in the array represents your
	 * maximum jump length at that position. Determine if you are able to reach
	 * the last index.
	 * 
	 * For example: A = [2,3,1,1,4], return true. A = [3,2,1,0,4], return false.
	 */
	public static void main(String[] args) {
		int[] nums1 = {2, 3, 1, 1, 4};
		System.out.println("canJump " + canJump(nums1));
		int[] nums2 = {3, 2, 1, 0, 4};
		System.out.println("canJump " + canJump(nums2));
	}

	// Time complexity is O(n^2). This solution exceed time limitation.
	public static boolean canJump(int[] nums) {
		if (nums == null || nums.length == 0)
			return false;

		int[] reachable = new int[nums.length];
		for (int i = 1; i < nums.length; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				if (i <= nums[j] + j && reachable[j] + 1 < min)
					min = reachable[j] + 1;
			}

			if (min != Integer.MAX_VALUE)
				reachable[i] = min;
		}

		if (reachable[nums.length - 1] == 0) {
			return false;
		}
		return true;
	}
}
