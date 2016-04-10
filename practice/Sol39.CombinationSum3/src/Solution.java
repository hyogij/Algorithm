import java.util.ArrayList;
import java.util.List;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.15
 Problem : https://leetcode.com/problems/combination-sum-iii/
 ==========================================================
 */
public class Solution {
	/*
	 * /* Find all possible combinations of k numbers that add up to a number n,
	 * given that only numbers from 1 to 9 can be used and each combination
	 * should be a unique set of numbers.
	 * 
	 * Ensure that numbers within the set are sorted in ascending order.
	 * Example 1: Input: k = 3, n = 7 Output: [[1,2,4]]
	 * Example 2: Input: k = 3, n = 9 Output: [[1,2,6], [1,3,5], [2,3,4]]
	 */
	public static void main(String[] args) {
		int set[] = {3, 34, 4, 12, 5, 2};
		List<List<Integer>> combinations = combine3(9, 3, 7);
		System.out.println(combinations.toString());

		combinations = combine3(9, 3, 9);
		System.out.println(combinations.toString());
	}

	public static List<List<Integer>> combine3(int n, int k, int sum) {
		List<List<Integer>> combinations = new ArrayList<List<Integer>>();
		combine3Helper(combinations, new ArrayList<Integer>(), 0, n, k, sum);
		return combinations;
	}

	public static void combine3Helper(List<List<Integer>> combinations, List<Integer> list,
			int index, int length, int k, int sum) {
		if (k == 0 && sum == 0) {
			combinations.add(new ArrayList<Integer>(list));
			return;
		}

		for (int i = index; i < length; i++) {
			list.add(i);
			combine3Helper(combinations, list, i + 1, length, k - 1, sum - i);
			list.remove(list.size() - 1);
		}
	}
}
