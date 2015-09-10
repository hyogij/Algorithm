package codility;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.09.10
 Lesson Number : 10
 Link : https://codility.com/demo/take-sample-test/min_avg_two_slice/
 ==========================================================
 */

public class MinAvgTwoSlice {
	/*
	 * A non-empty zero-indexed array A consisting of N integers is given. A
	 * pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of
	 * array A (notice that the slice contains at least two elements). The
	 * average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q]
	 * divided by the length of the slice. To be precise, the average equals
	 * (A[P] + A[P + 1] + ... + A[Q]) / (Q - P + 1).
	 * 
	 * For example, array A such that:
	 * 
	 * A[0] = 4 
	 * A[1] = 2 
	 * A[2] = 2 
	 * A[3] = 5 
	 * A[4] = 1 
	 * A[5] = 5 
	 * A[6] = 8 
	 * contains the following example slices:
	 * 
	 * slice (1, 2), whose average is (2 + 2) / 2 = 2; 
	 * slice (3, 4), whose average is (5 + 1) / 2 = 3; 
	 * slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5. 
	 * The goal is to find the starting position of a slice whose
	 * average is minimal.
	 * 
	 * Write a function:
	 * 
	 * class Solution { public int solution(int[] A); }
	 * 
	 * that, given a non-empty zero-indexed array A consisting of N integers,
	 * returns the starting position of the slice with the minimal average. If
	 * there is more than one slice with a minimal average, you should return
	 * the smallest starting position of such a slice.
	 * 
	 * For example, given array A such that:
	 * 
	 * A[0] = 4 
	 * A[1] = 2 
	 * A[2] = 2 
	 * A[3] = 5 
	 * A[4] = 1 
	 * A[5] = 5 
	 * A[6] = 8 
	 * the function should return 1, as explained above.
	 * 
	 * Assume that:
	 * N is an integer within the range [2..100,000]; 
	 * each element of array A is an integer within the range [-10,000..10,000]. 
	 * 
	 * Complexity:
	 * expected worst-case time complexity is O(N); 
	 * expected worst-case space complexity is O(N), 
	 * beyond input storage (not counting the storage required for input arguments). 
	 * 
	 * Elements of input arrays can be modified.
	 */
	public static void main(String[] args) {
		System.out.println("solution " + solution(0, 1, 11));
	}

	public int solution(int[] A) {
		// write your code in Java SE 8
		// 일단 가장 naive 한 솔루션은 
		// 하나를 시작으로, 2, 3, 4, ..., N-1 개 수행 O(n^3)이 된다  
		// 이를 개선한다고 하면 어떻게 하면 될까? 어떻게 O(n)으로 가능하지?
		// 
		for(int i=0; i<n; i++) {
			for(int j=2; j< n-1; j++) {
				for(int k=i; k<i+j; k++) {
				}
			}
		}
				}
			}
		}
	}
}
