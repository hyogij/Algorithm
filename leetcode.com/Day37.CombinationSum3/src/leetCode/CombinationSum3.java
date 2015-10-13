package leetCode;

import java.util.ArrayList;
import java.util.List;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.10.13
 Question Number : 144
 Link : https://leetcode.com/problems/combination-sum-iii/
 ==========================================================
 */

public class CombinationSum3 {
	/*
	 * Find all possible combinations of k numbers that add up to a number n,
	 * given that only numbers from 1 to 9 can be used and each combination
	 * should be a unique set of numbers.
	 * 
	 * Ensure that numbers within the set are sorted in ascending order.
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: k = 3, n = 7
	 * 
	 * Output:
	 * 
	 * [[1,2,4]]
	 * 
	 * Example 2:
	 * 
	 * Input: k = 3, n = 9
	 * 
	 * Output:
	 * 
	 * [[1,2,6], [1,3,5], [2,3,4]]
	 */
	public static void main(String[] args) {
		List<List<Integer>> combinations = combinationSum3(3, 7);
		System.out.println(combinations.toString());
	}

	private static final int MAX_INT = 9;
	public static List<List<Integer>> combinationSum3(int n, int k) {
		List<List<Integer>> combinations = new ArrayList<List<Integer>>();

		// Make an array that contains integer variables less than n
		int[] candidates = new int[MAX_INT];
		for (int i = 0; i < MAX_INT; i++) {
			candidates[i] = i + 1;
		}

		// Find all possible combinations of k numbers out of 1 ... n through
		// recursive method
		for (int i = 0; i < MAX_INT && k >= 1; i++) {
			int candidate = candidates[i];
			if (candidate <= k) {
				List<Integer> combination = new ArrayList<Integer>();
				combination.add(candidate);
				combineHelper(combinations, combination, candidates, n, i + 1,
						k - candidate);
			}
		}
		return combinations;
	}

	public static void combineHelper(List<List<Integer>> combinations,
			List<Integer> combination, int[] candidates, int n, int index, int k) {
		if (k == 0 && combination.size() == n) {
			combinations.add(combination);
			return;
		} else if (k < 0) {
			return;
		}

		for (int i = index; i < MAX_INT; i++) {
			int candidate = candidates[i];
			if (k - candidate >= 0 && combination.size() < n) {
				List<Integer> temp = new ArrayList<Integer>(combination);
				temp.add(candidate);
				combineHelper(combinations, temp, candidates, n, i + 1, k
						- candidate);
			}
		}
	}
}
