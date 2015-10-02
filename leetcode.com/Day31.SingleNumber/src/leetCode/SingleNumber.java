package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.10.02
 Question Number : 126
 Link : https://leetcode.com/problems/single-number-ii/
 ==========================================================
 */

public class SingleNumber {
	/*
	 * Given an array of integers, every element appears three times except for
	 * one. Find that single one.
	 * 
	 * Note: Your algorithm should have a linear runtime complexity. Could you
	 * implement it without using extra memory?
	 */
	public static void main(String[] args) {
		int nums[] = {1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5};
		System.out.println(" " + singleNumberTwice(nums));
	}

	// Bits operations to find single one
	public static int singleNumber(int[] nums) {
		int ones = 0, twos = 0, threes = 0;
		for (int i = 0; i < nums.length; i++) {
			twos |= ones & nums[i];
			ones ^= nums[i];
			threes = ones & twos;
			ones &= ~threes;
			twos &= ~threes;
		}
		return ones;
	}

	// Every element appears three times except for one.
	public static int singleNumberTwice(int[] nums) {
		int value = 0;
		for (int i = 0; i < nums.length; i++) {
			value ^= nums[i];
		}
		return value;
	}
}
