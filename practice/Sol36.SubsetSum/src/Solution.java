import java.util.ArrayList;
import java.util.List;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.15
 Problem : http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/
 ==========================================================
 */
public class Solution {
	/*
	 * Given a set of non-negative integers, and a value sum, determine if there
	 * is a subset of the given set with sum equal to given sum.
	 * 
	 * Examples: set[] = {3, 34, 4, 12, 5, 2}, sum = 9 Output: True There is a
	 * subset (4, 5) with sum 9.
	 */
	public static void main(String[] args) {
		int set[] = {3, 34, 4, 12, 5, 2};
		System.out.println("isSubsetSum " + subsetSum(set, 9));
		System.out.println("isSubsetSum " + subsetSum(set, 6));
		System.out.println("isSubsetSum " + subsetSum(set, 13));
		System.out.println("isSubsetSum " + subsetSum(set, 19));

		List<List<Integer>> combinations = combine(4, 2);
		System.out.println(combinations.toString());

		System.out.println("findSubsets " + findSubsets(9, 9, 2));
	}

	// https://leetcode.com/problems/combinations/
	// n = 4 and k = 2
	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> combinations = new ArrayList<List<Integer>>();
		combineHelper(combinations, new ArrayList<Integer>(), 0, n, k);
		return combinations;
	}

	public static void combineHelper(List<List<Integer>> combinations,
			List<Integer> list, int index, int length, int k) {
		if (k == 0) {
			combinations.add(list);
			return;
		}

		for (int i = index; i < length; i++) {
			List<Integer> newList = new ArrayList<Integer>(list);
			newList.add(i);
			combineHelper(combinations, newList, i + 1, length, k - 1);
		}
	}

	public static boolean subsetSum(int input[], int total) {
		boolean T[][] = new boolean[input.length + 1][total + 1];
		// Initialize zero values in first index of matrix
		for (int i = 0; i <= input.length; i++) {
			T[i][0] = true;
		}

		for (int i = 1; i <= input.length; i++) {
			for (int j = 1; j <= total; j++) {
				if (j < input[i - 1]) {
					T[i][j] = T[i - 1][j]; // check the above value
				} else {
					// check the above value and target value - current value
					T[i][j] = T[i - 1][j] || T[i - 1][j - input[i - 1]];
				}
			}
		}

		return T[input.length][total];
	}

	// Find the subsets that makes the target sum within certain number of elements
	private static List<List<Integer>> findSubsets(int sum, int length, int num) {
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		findSubsetsHelper(sum, 0, length, num, subsets, list);
		return subsets;
	}

	private static void findSubsetsHelper(int sum, int left, int right,
			int num, List<List<Integer>> subsets, List<Integer> list) {
		// Base case
		if (sum == 0 && num == 0) {
			subsets.add(list);
			return;
		}
		for (int i = left; i < right; i++) {
			List<Integer> newList = new ArrayList<Integer>(list);
			newList.add(i);
			findSubsetsHelper(sum - i, i + 1, right, num - 1, subsets, newList);
		}
		return;
	}
}
