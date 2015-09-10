package codility;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.09.10
 Lesson Number : 8
 Link : https://codility.com/demo/take-sample-test/count_div/
 ==========================================================
 */

public class CountDiv {
	/*
	 * Write a function:
	 * 
	 * class Solution { public int solution(int A, int B, int K); }
	 * 
	 * that, given three integers A, B and K, returns the number of integers
	 * within the range [A..B] that are divisible by K, i.e.:
	 * 
	 * { i : A ¡Â i ¡Â B, i mod K = 0 }
	 * 
	 * For example, for A = 6, B = 11 and K = 2, your function should return 3,
	 * because there are three numbers divisible by 2 within the range [6..11],
	 * namely 6, 8 and 10.
	 * 
	 * Assume that:
	 * A and B are integers within the range [0..2,000,000,000]; 
	 * K is an integer within the range [1..2,000,000,000]; 
	 * A ¡Â B. 
	 * Complexity:
	 * expected worst-case time complexity is O(1); 
	 * expected worst-case space complexity is O(1).
	 */
	public static void main(String[] args) {
		System.out.println("solution " + solution(0, 1, 11));
	}

	public static int solution(int A, int B, int K) {
		if(B < K) {
			return 0;
		}
		
		int num1 = A / K;
		if(A % K != 0) {
			num1++;
		}
		
		int num2 = B / K;
		
		return num2 - num1 + 1;
	}
}
