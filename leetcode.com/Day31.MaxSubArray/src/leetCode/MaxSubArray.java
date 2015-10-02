package leetCode;

import java.util.Arrays;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.10.02
 Question Number : 127
 Link : https://leetcode.com/problems/maximum-subarray/
 ==========================================================
 */
public class MaxSubArray {
	/*
	 * Find the contiguous subarray within an array (containing at least one
	 * number) which has the largest sum.
	 * 
	 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous
	 * subarray [4,-1,2,1] has the largest sum = 6.
	 * 
	 * click to show more practice.
	 * 
	 * More practice: If you have figured out the O(n) solution, try coding
	 * another solution using the divide and conquer approach, which is more
	 * subtle.
	 */
	public static void main(String[] args) {
		int nums[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println("maxSubArray " + maxSubArray(nums));
	}

	public static int maxSubArray(int[] nums) {
		int maxSum = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum > maxSum) {
				maxSum = sum;
			}
			if (sum < 0) {
				sum = 0;
			}
		}
		return maxSum;
	}
}
