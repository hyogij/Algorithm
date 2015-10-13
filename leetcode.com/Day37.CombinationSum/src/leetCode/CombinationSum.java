package leetCode;

import java.util.ArrayList;
import java.util.List;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.10.13
 Question Number : 141
 Link : https://leetcode.com/problems/combination-sum/
 ==========================================================
 */

public class CombinationSum {
	/*
	 * Given a set of candidate numbers (C) and a target number (T), find all
	 * unique combinations in C where the candidate numbers sums to T.
	 * 
	 * The same repeated number may be chosen from C unlimited number of times.
	 * 
	 * Note: All numbers (including target) will be positive integers. Elements
	 * in a combination (a1, a2, ¡¦ , ak) must be in non-descending order. (ie,
	 * a1 ¡Â a2 ¡Â ¡¦ ¡Â ak). The solution set must not contain duplicate
	 * combinations. 
	 * 
	 * For example, given candidate set 2,3,6,7 and target 7, 
	 * A solution set is: [7] [2, 2, 3]
	 */
	public static void main(String[] args) {
		int[] candidates = {1, 2};
		List<List<Integer>> combinations = combinationSum(candidates, 4);
		System.out.println(combinations.toString());
	}

	public static List<List<Integer>> combinationSum(int[] candidates,
			int target) {
		List<List<Integer>> combinations = new ArrayList<List<Integer>>();
		for (int i = 0; i < candidates.length; i++) {
			int candidate = candidates[i];
			if (candidate <= target) {
				List<Integer> combination = new ArrayList<Integer>();
				combination.add(candidate);
				combinationSumHelper(candidates, target - candidate,
						combinations, combination);
			}
		}
		return combinations;
	}

	public static void combinationSumHelper(int[] candidates, int target,
			List<List<Integer>> combinations, List<Integer> combination) {
		if (target == 0) {
			// Add the combination list where the candidate numbers sums to T to
			// combinations list
			combinations.add(combination);
			return;
		} else if (target < 0) {
			return;
		} else {
			for (int i = 0; i < candidates.length; i++) {
				int candidate = candidates[i];
				// Candidate number should be bigger than last number in
				// combination list to keep non-descending order
				if (candidate >= combination.get(combination.size() - 1)) {
					// Make the new arraylist that contain given combination
					List<Integer> newCombination = new ArrayList<Integer>(
							combination);
					newCombination.add(candidate);
					combinationSumHelper(candidates, target - candidate,
							combinations, newCombination);
				}
			}
		}
	}
}
