package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.07
 Question Number : 14
 Link : https://leetcode.com/problems/jump-game/
 ==========================================================
 */
public class JumpGame {
	/*
	 * Given an array of non-negative integers, you are initially positioned at
	 * the first index of the array.
	 * 
	 * Each element in the array represents your maximum jump length at that
	 * position.
	 * 
	 * Determine if you are able to reach the last index.
	 * 
	 * For example: A = [2,3,1,1,4], return true. A = [3,2,1,0,4], return false.
	 */
	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 1, 1};
		boolean result = canJump(nums);
		System.out.println(result);
	}

	// Recursive method
	public static boolean canJump(int[] nums) {
		return canJumpHelper(nums, 0);
	}

	public static boolean canJumpHelper(int[] nums, int index) {
		boolean result = false;
		if (index == nums.length - 1) {
			// Reaches the last index
			return true;
		} else if (index > nums.length) {
			// Jumps over the last index
			return false;
		} else {
			int jumpLength = nums[index];
			// Jumps to next position within maximum jump length
			for (int i = 1; i <= jumpLength; i++) {
				result = canJumpHelper(nums, index + i);
				if (result == true) {
					return result;
				}
			}
		}
		return result;
	}
}
