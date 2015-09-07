package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.09.07
 Question Number : 109
 Link : https://leetcode.com/problems/first-missing-positive/
 ==========================================================
 */

public class firstMissingPositive {
	/*
	 * Given an unsorted integer array, find the first missing positive integer.
	 * 
	 * For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
	 * 
	 * Your algorithm should run in O(n) time and uses constant space.
	 */
	public static void main(String[] args) {
		int[] nums = {1, 2, 0};
		System.out
				.println("firstMissingPositive " + firstMissingPositive(nums));
		int[] nums2 = {3, 4, -1, 1};
		System.out.println("firstMissingPositive "
				+ firstMissingPositive(nums2));
	}

	// Use integer arrays to store the existence of number from the array
	private static int[] bits;

	public static int firstMissingPositive(int[] nums) {
		if (nums.length == 0) {
			return 1;
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max) {
				max = nums[i];
			}
		}

		int count = (max / 32) + 1;
		bits = new int[count];

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				setBit(nums[i]);
			}
		}

		for (int i = 1; i <= max; i++) {
			if (getBit(i) == false) {
				return i;
			}
		}
		return max + 1;
	}

	public static void setBit(int num) {
		int position = (num / 32);
		int offset = num % 32;
		bits[position] |= (1 << offset);
	}

	public static boolean getBit(int num) {
		int position = (num / 32);
		int offset = num % 32;
		if ((bits[position] & (1 << offset)) != 0) {
			return true;
		} else {
			return false;
		}
	}
}
