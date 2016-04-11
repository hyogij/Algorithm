import java.util.Arrays;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.10
 Link : https://leetcode.com/problems/wiggle-sort-ii/
 ==========================================================
 */
public class Solution {
	/*
	 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] >
	 * nums[2] < nums[3]....
	 * 
	 * Example: (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1,
	 * 4, 1, 5, 1, 6]. (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer
	 * is [2, 3, 1, 3, 1, 2].
	 * 
	 * Note: You may assume all input has valid answer.
	 * 
	 * Follow Up: Can you do it in O(n) time and/or in-place with O(1) extra
	 * space?
	 */
	public static void main(String[] args) {
		int[] nums1 = { 1, 5, 1, 1, 6, 4 };
		wiggleSort(nums1);
		System.out.println(Arrays.toString(nums1));

		int[] nums2 = { 1, 3, 2, 2, 3, 1 };
		wiggleSort(nums2);
		System.out.println(Arrays.toString(nums2));

		int[] nums3 = { 4, 5, 5, 6 };
		wiggleSort(nums3);
		System.out.println(Arrays.toString(nums3)); // Not correct!!
	}

	public static void wiggleSort(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length, mid = n % 2 == 0 ? n / 2 - 1 : n / 2;
		int[] temp = Arrays.copyOf(nums, n);
		int index = 0;
		for (int i = 0; i <= mid; i++) {
			nums[index] = temp[mid - i];
			if (index + 1 < n)
				nums[index + 1] = temp[n - i - 1];
			index += 2;
		}
	}
	
	public static void wiggleSort2(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length, mid = n / 2;
		
		// Sorted Array
		int[] sorted = Arrays.copyOf(nums, n);
		
		for (int i = 0; i < nums.length; i++) {
			if(i % 2 ==0) {
				nums[i] = sorted[i/2];
			} else {
				nums[i] = sorted[mid + i/2];
			}
		}
	}

	public static void wiggleSortBasic(int[] nums) {
		if (nums == null || nums.length == 0)
			return;

		int candidate = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (i % 2 == 0) {
				// Odd position
				if (nums[i] >= nums[i + 1]) {
					// Find greater number
					candidate = findGreaterNumber(nums, i + 2, nums[i]);
					if (candidate == -1) {
						swap(nums, i + 1, i);
					} else {
						swap(nums, i + 1, candidate);
					}
				}
			} else {
				// Even position
				if (nums[i] <= nums[i + 1]) {
					// Find greater number
					candidate = findSmallerNumber(nums, i + 2, nums[i]);
					if (candidate == -1) {
						swap(nums, i + 1, i);
					} else {
						swap(nums, i + 1, candidate);
					}
				}
			}
		}
	}

	public static int findGreaterNumber(int[] nums, int start, int target) {
		for (int i = start; i < nums.length; i++) {
			if (nums[i] > target)
				return i;
		}
		return -1;
	}

	public static int findSmallerNumber(int[] nums, int start, int target) {
		for (int i = start; i < nums.length; i++) {
			if (nums[i] < target)
				return i;
		}
		return -1;
	}

	public static void swap(int[] nums, int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
}
