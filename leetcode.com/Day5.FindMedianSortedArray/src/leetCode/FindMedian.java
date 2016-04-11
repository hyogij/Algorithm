package leetCode;


/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.09
 Question Number : 20
 Link : https://leetcode.com/problems/median-of-two-sorted-arrays/
 ==========================================================
 */
public class FindMedian {

	/*
	 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
	 * Find the median of the two sorted arrays. The overall run time complexity
	 * should be O(log (m+n)).
	 */
	public static void main(String[] args) {
		int[] nums1 = {2, 4, 6, 8, 10};
		int[] nums2 = {1, 3, 5, 7, 9};

		System.out.println("findMedianSortedArrays "
				+ findMedianSortedArrays(nums1, nums2));
	}
	
	// Median : 홀수개인 경우에는 가장 중앙에 있는게 중앙값이다
	// 짝수개 있는 경우에는 두 수의 평균이다 
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

	}
}
