package leetCode;

import java.util.ArrayList;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.11.06
 Link : https://leetcode.com/problems/longest-increasing-subsequence/
 ==========================================================
 */

public class lengthOfLIS {
	/*
	 * Given an unsorted array of integers, find the length of longest
	 * increasing subsequence.
	 * 
	 * For example, Given [10, 9, 2, 5, 3, 7, 101, 18], The longest increasing
	 * subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there
	 * may be more than one LIS combination, it is only necessary for you to
	 * return the length.
	 * 
	 * Your algorithm should run in O(n2) complexity.
	 * 
	 * Follow up: Could you improve it to O(n log n) time complexity?
	 */
	public static void main(String[] args) {
		int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
		System.out.println("lengthOfLIS " + lengthOfLIS(nums));
	}

	// Below algorithm couldn't solve following cases.
	// [10,9,2,5,3,4] expected 3, [1,3,6,7,9,4,10,5,6] expected 6
	public static int lengthOfLISNaive(int[] nums) {
		int max = 0;

		// I will make a linked list to store the longest increasing subsequence
		// Traversal the array from first to last index when number is
		// increasing
		ArrayList<Integer> list = new ArrayList<Integer>();
		int prev = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			prev = nums[i];
			list.add(prev);
			for (int j = i + 1; j < nums.length; j++) {
				if (prev < nums[j]) {
					list.add(nums[j]);
					prev = nums[j];
				}
			}
			if (list.size() > max) {
				max = list.size();
			}
			list.clear();
		}

		return max;
	}

	// Time complexity is O(n^2)
	public static int lengthOfLIS(int[] nums) {
		int dp[] = new int[nums.length], max = 0;
		for (int i = 0; i < nums.length; ++i) {
			max = 1;
			for (int j = 0; j < i; ++j) {
				if (nums[i] > nums[j]) {
					max = Math.max(max, dp[j] + 1);
				}
			}
			dp[i] = max;
		}

		for (int i = 0; i < dp.length; ++i) {
			System.out.print(" " + dp[i]);
			max = Math.max(max, dp[i]);
		}

		return max;
	}

	// Time complexity is O(nlong)
	public int lengthOfLISLogScale(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] res = new int[nums.length];
		int len = 0;
		res[len] = nums[0];
		len++;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < res[0]) {
				res[0] = nums[i];
			} else if (nums[i] > res[len - 1]) {
				res[len] = nums[i];
				len++;
			} else {
				int index = doBinarySearch(res, 0, len - 1, nums[i]);
				res[index] = nums[i];
			}
		}
		return len;
	}

	private int doBinarySearch(int[] nums, int start, int end, int target) {
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (nums[start] == target) {
			return start;
		} else {
			return end;
		}
	}
}
