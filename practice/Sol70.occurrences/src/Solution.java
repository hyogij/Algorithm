
/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.23
 Problem : http://www.geeksforgeeks.org/count-number-of-occurrences-in-a-sorted-array/
 ==========================================================
 */
public class Solution {
	/*
	 * Given a sorted array arr[] and a number x, write a function that counts
	 * the occurrences of x in arr[]. Expected time complexity is O(Logn)
	 * 
	 * Examples:
	 * Input: arr[] = {1, 1, 2, 2, 2, 2, 3,}, x = 2 Output: 4 
	 * // x (or 2) occurs 4 times in arr[]
	 * Input: arr[] = {1, 1, 2, 2, 2, 2, 3,}, x = 3 Output: 1
	 * Input: arr[] = {1, 1, 2, 2, 2, 2, 3,}, x = 1 Output: 2
	 * Input: arr[] = {1, 1, 2, 2, 2, 2, 3,}, x = 4 Output: -1 
	 * // 4 doesn't occur in arr[]
	 */
	public static void main(String[] args) {
		int [] arr = {1, 1, 2, 2, 2, 2, 3, 3, 5};
		System.out.println("occurrences " + occurrences(arr, 1));
		System.out.println("occurrences " + occurrences(arr, 2));
		System.out.println("occurrences " + occurrences(arr, 3));
		System.out.println("occurrences " + occurrences(arr, 4));
		System.out.println("occurrences " + occurrences(arr, 5));
	}
	
	public static int occurrences(int[] arr, int x) {
		if (arr == null | arr.length == 0)
			return -1;

		// Find first and last index of given number
		int first = findFirstIndex(arr, x, 0, arr.length - 1);
		int last = findLastIndex(arr, x, 0, arr.length - 1);
		if (first == -1 || last == -1)
			return -1;

		return (last - first + 1);
	}

	private static int findFirstIndex(int[] arr, int x, int left, int right) {
		if (left > right)
			return -1;

		int mid = (right - left) / 2 + left;
		if (arr[mid] == x) {
			if (mid != 0 && arr[mid - 1] == arr[mid])
				return findFirstIndex(arr, x, left, mid - 1);
			return mid;
		} else if (arr[mid] > x) {
			return findFirstIndex(arr, x, left, mid - 1);
		} else {
			return findFirstIndex(arr, x, mid + 1, right);
		}
	}
	
	private static int findLastIndex(int[] arr, int x, int left, int right) {
		if (left > right)
			return -1;

		int mid = (right - left) / 2 + left;
		if (arr[mid] == x) {
			if (mid != arr.length -1 && arr[mid + 1] == arr[mid])
				return findLastIndex(arr, x, mid + 1, right);
			return mid;
		} else if (arr[mid] > x) {
			return findLastIndex(arr, x, left, mid - 1);
		} else {
			return findLastIndex(arr, x, mid + 1, right);
		}
	}
}
