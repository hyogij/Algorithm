package leetcode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.02
 Question Number : 2
 Link : https://leetcode.com/problems/search-insert-position/
 ==========================================================
 */

public class SearchInsertPosition {
	/*
	 * Given a sorted array and a target value, return the index if the target
	 * is found. If not, return the index where it would be if it were inserted
	 * in order.	 
	 * You may assume no duplicates in the array.	  
	 * Here are few examples. 
	 * [1,3,5,6], 5 ¡æ 2 
	 * [1,3,5,6], 2 ¡æ 1 
	 * [1,3,5,6], 7 ¡æ 4
	 * [1,3,5,6], 0 ¡æ 0
	 */

	public static void main(String[] args) {
		int index = 0;
		int[] nums = {1,3};
		index = searchInsert(nums, 2);
		System.out.println("index = " + index);
	}

	/*
	 * Solutions 1) O(nlogn) method : Using binary search
	 */
	public static int searchInsert(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int mid = 0;

		if (nums[left] > target)
			return 0;
		if (nums[right] < target)
			return right + 1;

		// Finds the index using binary search
		while (left < right) {
			mid = (left + right) / 2;
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] < target)
				left = mid + 1;
			else if (nums[mid] > target)
				right = mid - 1;
		}

		if(nums[left] < target)
			return left + 1;
		else 
			return left;
	}
}
