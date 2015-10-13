package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.10.13
 Question Number : 143
 Link : https://leetcode.com/problems/combination-sum-ii/
 ==========================================================
 */

public class CombinationSum2 {
	/*
	 * Given a collection of candidate numbers (C) and a target number (T), find
	 * all unique combinations in C where the candidate numbers sums to T.
	 * 
	 * Each number in C may only be used once in the combination.
	 * 
	 * Note: All numbers (including target) will be positive integers. Elements
	 * in a combination (a1, a2, ¡¦ , ak) must be in non-descending order. (ie,
	 * a1 ¡Â a2 ¡Â ¡¦ ¡Â ak).
	 * 
	 * The solution set must not contain duplicate combinations. For example,
	 * given candidate set 10,1,2,7,6,1,5 and target 8,
	 * 
	 * A solution set is: [1, 7] [1, 2, 5] [2, 6] [1, 1, 6]
	 */
	public static void main(String[] args) {
		int[] candidates = {2, 2, 2, 2};
		List<List<Integer>> combinations = combinationSum2(candidates, 4);
		System.out.println(combinations.toString());
	}

	public static List<List<Integer>> combinationSum2(int[] candidates,
			int target) {
		List<List<Integer>> combinations = new ArrayList<List<Integer>>();

		// Sort the candidates in a ascending order
		Arrays.sort(candidates);

		// Store previous number to skip current number when it is equal to
		// previous number
		int prev = -1;
		for (int i = 0; i < candidates.length; i++) {
			int candidate = candidates[i];
			if (candidate <= target && prev != candidate) {
				List<Integer> combination = new ArrayList<Integer>();
				combination.add(candidate);
				combinationSumHelper(candidates, target - candidate,
						combinations, combination, i + 1);
			}
			prev = candidate;
		}
		return combinations;
	}

	public static void combinationSumHelper(int[] candidates, int target,
			List<List<Integer>> combinations, List<Integer> combination,
			int position) {
		if (target == 0) {
			// Add the combination list where the candidate numbers sums to T to
			// combinations list
			combinations.add(combination);
			return;
		} else if (target < 0) {
			return;
		} else {
			// Store previous number to skip current number when it is equal to
			// previous number
			int prev = -1;
			for (int i = position; i < candidates.length; i++) {
				int candidate = candidates[i];
				// Candidate number should be bigger than last number in
				// combination list to keep non-descending order
				if (candidate >= combination.get(combination.size() - 1)
						&& prev != candidate) {
					// Make the new arraylist that contain given combination
					List<Integer> newCombination = new ArrayList<Integer>(
							combination);
					newCombination.add(candidate);
					combinationSumHelper(candidates, target - candidate,
							combinations, newCombination, i + 1);
				}
				prev = candidate;
			}
		}
	}
}
