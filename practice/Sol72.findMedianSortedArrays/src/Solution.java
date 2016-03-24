/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.23
 Problem : https://leetcode.com/problems/median-of-two-sorted-arrays/
 ==========================================================
 */
public class Solution {
	/*
	 * Median: In probability theory and statistics, a median is described as
	 * the number separating the higher half of a sample, a population, or a
	 * probability distribution, from the lower half. The median of a finite
	 * list of numbers can be found by arranging all the numbers from lowest
	 * value to highest value and picking the middle one.
	 * 
	 * For getting the median of input array { 12, 11, 15, 10, 20 }, first sort
	 * the array. We get { 10, 11, 12, 15, 20 } after sorting. Median is the
	 * middle element of the sorted array which is 12.
	 * 
	 * There are different conventions to take median of an array with even
	 * number of elements, one can take the mean of the two middle values, or
	 * first middle value, or second middle value.
	 * 
	 * Let us see different methods to get the median of two sorted arrays of
	 * size n each. Since size of the set for which we are looking for median is
	 * even (2n), we are taking average of middle two numbers in all below
	 * solutions.
	 * 
	 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
	 * Find the median of the two sorted arrays. The overall run time complexity
	 * should be O(log (m+n)).
	 */
	public static void main(String[] args) {
		int ar1[] = {1, 12, 15, 26, 38};
		int ar2[] = {2, 13, 17, 30, 45};

		System.out.println("findMedianSortedArrays "
				+ findMedianSortedArrays(ar1, ar2));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double median = 0;

		if (nums1 == null || nums2 == null)
			return median;

		// The median value is middle value when number of elements in array are
		// odd. If number of elements in array are even, the median value is
		// average of two values.
		int total = nums1.length + nums2.length;
		int index = total / 2;
		int middle = findKthSortedArrays(nums1, nums2, index);
		if (total % 2 == 0) {
			median = (middle + findKthSortedArrays(nums1, nums2, index + 1)) / 2;
		} else {
			median = middle;
		}

		return median;
	}

	public static int findKthSortedArrays(int[] nums1, int[] nums2, int k) {
		return kthElementAdvanced(nums1, nums2, nums1.length, nums2.length,
				k);
	}

	public static int kthElementAdvanced(int[] array1, int[] array2,
			int length1, int length2, int k) {
		// array2 is longer than array1
		if (length1 > length2) {
			return kthElementAdvanced(array2, array1, length2, length1, k);
		}

		if (length1 == 0 && length2 > 0) {
			return array2[k - 1];
		}

		if (k == 1) {
			return Math.min(array1[k - 1], array2[k - 1]);
		}

		int i = Math.min(length1, k / 2);
		int j = Math.min(length2, k / 2);

		int[] copied1 = null, copied2 = null;
		if (array1[i - 1] > array2[j - 1]) {
			copied1 = new int[i];
			System.arraycopy(array1, 0, copied1, 0, i);
			copied2 = new int[length2 - j];
			System.arraycopy(array2, j, copied2, 0, length2 - j);
			return kthElementAdvanced(copied1, copied2, i, length2 - j, k - j);
		} else {
			copied1 = new int[length1 - i];
			System.arraycopy(array1, i, copied1, 0, length1 - i);
			copied2 = new int[j];
			System.arraycopy(array2, 0, copied2, 0, j);
			return kthElementAdvanced(copied1, copied2, length1 - i, j, k - i);
		}
	}
}
