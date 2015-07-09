package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.09
 Question Number : 18
 Link : https://leetcode.com/problems/sqrtx/
 ==========================================================
 */
public class sqrtx {
	/*
	 * Implement int sqrt(int x).
	 * 
	 * Compute and return the square root of x.
	 * 
	 * Here is my question about this problem. If result value is not integer,
	 * then how can I return result? Answer : Returns the maximum integer value
	 * that is not bigger than square root of x
	 */
	public static void main(String[] args) {
		int x = 2147395599; // This value is maximum integer value in JAVA
		System.out.println("mySqrt : " + mySqrtAdv(x));
	}

	// Below is brute-force method, it takes a lot of time if the argument is
	// maximum integer value. Its time complexity is O(n)
	public static int mySqrt(int x) {
		int result = -1; // Not found
		for (int i = x / 2; i > 0; i--) {
			if (i * i == x) {
				return i;
			}
		}
		return result;
	}

	// Mid and square values' data type are long to avoid overflow.
	// This method's time complexity is O(logn)
	public static int mySqrtAdv(int x) {
		if (x < 0) {
			return -1;
		}

		if (x <= 1) {
			return x;
		}

		// Uses binary search to find square root
		int left = 0, right = x / 2 + 1;
		while (left <= right) {
			long mid = left + (right - left) / 2;
			long square = mid * mid;

			if (square == x) {
				return (int) mid;
			} else if (square < x) {
				left = (int) mid + 1;
			} else {
				right = (int) mid - 1;
			}
		}
		return (int) right;
	}
}