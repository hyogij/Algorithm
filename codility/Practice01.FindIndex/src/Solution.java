/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.12.21
 Practice Number : 1
 ==========================================================
 */
public class Solution {
	/*
	 * Given two non-negative integers A and B, returns the leftmost position at
	 * which A occurs in B. The function should return -1 if A does not occur in
	 * B. This solution focus on correctness. The performance of solution will
	 * not be the focus of the assessment.
	 */
	public static void main(String[] args) {
		System.out.println("solution " + solution(53, 1953786));
		System.out.println("solution " + solution(78, 195378678));
		System.out.println("solution " + solution(79, 195378678));
	}

	public static int solution(int A, int B) {
		// write your code in Java SE 8
		String strA = String.valueOf(A);
		String strB = String.valueOf(B);

		int position = strB.indexOf(strA);
		return position;
	}
}
