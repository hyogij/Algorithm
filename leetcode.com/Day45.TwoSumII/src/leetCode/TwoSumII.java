package leetCode;

import java.util.Arrays;
import java.util.HashMap;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.12.02
 Link : http://shanjiaxin.blogspot.kr/2015/01/two-sum-ii-input-array-is-sorted.html
 ==========================================================
 */
public class TwoSumII {
	/*
	 * Given an array of integers that is already sorted in ascending order,
	 * find two numbers such that they add up to a specific target number. The
	 * function twoSum should return indices of the two numbers such that they
	 * add up to the target, where index1 must be less than index2. Please note
	 * that your returned answers (both index1 and index2) are not zero-based.
	 * You may assume that each input would have exactly one solution. Input:
	 * numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
	 */
	public static void main(String[] args) {
		int[] numbers = {2, 7, 11, 15};
		int target = 19;
		int[] results = twoSumSorted(numbers, target);
		System.out.print(Arrays.toString(results));
	}

	public static int[] twoSum(int[] nums, int target) {
		int[] results = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		if (nums.length < 2) {
			return results;
		}

		map.put(target - nums[0], 1);
		for (int i = 1; i < nums.length; i++) {
			int number = nums[i];
			if (map.containsKey(number)) {
				int key = map.get(number);
				results[0] = key;
				results[1] = i + 1;
				return results;
			} else {
				map.put(target - number, i + 1);
			}
		}

		return results;
	}

	public static int[] twoSumSorted(int[] nums, int target) {
		int[] results = new int[2];

		if (nums.length < 2) {
			return results;
		}

		int left = 0, right = nums.length - 1;
		while (left < right) {
			int sum = nums[left] + nums[right];
			if (sum > target) {
				right--;
			} else if (sum < target) {
				left++;
			} else {
				results[0] = left + 1;
				results[1] = right + 1;
				break;
			}
		}

		return results;
	}
}
