package leetCode;

import java.util.HashSet;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.08.21
 Question Number : 83
 Link : https://leetcode.com/problems/contains-duplicate/
 ==========================================================
 */

public class ContainsDuplicate {
	/*
	 * Given an array of integers, find if the array contains any duplicates.
	 * Your function should return true if any value appears at least twice in
	 * the array, and it should return false if every element is distinct.
	 */
	public static void main(String[] args) {
	}

	public boolean containsDuplicate(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i]) == true) {
				return true;
			}
			set.add(nums[i]);
		}
		return false;
	}
}
