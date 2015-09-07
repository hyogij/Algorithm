package leetCode;

import java.util.HashMap;
import java.util.HashSet;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.09.07
 Question Number : 108
 Link : https://leetcode.com/problems/single-number/
 ==========================================================
 */

public class singleNumber {
	/*
	 * Given an array of integers, every element appears twice except for one.
	 * Find that single one.
	 * 
	 * Note: Your algorithm should have a linear runtime complexity. Could you
	 * implement it without using extra memory?
	 */
	public static void main(String[] args) {
		int[] nums = {10, 11, 3, 3, 10};
		System.out.println("missingNumber " + singleNumber(nums));
		int[] nums2 = {20, 21, 3, 3, 20};
		System.out.println("missingNumber " + singleNumber(nums2));
	}

	public static int singleNumberHashMap(int[] nums) {
		// Use a hash map to store the existence of number in array
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i]) == false) {
				map.put(nums[i], true);
				sum += nums[i];
			} else {
				sum -= nums[i];
			}
		}

		return sum;
	}

	public static int singleNumberHashSet(int[] nums) {
		// Use a hash set to store the existence of number in array
		HashSet<Integer> set = new HashSet<Integer>();
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i]) == false) {
				set.add(nums[i]);
				sum += nums[i];
			} else {
				sum -= nums[i];
			}
		}

		return sum;
	}

	public static int singleNumber(int[] nums) {
		int value = 0;
		for (int i = 0; i < nums.length; i++) {
			value ^= nums[i];
		}
		return value;
	}
}
