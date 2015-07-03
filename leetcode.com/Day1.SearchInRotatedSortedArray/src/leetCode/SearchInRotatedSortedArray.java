package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.02
 Question Number : 5
 Link : https://leetcode.com/problems/search-in-rotated-sorted-array/
 ==========================================================
 */
public class SearchInRotatedSortedArray {
	/*
	 * Suppose a sorted array is rotated at some pivot unknown to you
	 * beforehand.
	 * 
	 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	 * 
	 * You are given a target value to search. If found in the array return its
	 * index, otherwise return -1.
	 * 
	 * You may assume no duplicate exists in the array.
	 */
	public static void main(String[] args) {
		int index = 0;
		int[] nums = {5, 1, 3};
		index = search(nums, 3);
		System.out.println("index = " + index);
	}

	public static int search(int[] nums, int target) {
		int left, mid, right;

		left = 0;
		right = nums.length-1;

		while (left <= right) {
			mid = left + (right - left) / 2;
			
			if (nums[mid] == target) {
				return mid;
			} else if (nums[left] <= nums[mid]) {
				// If left side is ordered
				if (nums[left] <= target && target < nums[mid]) {
					right = mid;
				} else {
					left = mid + 1;
				}
			} else {
				// If right side is ordered
				if (nums[mid] < target && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}
		}
		return -1;
	}
}
