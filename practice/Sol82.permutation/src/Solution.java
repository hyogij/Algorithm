import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
