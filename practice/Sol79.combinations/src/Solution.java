import java.util.ArrayList;
import java.util.List;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.28
 Link : http://www.geeksforgeeks.org/find-the-largest-subtree-in-a-tree-that-is-also-a-bst/
 ==========================================================
 */
public class Solution {
	/*
	 */
	public static void main(String[] args) {
		// Permutations : 123 132 312 213 231 321
		// Combinations : {}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> list1 = permutations(nums);
		List<List<Integer>> list2 = combinations(nums);

		System.out.println("permutatios " + list1.toString());
		System.out.println("combinations " + list2.toString());
	}

	public static List<List<Integer>> permutations(int[] nums) {
		if (nums == null || nums.length == 0)
			return null;

		List<List<Integer>> list = new ArrayList<List<Integer>>();
		permutationHelper(nums, 0, list, new ArrayList<Integer>());
		return list;
	}

	private static void permutationHelper(int[] nums, int index, List<List<Integer>> list,
			List<Integer> sub) {
		if (index == nums.length) {
			list.add(sub);
			return;
		}

		for (int i = 0; i <= sub.size(); i++) {
			List<Integer> newSub = new ArrayList<Integer>(sub);
			newSub.add(i, nums[index]);
			permutationHelper(nums, index + 1, list, newSub);
		}
	}

	public static List<List<Integer>> combinations(int[] nums) {
		if (nums == null || nums.length == 0)
			return null;

		List<List<Integer>> list = new ArrayList<List<Integer>>();
		combinationsHelper(nums, 0, list, new ArrayList<Integer>());
		return list;
	}

	private static void combinationsHelper(int[] nums, int index, List<List<Integer>> list,
			List<Integer> sub) {
		if (index <= nums.length) {
			list.add(sub);
		}

		for (int i = index; i < nums.length; i++) {
			List<Integer> newSub = new ArrayList<Integer>(sub);
			newSub.add(nums[i]);
			combinationsHelper(nums, i + 1, list, newSub);
		}
	}
}
