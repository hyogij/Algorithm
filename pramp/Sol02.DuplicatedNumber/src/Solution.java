import java.util.Arrays;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.02.05
 Question Number : 02
 Description : Duplicated Number in two arrays
 ==========================================================
 */
public class Solution {
	/*
	 * Given two arrays of US social security numbers: Arr1 and Arr2 of lengths
	 * n and m respectively, how can you most efficiently compute an array of
	 * all persons included on both arrays?
	 * 
	 * Solve and analyze the complexity for 2 cases: 1. m = n - lengths are
	 * approximately the same 2. m ¡í n - one is much longer than the other
	 */
	public static void main(String[] args) {
		int[] arr1 = {11, 12, 13, 14, 15, 16};
		int[] arr2 = {12, 14, 15, 16, 17, 18};

		System.out.print("\nfindDuplicatedNumber1 ");
		findDuplicatedNumber1(arr1, arr2);
		System.out.print("\nfindDuplicatedNumber2 ");
		findDuplicatedNumber2(arr1, arr2);
	}

	// Time complexity is O(n)
	private static void findDuplicatedNumber1(int[] arr1, int[] arr2) {
		int idx1 = 0, idx2 = 0;
		for (; idx1 < arr1.length && idx2 < arr2.length;) {
			if (arr1[idx1] == arr2[idx2]) {
				System.out.print(" " + arr1[idx1]);
				idx1++;
				idx2++;
			} else if (arr1[idx1] < arr2[idx2]) {
				idx1++;
			} else if (arr1[idx1] > arr2[idx2]) {
				idx2++;
			}
		}
	}

	// Time complexity is O(nlogm)
	// If we don't use binary search, then the time complexity is O(mn)
	private static void findDuplicatedNumber2(int[] arr1, int[] arr2) {
		int idx1 = 0;
		for (; idx1 < arr1.length; idx1++) {
			int num = Arrays.binarySearch(arr2, arr1[idx1]);
			if (num >= 0) {
				System.out.print(" " + arr2[num]);
			}
		}
	}
}
