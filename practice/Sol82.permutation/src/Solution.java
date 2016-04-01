import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.31
 Problem : https://leetcode.com/problems/permutation-sequence/
 ==========================================================
 */

public class Solution {
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
		System.out.println("getPermutation " + getPermutation(4, 5));
		System.out.println("getPermutation " + getPermutation(3, 5));
		System.out.println("getPermutation " + getPermutation(9, 54494));

		int[] nums = {2, 3, 4};
		List<List<String>> permutation = getKPermutations(nums, 2);
		System.out.println("getKPermutations " + permutation.toString());
	}

	/*
	 * Given a set of values 0-9, return all permutations of that set of length
	 * n. Example: n=2, set ={2,3,4} Return: {2,2}, {3,3}, {4,4}, {2,3}, {3,2},
	 * {3,4}, {4,3}, {2,4}, {4,2}
	 */
	public static List<List<String>> getKPermutations(int[] nums, int k) {
		List<List<String>> permutation = new ArrayList<List<String>>();
		getKPermutationsHelper(nums, k, permutation, new ArrayList<String>());
		return permutation;
	}
	public static void getKPermutationsHelper(int[] nums, int k,
			List<List<String>> permutation, List<String> list) {
		if (k == 0) {
			permutation.add(list);
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			List<String> newList = new ArrayList<String>(list);
			newList.add(String.valueOf(nums[i]));
			getKPermutationsHelper(nums, k - 1, permutation, newList);
		}
	}

	public static String getPermutation(int n, int k) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		permutationHelper(n, 1, new StringBuffer(), list);
		Collections.sort(list);
		return String.valueOf(list.get(k - 1));
	}

	private static void permutationHelper(int n, int index, StringBuffer sb,
			ArrayList<Integer> list) {
		if (n == sb.toString().length()) {
			list.add(Integer.valueOf(sb.toString()));
			return;
		}

		for (int i = 0; i <= sb.length(); i++) {
			StringBuffer permutation = new StringBuffer(sb.toString());
			permutation.insert(i, index);
			permutationHelper(n, index + 1, permutation, list);
		}
	}

}
