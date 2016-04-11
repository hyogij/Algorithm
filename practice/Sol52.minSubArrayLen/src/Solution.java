/*
==========================================================
Author : Hyogi Jung(hyogij@gmail.com)
Date : 2016.03.21
Problem : https://leetcode.com/problems/minimum-size-subarray-sum/
http://www.geeksforgeeks.org/find-subarray-with-given-sum/
==========================================================
*/
public class Solution {
	/*
	 * Given an array of n positive integers and a positive integer s, find the
	 * minimal length of a subarray of which the sum กร s. If there isn't one,
	 * return 0 instead.
	 * 
	 * For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3]
	 * has the minimal length under the problem constraint.
	 * 
	 * click to show more practice.
	 * 
	 * More practice: If you have figured out the O(n) solution, try coding
	 * another solution of which the time complexity is O(n log n).
	 */
	public static void main(String[] args) {

		int[] nums1 = { 2, 3, 1, 2, 4, 3 };
		System.out.println("findSubarray " + findSubarray(7, nums1));
		System.out.println("getMinimumSubArray " + getMinimumSubArray(7, nums1));
		System.out.println("getMinimumSubArray " + getMinimumSubArray(4, nums1));
		System.out.println("findSubarrayLeetcode " + minSubArrayLen(7, nums1));

		int[] nums2 = { 1, 2, 3, 4, 5 };
		System.out.println("findSubarray " + findSubarray(7, nums2));
		System.out.println("findSubarray " + findSubarray(12, nums2));
		System.out.println("findSubarray " + findSubarray(5, nums2));
		
		System.out.println("getMinimumSubArray " + getMinimumSubArray(7, nums2));
		System.out.println("getMinimumSubArray " + getMinimumSubArray(12, nums2));
		System.out.println("getMinimumSubArray " + getMinimumSubArray(5, nums2));
		
		System.out.println("findSubarrayLeetcode " + minSubArrayLen(11, nums2));
	}

	public static int getMinimumSubArray(int target, int[] nums) {
		if (nums == null || nums.length == 0 || target < 0)
			return -1;

		int left = 0, right = 0;
		int currentSum = 0, min = Integer.MAX_VALUE;
		for (; right < nums.length && left <= right; right++) {
			currentSum += nums[right];

			while (currentSum > target) {
				currentSum -= nums[left];
				left++;
			}

			if (currentSum == target) {
				int length = right - left + 1;
				if (length < min)
					min = length;
			}
		}

		return min;
	}

	// Find subarray of which the sum กร s
	public static int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int left = 0, right = 0;
		int sum = 0;
		int minLength = Integer.MAX_VALUE;
		for (; right < nums.length && left <= right;) {
			// Integer overflow occurs
			if (Integer.MAX_VALUE - sum < nums[right]) {
				sum -= nums[left++];
				continue;
			}

			if (sum + nums[right] >= s) {
				int length = right - left + 1;
				if (length < minLength) {
					minLength = length;
				}
				sum -= nums[left++];
			} else if (sum + nums[right] < s) {
				sum += nums[right++];
			}
		}

		if (minLength == Integer.MAX_VALUE)
			return 0;
		return minLength;
	}

	// Find subarray with given sum
	public static int findSubarray(int s, int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int left = 0, right = 0;
		int sum = 0;
		int minLength = Integer.MAX_VALUE, minIndex = Integer.MAX_VALUE;
		for (; right < nums.length && left <= right;) {
			// Integer overflow occurs
			if (Integer.MAX_VALUE - sum < nums[right]) {
				sum -= nums[left++];
				continue;
			}

			if (sum + nums[right] == s) {
				int length = right - left + 1;
				if (length < minLength) {
					minLength = length;
					minIndex = left;
				}
				sum -= nums[left++];
			} else if (sum + nums[right] < s) {
				sum += nums[right++];
			} else {
				sum -= nums[left++];
			}
		}

		if (minLength == Integer.MAX_VALUE)
			return 0;
		return minLength;
	}
}
