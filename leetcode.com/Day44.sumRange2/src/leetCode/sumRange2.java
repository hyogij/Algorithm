package leetCode;

import java.awt.Point;
import java.util.Map;
import java.util.TreeMap;

/*
==========================================================
Author : Hyogi Jung(hyogij@gmail.com)
Date : 2015.11.27
Link : https://leetcode.com/problems/range-sum-query-mutable/
==========================================================
*/
public class sumRange2 {
	/*
	 * Given an integer array nums, find the sum of the elements between indices
	 * i and j (i ¡Â j), inclusive.
	 * 
	 * The update(i, val) function modifies nums by updating the element at
	 * index i to val. 
	 * 
	 * Example: Given nums = [1, 3, 5]
	 * 
	 * sumRange(0, 2) -> 9 
	 * update(1, 2) 
	 * sumRange(0, 2) -> 8 
	 * 
	 * Note: The array is only modifiable by the update function. 
	 * You may assume the number of calls to update and sumRange 
	 * function is distributed evenly.
	 */
	public static void main(String[] args) {
//		int[] nums = {1, 3, 5};
//		NumArray numArray = new NumArray(nums);
//		System.out.println(numArray.sumRange(0, 2));
//		numArray.update(1, 2);
//		System.out.println(numArray.sumRange(0, 2));
		
		int[] nums = {9, -8};
		NumArray numArray = new NumArray(nums);
		numArray.update(0, 3);
		System.out.println(numArray.sumRange(1, 1));
		System.out.println(numArray.sumRange(0, 1));
		numArray.update(1, -3);
		System.out.println(numArray.sumRange(0, 1));
	}

	public static class NumArray {
		private int[] nums = null;
		TreeMap<Integer, Integer> map = null;

		public NumArray(int[] nums) {
			int sum = 0;
			this.nums = new int[nums.length];
			map = new TreeMap<Integer, Integer>();

			for (int i = 0; i < nums.length; i++) {
				sum += nums[i];
				this.nums[i] = sum;
			}
		}

		void update(int i, int val) {
			int prev = 0;
			if (i != 0) {
				prev = nums[i - 1];
			}

			int gap = val - (nums[i] - prev);
			map.put(i, gap);
		}

		public int sumRange(int i, int j) {
			int sum = 0;
			if (i == 0) {
				sum = nums[j];
			} else {
				sum = nums[j] - nums[i - 1];
			}

			if (map.size() > 0) {
				int first = map.firstKey();
				int last = map.lastKey();

				if (last >= i && first <= j) {
					for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
						Integer value = entry.getValue();
						sum += value;
					}
				}
			}

			return sum;
		}
	}

	// Your NumArray object will be instantiated and called as such:
	// NumArray numArray = new NumArray(nums);
	// numArray.sumRange(0, 1);
	// numArray.update(1, 10);
	// numArray.sumRange(1, 2);
}
