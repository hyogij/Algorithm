import java.util.ArrayList;
import java.util.Arrays;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.03
 Link : https://leetcode.com/problems/kth-largest-element-in-an-array/
 ==========================================================
 */
public class Solution {
	/*
	 * Find the kth largest element in an unsorted array. Note that it is the
	 * kth largest element in the sorted order, not the kth distinct element.
	 * 
	 * For example, Given [3,2,1,5,6,4] and k = 2, return 5.
	 * 
	 * Note: You may assume k is always valid, 1 ¡Â k ¡Â array's length.
	 */
	public static void main(String[] args) {
		int[] nums = {3, 2, 1, 5, 6, 4};
		System.out.println("findKthLargest " + findKthLargest(nums, 2));
	}

	// kth element, quick sort use partition. there is a pivot, it will divide
	// array into to sub array. Left sub array elements are less than pivot and
	// right sub array elements
	// are greater and equals to pivot.
	// It means that pivot is k th element in array.
	public static int findKthLargest(int[] nums, int k) {
		int start = 0, end = nums.length - 1, index = nums.length - k;
		while (start < end) {
			int pivot = partition(nums, start, end);
			if (pivot < index)
				start = pivot + 1;
			else if (pivot > index)
				end = pivot - 1;
			else
				return nums[pivot];
		}
		return nums[start];
	}

	private static int partition(int[] nums, int start, int end) {
		int pivot = start;
		while (start <= end) {
			while (start <= end && nums[start] <= nums[pivot])
				start++;
			while (start <= end && nums[end] > nums[pivot])
				end--;
			if (start <= end) {
				swap(nums, start, end);
			}
		}
		swap(nums, end, pivot);
		return end;
	}

	private static void swap(int[] nums, int idx1, int idx2) {
		int temp = nums[idx1];
		nums[idx1] = nums[idx2];
		nums[idx2] = temp;
	}
}
