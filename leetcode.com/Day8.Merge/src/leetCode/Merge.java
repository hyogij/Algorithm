package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.14
 Question Number : 39
 Link : https://leetcode.com/problems/merge-sorted-array/
 ==========================================================
 */
public class Merge {
	/*
	 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1
	 * as one sorted array.
	 * 
	 * Note: You may assume that nums1 has enough space (size that is greater or
	 * equal to m + n) to hold additional elements from nums2. The number of
	 * elements initialized in nums1 and nums2 are m and n respectively.
	 */
	public static void main(String[] args) {
		int[] nums1 = new int[6];
		nums1[0] = 4;
		int[] nums2 = {1, 2, 3, 5, 6};
		
		merge(nums1, 1, nums2, 5);
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int write = m + n - 1;
		int i = 0, j = 0;
		
		// Compares two values in array after that places the bigger one to the
		// rear of nums1 array
		for (; m - 1 - i >= 0 && n - 1 - j >= 0;) {
			if (nums1[m - 1 - i] <= nums2[n - 1 - j]) {
				nums1[write--] = nums2[n - 1 - j];
				j++;
			} else {
				nums1[write--] = nums1[m - 1 - i];
				i++;
			}
		}

		// Copies remain elements in array
		if (n - 1 - j >= 0) {
			for (; n - 1 - j >= 0;) {
				nums1[write--] = nums2[n - 1 - j];
				j++;
			}
		}
	}
}
