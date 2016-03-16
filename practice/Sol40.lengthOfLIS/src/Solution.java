import java.util.Arrays;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.16
 Problem : https://leetcode.com/problems/longest-increasing-subsequence/
 ==========================================================
 */
public class Solution {
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
		int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
		int[] nums2 = {1, 3, 6, 7, 9, 4, 10, 5, 6};
		System.out.println("lengthOfLIS " + lengthOfLIS(nums1));
		System.out.println("lengthOfLIS " + lengthOfLIS(nums2));
	}

	// Dynamic programming to find the length of longest increasing subsequence.
	public static int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int[] length = new int[nums.length];
		for (int i = 0; i < nums.length; i++)
			length[i] = 1;

		int max = 1;
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i] && length[j] + 1 > length[i]) {
					length[i] = length[j] + 1;
				}
			}
		}

		for (int i = 0; i < length.length; i++) {
			if (length[i] > max) {
				max = length[i];
			}
		}

		return max;
	}
}
