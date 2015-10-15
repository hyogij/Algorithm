package leetCode;

import java.util.ArrayList;
import java.util.List;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.10.14
 Question Number : 145
 Link : https://leetcode.com/problems/permutations/
 ==========================================================
 */

public class Permute {
	/*
	 * Given a collection of numbers, return all possible permutations.
	 * 
	 * For example, [1,2,3] have the following permutations: [1,2,3], [1,3,2],
	 * [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
	 */
	public static void main(String[] args) {
		int[] candidates = {1, 2, 3};
		List<List<Integer>> permutes = permute(candidates);
		System.out.println(permutes.toString());
	}

	public static List<List<Integer>> permute(int[] candidates) {
		if (candidates.length == 0) {
			return null;
		}

		List<List<Integer>> permuteLists = new ArrayList<List<Integer>>();
		List<Integer> permutes = new ArrayList<Integer>();
		permuteHelper(permuteLists, permutes, candidates);
		return permuteLists;
	}

	public static void permuteHelper(List<List<Integer>> permuteLists,
			List<Integer> permutes, int[] candidates) {
		// Add permute result to permute list if permute's size is the number of
		// candidates
		if (permutes.size() == candidates.length) {
			permuteLists.add(permutes);
			return;
		}

		for (int i = 0; i < candidates.length; i++) {
			int candidate = candidates[i];
			// Add the candidate to permute result if it is not contained
			// permute result
			if (!permutes.contains(candidate)) {
				List<Integer> newPermutes = new ArrayList<Integer>(permutes);
				newPermutes.add(candidate);
				permuteHelper(permuteLists, newPermutes, candidates);
			}
		}
	}
}
