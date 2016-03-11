/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.11
 Problem : http://www.geeksforgeeks.org/pancake-sorting/
 ==========================================================
 */
public class Solution {
	/*
	 * Given an an unsorted array, sort the given array. You are allowed to do
	 * only following operation on array.
	 * 
	 * flip(arr, i): Reverse array from 0 to i Unlike a traditional sorting
	 * algorithm, which attempts to sort with the fewest comparisons possible,
	 * the goal is to sort the sequence in as few reversals as possible.
	 */

	/* Driver function to check for above functions */
	public static void main(String[] args) {
		int arr[] = {23, 10, 20, 11, 12, 6, 7};
		int n = arr.length;
		pancakeSort(arr, n);
		System.out.println("Sorted Array:  ");
		printArray(arr);
	}

	/* Utility function to print array arr[] */
	private static void printArray(int arr[]) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println("");
	}

	private static void pancakeSort(int[] arr, int num) {
		for (int i = 0; i < num; i++) {
			int min = findMin(arr, i);
			flip(arr, i, min);
		}
	}

	private static void flip(int[] arr, int left, int right) {
		int mid = (right - left) / 2 + left;
		while (left <= mid) {
			int tmp = arr[left];
			arr[left] = arr[right];
			arr[right] = tmp;

			left++;
			right--;
		}
	}

	private static int findMin(int[] arr, int start) {
		int min = Integer.MAX_VALUE;
		int index = -1;
		for (int i = start; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
				index = i;
			}
		}

		return index;
	}
}
