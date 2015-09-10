package codility;

import java.util.HashSet;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.09.10
 Lesson Number : 6
 Link : https://codility.com/demo/take-sample-test/missing_integer/
 ==========================================================
 */

public class MissingInteger {
	/*
	 * Write a function:
	 * 
	 * int solution(int A[], int N);
	 * 
	 * that, given a non-empty zero-indexed array A of N integers, returns the
	 * minimal positive integer (greater than 0) that does not occur in A.
	 * 
	 * For example, given:
	 * 
	 * A[0] = 1
	 * A[1] = 3
	 * A[2] = 6 
	 * A[3] = 4 
	 * A[4] = 1 
	 * A[5] = 2 
	 * the function should return 5.
	 * 
	 * Assume that:
	 * N is an integer within the range [1..100,000]; 
	 * each element of array A is an integer within the range [-2,147,483,648..2,147,483,647]. 
	 * 
	 * Complexity:  
	 * expected worst-case time complexity is O(N); 
	 * expected worst-case space complexity is O(N), 
	 * beyond input storage (not counting the storage required for input arguments). 
	 * Elements of input arrays can be modified.
	 */

	public static void main(String[] args) {
		int[] A = {1, 3, 6, 4, 1, 2, 5, 7, 8, 9, 10};
		System.out.println("solution " + solution(A));
	}

	public static int solution(int[] A) {
		int max = Integer.MIN_VALUE;

		// Return 1 when array size is zero
		if (A.length == 0) {
			return 1;
		}

		// Use the HashSet to store existence of number in given array
		HashSet<Integer> hashSet = new HashSet<Integer>();
		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0) {
				hashSet.add(A[i]);
			}
			
			if (A[i] > max) {
				max = A[i];
			}
		}
		
		// Return 1 when the maximum number in array is negative value
		if (max < 0) {
			return 1;
		}

		// Return the minimal positive integer that does not occur in A
		for (int i = 1; i <= max; i++) {
			if (hashSet.contains(i) == false) {
				return i;
			}
		}
		
		return max + 1;
	}
}
