package leetCode;

import java.util.ArrayList;
import java.util.List;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.01.21
 Question Number : 159
 Link : https://leetcode.com/problems/permutation-sequence/
 ==========================================================
 */

public class Permute {
	/*
	 * The set [1,2,3,¡¦,n] contains a total of n! unique permutations.
	 * 
	 * By listing and labeling all of the permutations in order, We get the
	 * following sequence (ie, for n = 3):
	 * 
	 * "123" "132" "213" "231" "312" "321" Given n and k, return the kth
	 * permutation sequence.
	 * 
	 * Note: Given n will be between 1 and 9 inclusive.
	 */
	public static void main(String[] args) {
		System.out.println("getPermutation " + getPermutation(3, 3));
	}

	public static String getPermutation(int n, int k) {
		String kSequence = null;
		if (n == 0) {
			return kSequence;
		}

		int[] candidates = new int[n];
		for (int i = 0; i < n; i++) {
			candidates[i] = i + 1;
		}

		List<List<Integer>> permutes = permute(candidates);
		System.out.println(permutes.toString());

		kSequence = permutes.get(k - 1).toString();
		return kSequence;
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
