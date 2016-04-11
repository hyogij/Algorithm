/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.03
 Link : https://leetcode.com/problems/find-peak-element/
 ==========================================================
 */
public class Solution {
	/*
	 * A peak element is an element that is greater than its neighbors.
	 * 
	 * Given an input array where num[i] ≠ num[i+1], find a peak element and
	 * return its index.
	 * 
	 * The array may contain multiple peaks, in that case return the index to
	 * any one of the peaks is fine.
	 * 
	 * You may imagine that num[-1] = num[n] = -∞.
	 * 
	 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function
	 * should return the index number 2.
	 */
	public static void main(String[] args) {
		int arr1[] = { 1, 2, 3, 1 };
		System.out.println("findPeakElement " + findPeakElement(arr1));
		System.out.println("findPeakElementBinarySearch " + findPeakElementBinarySearch(arr1));
		System.out.println("findPeakElementLogN " + findPeakElementLogN(arr1));

		int arr2[] = { 5, 10, 20, 15 };
		System.out.println("findPeakElement " + findPeakElement(arr2));
		System.out.println("findPeakElementBinarySearch " + findPeakElementBinarySearch(arr2));
		System.out.println("findPeakElementLogN " + findPeakElementLogN(arr2));

		int arr3[] = { 10, 20, 15, 2, 23, 90, 67 };
		System.out.println("findPeakElement " + findPeakElement(arr3));
		System.out.println("findPeakElementBinarySearch " + findPeakElementBinarySearch(arr3));
		System.out.println("findPeakElementLogN3 " + findPeakElementLogN(arr3));

		int arr4[] = { 10, 20, 30, 40, 50 };
		System.out.println("findPeakElement " + findPeakElement(arr4));
		System.out.println("findPeakElementBinarySearch " + findPeakElementBinarySearch(arr4));
		System.out.println("findPeakElementLogN " + findPeakElementLogN(arr4));

		int arr5[] = { 100, 80, 60, 50, 20 };
		System.out.println("findPeakElement " + findPeakElement(arr5));
		System.out.println("findPeakElementBinarySearch " + findPeakElementBinarySearch(arr5));
		System.out.println("findPeakElementLogN " + findPeakElementLogN(arr5));

		int arr6[] = { 100, 100, 100, 100 };
		System.out.println("findPeakElement " + findPeakElement(arr6));
		System.out.println("findPeakElementBinarySearch " + findPeakElementBinarySearch(arr6));
		System.out.println("findPeakElementLogN " + findPeakElementLogN(arr6));

		int arr7[] = { 2, 1 };
		System.out.println("findPeakElement " + findPeakElement(arr7));
		System.out.println("findPeakElementBinarySearch " + findPeakElementBinarySearch(arr7));
		System.out.println("findPeakElementLogN " + findPeakElementLogN(arr7));
	}

	public static int findPeakElement(int[] nums) {
		if (nums == null || nums.length == 0)
			return -1;

		boolean isPeak = true;
		int index = 0;
		int prev = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (prev > nums[i]) {
				if (isPeak) {
					index = i - 1;
					isPeak = false;
				}
			} else {
				isPeak = true;
			}

			prev = nums[i];
		}

		if (isPeak) {
			index = nums.length - 1;
		}

		return index;
	}

	public static int findPeakElementBinarySearch(int[] nums) {
		return helper(nums, 0, nums.length - 1);
	}

	public static int helper(int[] nums, int left, int right) {
		if (left == right) {
			return left;
		} else if (left + 1 == right) {
			if (nums[right] > nums[left])
				return right;
			return left;
		} else {
			int mid = (right - left) / 2 + left;
			if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1])
				return mid;
			else if (nums[mid - 1] > nums[mid] && nums[mid] > nums[mid + 1])
				return helper(nums, left, mid - 1);
			else
				return helper(nums, mid + 1, right);
		}
	}

	public static int findPeakElementLogN(int[] nums) {
		return findKthLargest(nums);
	}

	public static int findKthLargest(int[] nums) {
		int start = 0, end = nums.length - 1, index = nums.length - 1;
		while (start < end) {
			int pivot = partion(nums, start, end);
			if (pivot < index)
				start = pivot + 1;
			else if (pivot > index)
				end = pivot - 1;
			else
				return nums[pivot];
		}
		return nums[start];
	}

	private static int partion(int[] nums, int start, int end) {
		int pivot = start, temp;
		while (start <= end) {
			while (start <= end && nums[start] <= nums[pivot])
				start++;
			while (start <= end && nums[end] > nums[pivot])
				end--;
			if (start > end)
				break;
			temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
		}
		temp = nums[end];
		nums[end] = nums[pivot];
		nums[pivot] = temp;
		return end;
	}
}
