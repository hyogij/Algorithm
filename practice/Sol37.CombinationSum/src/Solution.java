import java.util.ArrayList;
import java.util.List;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.15
 Problem : https://leetcode.com/problems/combination-sum/
 ==========================================================
 */
public class Solution {
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
	 * For example, given candidate set 2,3,6,7 and target 7, 
	 * A solution set is: [7] [2, 2, 3]
	 */
	public static void main(String[] args) {
		int set[] = {2, 3, 6, 7};
		int target = 7;
		List<List<Integer>> combination = combinationSum(set, target);
		System.out.println(combination.toString());
	}

	public static List<List<Integer>> combinationSum(int[] candidates,
			int target) {
		List<List<Integer>> combination = new ArrayList<List<Integer>>();
		combinationSumHelper(combination, new ArrayList<Integer>(), candidates,
				0, target);
		return combination;
	}

	public static void combinationSumHelper(List<List<Integer>> combination,
			List<Integer> list, int[] candidates, int index, int target) {
		System.out.println(index + " " + target + " " + list.toString());
		if (target == 0) {
			combination.add(list);
			return;
		}

		for (int i = index; i < candidates.length
				&& target - candidates[i] >= 0; i++) {
			List<Integer> newList = new ArrayList<Integer>(list);
			newList.add(candidates[i]);
			combinationSumHelper(combination, newList, candidates, i, target
					- candidates[i]);
		}
	}
}
