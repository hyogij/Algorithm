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
	 * Example
	 * Input: arr[] = {10, 20, 60, 40, 50, 30} // 30 and 60 are swapped 
	 * Output: arr[] = {10, 20, 30, 40, 50, 60}
	 * 
	 * Input: arr[] = {10, 20, 40, 30, 50, 60} // 30 and 40 are swapped 
	 * Output: arr[] = {10, 20, 30, 40, 50, 60}
	 * 
	 * Input: arr[] = {1, 5, 3} // 3 and 5 are swapped 
	 * Output: arr[] = {1, 3, 5}
	 * 
	 * Expected time complexity is O(n) and only one swap operation to fix the
	 * array.
	 */
	public static void main(String[] args) {
		int[] arr1 = {10, 20, 60, 40, 50, 30};
		System.out.println(Arrays.toString(arr1));
		
		int[] arr2 = {10, 20, 40, 30, 50, 60};
		System.out.println(Arrays.toString(arr2));
		
		int[] arr3 = {1, 3, 5};
		System.out.println(Arrays.toString(arr3));
	}

	// This function sorts an array that can be sorted by single swap
	public static void sortByOneSwap(int arr[]) {

	}
}
