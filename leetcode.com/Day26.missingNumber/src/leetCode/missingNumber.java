package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.09.07
 Question Number : 106
 Link : https://leetcode.com/problems/missing-number/
 ==========================================================
 */

public class missingNumber {
	/*
	 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
	 * find the one that is missing from the array.
	 * 
	 * For example, Given nums = [0, 1, 3] return 2.
	 * 
	 * Note: Your algorithm should run in linear runtime complexity. Could you
	 * implement it using only constant extra space complexity?
	 */
	public static void main(String[] args) {
		int[] nums = {0, 1, 3};
		System.out.println("missingNumber " + missingNumber(nums));
		int[] nums2 = {1, 0};
		System.out.println("missingNumber " + missingNumber(nums2));
	}

	// Use integer arrays to store the existence of number from the array
	private static int[] bits;

	public static int missingNumber(int[] nums) {
		int count = (nums.length / 32) + 1;
		bits = new int[count];

		for (int i = 0; i < nums.length; i++) {
			setBit(nums[i]);
		}

		for (int i = 0; i <= nums.length; i++) {
			if (getBit(i) == false) {
				return i;
			}
		}
		return 0;
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