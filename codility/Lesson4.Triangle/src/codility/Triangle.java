package codility;

import java.util.Arrays;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.09.10
 Lesson Number : 15
 Link : https://codility.com/demo/take-sample-test/triangle/
 ==========================================================
 */

public class Triangle {
	/*
	 * A zero-indexed array A consisting of N integers is given. A triplet (P,
	 * Q, R) is triangular if 0 ¡Â P < Q < R < N and:
	 * 
	 * A[P] + A[Q] > A[R], 
	 * A[Q] + A[R] > A[P], 
	 * A[R] + A[P] > A[Q]. 
	 * 
	 * For example, consider array A such that:
	 * A[0] = 10 
	 * A[1] = 2 
	 * A[2] = 5 
	 * A[3] = 1 
	 * A[4] = 8 
	 * A[5] = 20 
	 * Triplet (0, 2, 4) is triangular.
	 * 
	 * Write a function:
	 * class Solution { public int solution(int[] A); }
	 * 
	 * that, given a zero-indexed array A consisting of N integers, returns 1 if
	 * there exists a triangular triplet for this array and returns 0 otherwise.
	 * 
	 * For example, given array A such that:
	 * A[0] = 10 
	 * A[1] = 2 
	 * A[2] = 5 
	 * A[3] = 1 
	 * A[4] = 8 
	 * A[5] = 20 
	 * the function should return 1, as explained above. 
	 * 
	 * Given array A such that:
	 * A[0] = 10 
	 * A[1] = 50 
	 * A[2] = 5 
	 * A[3] = 1 
	 * the function should return 0.
	 * 
	 * Assume that:
	 * N is an integer within the range [0..100,000]; 
	 * each element of array A is an integer within the range [-2,147,483,648..2,147,483,647]. 
	 * 
	 * Complexity:
	 * expected worst-case time complexity is O(N*log(N)); 
	 * expected worst-case space complexity is O(N), 
	 * beyond input storage (not counting the storage required for input arguments). 
	 * 
	 * Elements of input arrays can be modified.
	 */
	public static void main(String[] args) {
		int[] A = {10, 2, 5, 1, 8, 20};
		System.out.println("solution " + solution(A));
	}

	public static int solution(int[] A) {
		if (A == null || A.length < 3) {
			return 0;
		}

		// http://codesays.com/2014/solution-to-triangle-by-codility/
		// if we have any inequality holding for out-of-order elements, we MUST have
		// AT LEAST an inequality holding for three consecutive elements.
		Arrays.sort(A);
		for (int i = 0; i < A.length - 2; i++) {
			if (A[i] < 0) {
				continue;
			}
			if (A[i] + A[i + 1] > A[i + 2]) {
				return 1;
			}
		}
		return 0;
	}

	
	public static int solutionSlow(int[] A) {
		// Below algorithm's time complexity is O(n^3). We have to reduce this
		// time from O(n^3) to O(nlong). How we can do that?
		// Do I use sort which time complexity is O(nlong). How can I solve this
		// using sort?
		// It doesn't return the nubmer of triangular triplet, it just returns 1
		// or 0.
		for (int i = 0; i < A.length - 2; i++) {
			if (A[i] < 0) {
				continue;
			}
			for (int j = i + 1; j < A.length - 1; j++) {
				if (A[j] < 0) {
					continue;
				}	
				for (int k = j + 1; k < A.length; k++) {
					if (A[k] < 0) {
						continue;
					}	
					if(isTriangle(A, i, j, k) == true) {
						return 1;
					}
				}
			}
		}

		return 0;
	}

	public static boolean isTriangle(int[] A, int p, int q, int r) {
		int valueP = A[p], valueQ = A[q], valueR = A[r];

		// Below lines could occur overflow
		if (valueP + valueQ > valueR && valueQ + valueR > valueP
				&& valueR + valueP > valueQ) {
			return true;
		}
		return false;
	}
}
