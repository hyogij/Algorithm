package leetCode;

import java.util.ArrayList;
import java.util.List;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.08
 Question Number : 16
 Link : https://leetcode.com/problems/subsets/
 ==========================================================
 */
public class Subsets {
	/*
	 * Given a set of distinct integers, nums, return all possible subsets.
	 * 
	 * Note: Elements in a subset must be in non-descending order. The solution
	 * set must not contain duplicate subsets. For example, If nums = [1,2,3], a
	 * solution is: [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
	 */
	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		List<List<Integer>> list = subsets(nums);
		System.out.println("subsets : " + list.toString());
	}

	// Uses recursive method to find subsets
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();

		// Adds empty subset. Empty subset is always included in every subsets
		List<Integer> empty = new ArrayList<Integer>();
		list.add(empty);

		for (int i = 0; i < nums.length; i++) {
			List<Integer> subset = new ArrayList<Integer>();
			subset.add(nums[i]);
			subsetsHelper(nums, i, subset, list);
		}
		return list;
	}

	public static void subsetsHelper(int[] nums, int index,
			List<Integer> subset, List<List<Integer>> list) {
		list.add(subset);
		for (int i = index + 1; i < nums.length; i++) {
			// Creates new list because original list shouldn't modify
			List<Integer> newSubset = new ArrayList<Integer>(subset);
			newSubset.add(nums[i]);
			subsetsHelper(nums, i, newSubset, list);
		}
	}
}