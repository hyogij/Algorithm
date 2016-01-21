package leetCode;

import java.util.ArrayList;
import java.util.List;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.01.21
 Question Number : 146
 Link : https://leetcode.com/problems/permutations-ii/
 ==========================================================
 */
public class Solution {
	/*
	 * Given a collection of numbers that might contain duplicates, return all
	 * possible unique permutations.
	 * 
	 * For example, [1,1,2] have the following unique permutations: [1,1,2],
	 * [1,2,1], and [2,1,1].
	 * 
	 * Subscribe to see which companies asked this question
	 */
	public static void main(String[] args) {
		int[] candidates = {1, 1, 2};
		List<List<Integer>> permutes = permuteUnique(candidates);
		System.out.println(permutes.toString());
	}
	
	public static List<List<Integer>> permuteUnique(int[] candidates) {
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
