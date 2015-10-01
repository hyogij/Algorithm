package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.10.01
 Question Number : 123
 Link : https://leetcode.com/problems/search-for-a-range/
 ==========================================================
 */

public class SearchRange {
	/*
	 * Given a sorted array of integers, find the starting and ending position
	 * of a given target value.
	 * 
	 * Your algorithm's runtime complexity must be in the order of O(log n).
	 * 
	 * If the target is not found in the array, return [-1, -1].
	 * 
	 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
	 */
	public static void main(String[] args) {
		int nums[] = {1, 1};
		int[] result = searchRange(nums, 1);
		System.out.println("searchRange " + result[0] + ", " + result[1]);
	}

	public static int[] searchRange(int[] nums, int target) {
		int[] result = new int[2];
		int start = -1, end = -1;

		// Find a given target value using binary search. This position is the
		// left most position when target value is duplicated.
		int left = 0, right = nums.length - 1;
		int middle = 0;
		boolean isFound = false;
		while (left <= right) {
			middle = (right - left) / 2 + left;
			if (nums[middle] == target) {
				isFound = true;
				break;
			} else if (nums[middle] > target) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}

		// After then find the starting and ending position of a given target
		// value.
		if (isFound == true) {
			// Find the left most position
			start = middle;
			for (int i = middle; i >= 0; i--) {
				if (nums[i] != target) {
					break;
				}
				start = i;
			}

			// Find the right most position
			end = middle;
			for (int i = middle; i < nums.length; i++) {
				if (nums[i] != target) {
					break;
				}
				end = i ;
			}
		}

		// Set the result array with starting and ending position of a given
		// target value.
		result[0] = start;
		result[1] = end;

		return result;
	}
}
