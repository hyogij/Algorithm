import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.15
 Problem : https://leetcode.com/problems/combination-sum-ii/
 ==========================================================
 */
public class Solution {
	/*
	 * Given a collection of candidate numbers (C) and a target number (T), find
	 * all unique combinations in C where the candidate numbers sums to T.
	 * 
	 * Each number in C may only be used once in the combination.
	 * 
	 * Note: All numbers (including target) will be positive integers. Elements
	 * in a combination (a1, a2, ¡¦ , ak) must be in non-descending order. (ie,
	 * a1 ¡Â a2 ¡Â ¡¦ ¡Â ak). The solution set must not contain duplicate
	 * combinations. For example, given candidate set 10,1,2,7,6,1,5 and target
	 * 8, A solution set is: [1, 7] [1, 2, 5] [2, 6] [1, 1, 6]
	 */
	public static void main(String[] args) {
		int set[] = {10, 1, 2, 7, 6, 1, 5};
		int target = 8;
		List<List<Integer>> combination = combinationSum(set, target);
		System.out.println(combination.toString());
	}

	public static List<List<Integer>> combinationSum(int[] candidates,
			int target) {
		Arrays.sort(candidates);
		List<List<Integer>> combination = new ArrayList<List<Integer>>();
		combinationSumHelper(combination, new ArrayList<Integer>(), candidates,
				0, target);
		return combination;
	}

	public static void combinationSumHelper(List<List<Integer>> combination,
			List<Integer> list, int[] candidates, int index, int target) {
		if (target == 0) {
			if(!combination.contains(list))
				combination.add(list);
			return;
		}

		for (int i = index; i < candidates.length
				&& target - candidates[i] >= 0; i++) {
			List<Integer> newList = new ArrayList<Integer>(list);
			newList.add(candidates[i]);
			combinationSumHelper(combination, newList, candidates, i + 1,
					target - candidates[i]);
		}
	}
}
