/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.12.20
 Practice Number : 3
 ==========================================================
 */
public class Solution {
	/*
	 * The adjacency of coins is the number of adjacent pairs of coins showing
	 * the same face. Returns the maximum possible adjacency that can be
	 * obtained by reversing exactly one coin(that is, one of the coins must be
	 * reversed).
	 */
	public static void main(String[] args) {
		 int[] A = { 0, 1, 0, 0, 0, 0 };
//		 int[] A = { 0, 0, 1, 1, 0, 0, 0, 0 };
//		int[] A = {0, 1, 0};
//		 int[] A = { 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0 };
//		 int[] A = { 0, 0, 0, 1, 0}; // Problems
//		int[] A = { 0, 1};
		System.out.println("solution " + solution(A));
	}

	static int solution(int[] A) {
		int n = A.length;
		int result = 0;
		for (int i = 0; i < n - 1; i++) {
			if (A[i] == A[i + 1])
				result = result + 1;
		}

		int r = 0;
		for (int i = 0; i < n; i++) {
			int count = 0;
			if (i > 0) {
				if (A[i - 1] != A[i]) {
					count = count + 1;
				} else {
					count = count - 1;
				}
			}
			System.out.println("count2 " + count);

			if (i < n - 1) {
				if (A[i + 1] != A[i]) {
					count = count + 1;
				} else {
					count = count - 1;
				}
			}
			System.out.println("count2 " + count);

			// The maximum value of r is 2
			r = Math.max(r, count);
			System.out.println("r " + r);
		}

		return result + r;
	}
}
