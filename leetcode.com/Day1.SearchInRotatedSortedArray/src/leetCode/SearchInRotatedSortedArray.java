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
		int[] nums = {1};
		index = search(nums, 0);
		System.out.println("index = " + index);
	}

	public static int search(int[] nums, int target) {
		int left, mid, right;

		left = 0;
		right = nums.length;

		while (left < right) {
			mid = left + (right - left) / 2;

			if (nums[mid] == target) {
				return mid;
			} else if (nums[left] < nums[mid]) {
				// 왼쪽이 정렬된 경우
				if (nums[left] < target && target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else if (nums[mid] < nums[right]) {
				// 오른쪽이 정렬된 경우
				if (nums[mid] < target && target < nums[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			} else if (nums[mid] > nums[right] && nums[left] > nums[mid]) {
				// 역으로 정렬된 경우
				if (target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				// 정렬된 경우
				if (target < nums[mid]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}
}
