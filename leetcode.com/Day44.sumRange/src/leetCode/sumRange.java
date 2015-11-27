package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.11.27
 Link : https://leetcode.com/problems/range-sum-query-immutable/
 ==========================================================
 */

public class sumRange {
	/*
	 * Given an integer array nums, find the sum of the elements between indices
	 * i and j (i ¡Â j), inclusive.
	 * 
	 * Example: Given nums = [-2, 0, 3, -5, 2, -1]
	 * 
	 * sumRange(0, 2) -> 1 
	 * sumRange(2, 5) -> -1 
	 * sumRange(0, 5) -> -3 
	 * 
	 * Note: You may assume that the array does not change. 
	 * There are many calls to sumRange function.
	 */
	public static void main(String[] args) {
		int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
		NumArray numArray = new NumArray(nums);
		System.out.println(numArray.sumRange(0, 1));
		System.out.println(numArray.sumRange(1, 2));
	}

	public static class NumArray {
		private int[] nums = null;

		public NumArray(int[] nums) {
			int sum = 0;
			this.nums = new int[nums.length];

			for (int i = 0; i < nums.length; i++) {
				sum += nums[i];
				this.nums[i] = sum;
			}
		}

		public int sumRange(int i, int j) {
			// Boundary check
			if (i > j) {
				return 0;
			}

			if (i >= nums.length || j >= nums.length) {
				return 0;
			}

			if (i == 0) {
				return nums[j];
			}

			return nums[j] - nums[i - 1];
		}
	}

	// Your NumArray object will be instantiated and called as such:
	// NumArray numArray = new NumArray(nums);
	// numArray.sumRange(0, 1);
	// numArray.sumRange(1, 2);
}
