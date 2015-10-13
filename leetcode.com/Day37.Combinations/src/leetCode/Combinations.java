package leetCode;

import java.util.ArrayList;
import java.util.List;

/*
==========================================================
Author : Hyogi Jung(hyogij@gmail.com)
Date : 2015.10.13
Question Number : 142
Link : https://leetcode.com/problems/combinations/
==========================================================
*/

public class Combinations {
	/*
	 * Given two integers n and k, return all possible combinations of k numbers
	 * out of 1 ... n.
	 * 
	 * For example, If n = 4 and k = 2, a solution is:
	 * 
	 * [ 
	 * 	[2,4], 
	 * 	[3,4], 
	 * 	[2,3], 
	 * 	[1,2], 
	 * 	[1,3], 
	 * 	[1,4], 
	 * ]
	 */
	public static void main(String[] args) {
		List<List<Integer>> combinations = combine(13, 13);
		System.out.println(combinations.toString());
	}

	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> combinations = new ArrayList<List<Integer>>();
		
		// Make an array that contains integer variables less than n
		int[] candidates = new int[n];
		for (int i = 0; i < n; i++) {
			candidates[i] = i + 1;
		}
		
		// Find all possible combinations of k numbers out of 1 ... n through
		// recursive method
		for (int i = 0; i < n && k >= 1; i++) {
			List<Integer> combination = new ArrayList<Integer>();
			combination.add(candidates[i]);
			combineHelper(combinations, combination, candidates, i + 1, n, k - 1);
		}
		return combinations;
	}

	public static void combineHelper(List<List<Integer>> combinations,
			List<Integer> combination, int[] candidates, int index, int n, int k) {
		if (k == 0) {
			combinations.add(combination);
			return;
		}

		for (int i = index; i < n && k >= 1; i++) {
			List<Integer> temp = new ArrayList<Integer>(combination);
			temp.add(candidates[i]);
			combineHelper(combinations, temp, candidates, i + 1, n, k - 1);
		}
	}
}
