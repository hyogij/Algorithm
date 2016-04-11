package leetCode;

import java.util.HashMap;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.08.21
 Question Number : 84
 Link : https://leetcode.com/problems/contains-duplicate-ii/
 ==========================================================
 */

public class ContainsNearbyDuplicate {
	/*
	 * Given an array of integers and an integer k, find out whether there are
	 * two distinct indices i and j in the array such that nums[i] = nums[j] and
	 * the difference between i and j is at most k.
	 */
	public static void main(String[] args) {
		int[] nums = {1, 2, 1};
		System.out.println("containsDuplicate "
				+ containsNearbyDuplicate(nums, 0));
	}

	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums == null || nums.length < 0) {
			return false;
		}

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			Integer index = map.get(num);

			// This element is duplicated number, so we check the difference
			// between two numbers
			if (index != null) {
				if (i - index <= k) {
					return true;
				}
			}
			map.put(num, i);
		}
		return false;
	}
}
