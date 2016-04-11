import java.util.ArrayList;
import java.util.List;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.09
 Link : https://leetcode.com/problems/factor-combinations/
 ==========================================================
 */
public class Solution {
	/*
	 * Print all unique combination of factors (except 1) of a given number. For
	 * example: Input: 12 Output: [[2, 2, 3], [2, 6], [3, 4]] Input: 15 Output:
	 * [[3, 5]] Input: 28 Output: [[2, 2, 7], [2, 14], [4, 7]]
	 * 
	 */
	public static void main(String[] args) {
		List<List<Integer>> list = null;
		list = getFactors(12);
		System.out.println(list.toString());

		list = getFactors(15);
		System.out.println(list.toString());

		list = getFactors(28);
		System.out.println(list.toString());
	}

	public static List<List<Integer>> getFactors(int n) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		getFactorsHelper(n, 1, 2, list, new ArrayList<Integer>());
		return list;
	}

	private static void getFactorsHelper(int n, int product, int start, List<List<Integer>> list,
			List<Integer> sub) {
		// Base case
		if (n == product) {
			list.add(new ArrayList<Integer>(sub));
			return;
		} else if (n < product) {
			return;
		}

		for (int i = start; i < n; i++) {
			if (product * i <= n) {
				sub.add(i);
				getFactorsHelper(n, product * i, i, list, sub);
				sub.remove(sub.size() - 1);
			}
		}
	}
}
