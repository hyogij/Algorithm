package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.03
 Question Number : 6
 Link : https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 ==========================================================
 */
public class SearchInRotatedSortedArray2 {
	/*
	 * Follow up for "Search in Rotated Sorted Array": What if duplicates are
	 * allowed?
	 * 
	 * Would this affect the run-time complexity? How and why?
	 * 
	 * Write a function to determine if a given target is in the array.
	 */
	public static void main(String[] args) {
		int[] nums = {3, 1, 1};
		boolean result = search(nums, 3);
		System.out.println("result = " + result);
	}

	public static boolean search(int[] nums, int target) {
		int left, mid, right;

		left = 0;
		right = nums.length - 1;

		while (left <= right) {
			mid = left + (right - left) / 2;

			if (nums[mid] == target) {
				return true;
			} else if (nums[left] < nums[mid]) {
				// If left side is ordered
				if (nums[left] <= target && target < nums[mid]) {
					right = mid;
				} else {
					left = mid + 1;
				}
			} else if (nums[left] > nums[mid]){
				// If right side is ordered
				if (nums[mid] < target && target <= nums[right]) {
					left = mid + 1;
				} else {
					right = mid;
				}
			} else {
				// This is important part!
				left++;
			}
		}
		return false;
	}
}
