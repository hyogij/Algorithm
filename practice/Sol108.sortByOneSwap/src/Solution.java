import java.util.Arrays;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.06
 Problem : http://www.geeksforgeeks.org/sort-an-almost-sorted-array-where-only-two-elements-are-swapped/
 ==========================================================
 */
public class Solution {
	/*
	 * Given an almost sorted array where only two elements are swapped, how to
	 * sort the array efficiently?
	 * 
	 * Example Input: arr[] = {10, 20, 60, 40, 50, 30} // 30 and 60 are swapped
	 * Output: arr[] = {10, 20, 30, 40, 50, 60}
	 * 
	 * Input: arr[] = {10, 20, 40, 30, 50, 60} // 30 and 40 are swapped Output:
	 * arr[] = {10, 20, 30, 40, 50, 60}
	 * 
	 * Input: arr[] = {1, 5, 3} // 3 and 5 are swapped Output: arr[] = {1, 3, 5}
	 * 
	 * Expected time complexity is O(n) and only one swap operation to fix the
	 * array.
	 */
	public static void main(String[] args) {
		int[] arr1 = {10, 20, 60, 40, 50, 30};
		sortByOneSwap(arr1);
		System.out.println(Arrays.toString(arr1));

		int[] arr2 = {10, 20, 40, 30, 50, 60};
		sortByOneSwap(arr2);
		System.out.println(Arrays.toString(arr2));

		int[] arr3 = {1, 5, 3};
		sortByOneSwap(arr3);
		System.out.println(Arrays.toString(arr3));
		
		int[] arr4 = {5, 3};
		sortByOneSwap(arr4);
		System.out.println(Arrays.toString(arr4));
		
		int[] arr5 = {70, 20, 25, 30, 50, 60, 2};
		sortByOneSwap(arr5);
		System.out.println(Arrays.toString(arr5));
	}

	// This function sorts an array that can be sorted by single swap
	public static void sortByOneSwap(int arr[]) {
		if (arr == null || arr.length < 2)
			return;

		int index1 = 0, index2 = 0;
		// Traverse array from left to right
		int num = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (num > arr[i]) {
				index1 = i - 1;
				break;
			}
			num = arr[i];
		}

		// Traverse array from right to left
		num = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) {
			if (num < arr[i]) {
				index2 = i + 1;
				break;
			}
			num = arr[i];
		}

		// Swap index1 and index2
		swap(arr, index1, index2);
	}

	private static void swap(int[] arr, int index1, int index2) {
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	}
}
