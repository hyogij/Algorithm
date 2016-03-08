/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.08
 Problem : http://www.geeksforgeeks.org/equilibrium-index-of-an-array/
 https://leetcode.com/discuss/71253/find-the-equilibrium-index-in-the-array
 ==========================================================
 */
public class Solution {
	/*
	 * Equilibrium index of an array is an index such that the sum of elements
	 * at lower indexes is equal to the sum of elements at higher indexes. For
	 * example, in an array A:
	 * A[0] = -7, A[1] = 1, A[2] = 5, A[3] = 2, A[4] = -4, A[5] = 3, A[6]=0
	 * A = {-7, 1, 5, 2, -4, 3, 0}
	 * 
	 * 3 is an equilibrium index, because: A[0] + A[1] + A[2] = A[4] + A[5] +
	 * A[6]
	 * 
	 * 6 is also an equilibrium index, because sum of zero elements is zero,
	 * i.e., A[0] + A[1] + A[2] + A[3] + A[4] + A[5]=0
	 * 
	 * 7 is not an equilibrium index, because it is not a valid index of array
	 * A.
	 * 
	 * Write a function int equilibrium(int[] arr, int n); that given a sequence
	 * arr[] of size n, returns an equilibrium index (if any) or -1 if no
	 * equilibrium indexes exist.
	 */
	public static void main(String[] args) {
		int [] array = {-7, 1, 5, 2, -4, 3, 0};
		System.out.println("equilibrium " + equilibrium(array));
		System.out.println("equilibriumAdvanced " + equilibriumAdvanced(array));
	}
	
	// Traverse the index of array, calculates sum of left part and right part.
	// If the values are equal, then return certain index.
	public static int equilibrium(int[] arr) {
		for (int index = 0; index < arr.length; index++) {
			int sumOfLeft = calculateSum(arr, 0, index);
			int sumOfRight = calculateSum(arr, index + 1, arr.length);
			if (sumOfLeft == sumOfRight) {
				return index;
			}
		}

		return -1;
	}

	private static int calculateSum(int[] arr, int left, int right) {
		int sum = 0;
		for (int i = left; i < right; i++) {
			sum += arr[i];
		}
		return sum;
	}

	// Time complexity is O(n). At first, calculates sum of array. Subtracts
	// certain number of array, this value could be divided into 2, then returns
	// current index.
	public static int equilibriumAdvanced(int[] arr) {
		int sum = calculateSum(arr, 0, arr.length);

		for (int i = 0; i < arr.length; i++) {
			if (sum - arr[i] % 2 == 0) {
				return i;
			}
		}
		return -1;
	}
}
