package codility;

import java.util.HashSet;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.09.09
 Lesson Number : 4
 Link : https://codility.com/demo/take-sample-test/frog_river_one/
 ==========================================================
 */

public class FrogRiverOne {
	/*
	 * A small frog wants to get to the other side of a river. The frog is
	 * currently located at position 0, and wants to get to position X. Leaves
	 * fall from a tree onto the surface of the river.
	 * 
	 * You are given a non-empty zero-indexed array A consisting of N integers
	 * representing the falling leaves. A[K] represents the position where one
	 * leaf falls at time K, measured in seconds.
	 * 
	 * The goal is to find the earliest time when the frog can jump to the other
	 * side of the river. The frog can cross only when leaves appear at every
	 * position across the river from 1 to X. You may assume that the speed of
	 * the current in the river is negligibly small, i.e. the leaves do not
	 * change their positions once they fall in the river.
	 * 
	 * For example, you are given integer X = 5 and array A such that:
	 * 
	 * A[0] = 1 
	 * A[1] = 3 
	 * A[2] = 1 
	 * A[3] = 4 
	 * A[4] = 2 
	 * A[5] = 3 
	 * A[6] = 5 
	 * A[7] = 4
	 * In second 6, a leaf falls into position 5. This is the earliest time when
	 * leaves appear in every position across the river.
	 * 
	 * Write a function:
	 * 
	 * class Solution { public int solution(int X, int[] A); }
	 * 
	 * that, given a non-empty zero-indexed array A consisting of N integers and
	 * integer X, returns the earliest time when the frog can jump to the other
	 * side of the river.
	 * 
	 * If the frog is never able to jump to the other side of the river, the
	 * function should return -1.
	 * 
	 * For example, given X = 5 and array A such that:
	 * 
	 * A[0] = 1 
	 * A[1] = 3 
	 * A[2] = 1 
	 * A[3] = 4 
	 * A[4] = 2 
	 * A[5] = 3 
	 * A[6] = 5 
	 * A[7] = 4
	 * the function should return 6, as explained above.
	 * 
	 * Assume that:
	 * N and X are integers within the range [1..100,000]; 
	 * each element of array A is an integer within the range [1..X]. Complexity:
	 * 
	 * expected worst-case time complexity is O(N); 
	 * expected worst-case space complexity is O(X), beyond input storage 
	 * (not counting the storage required for input arguments). 
	 * Elements of input arrays can be modified.
	 */
	public static void main(String[] args) {
		int[] A = {1, 3, 1, 4, 2, 3, 5, 4};
		System.out.println("solution " + solution2(5, A));
	}
	
	public static int solution2(int X, int[] A) {
		HashSet<Integer> hashSet = new HashSet<Integer>();

		for (int i = 0; i < A.length; i++) {
			if (A[i] <= X) {
				hashSet.add(A[i]);
			}
			if (hashSet.size() == X) {
				return i;
			}
		}

		return -1;
	}

	// Use integer arrays to store the existence of number from the array
	private static int[] bits;
	private static int bitsNum = 0;
	
	// Use integer arrays to check every position across the river
	public static int solution(int X, int[] A) {
		bitsNum = (X / 32) + 1;
		bits = new int[bitsNum];

		for (int i = 1; i <= X; i++) {
			setBit(i);
		}
		
		for (int i = 0; i < A.length; i++) {
			if (A[i] <= X) {
				clearBit(A[i]);
				if (checkBit() == true) {
					return i;
				}
			}
		}
		return -1;
	}

	public static void setBit(int num) {
		int position = (num / 32);
		int offset = num % 32;
		bits[position] |= (1 << offset);
	}
	
	public static void clearBit(int num) {
		int position = (num / 32);
		int offset = num % 32;
		bits[position] &= ~(1 << offset);
	}

	public static boolean checkBit() {
		for (int i = 0; i < bitsNum; i++) {
			if (bits[i] != 0) {
				return false;
			}
		}
		return true;
	}
}
