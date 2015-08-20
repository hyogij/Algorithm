package leetCode;


/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.08.20
 Question Number : 80
 Link : https://leetcode.com/problems/ugly-number/
 ==========================================================
 */

public class UglyNumber {
	/*
	 * Write a program to check whether a given number is an ugly number.
	 * 
	 * Ugly numbers are positive numbers whose prime factors only include 2, 3,
	 * 5. For example, 6, 8 are ugly while 14 is not ugly since it includes
	 * another prime factor 7.
	 * 
	 * Note that 1 is typically treated as an ugly number.
	 */
	public static void main(String[] args) {
		System.out.println("isUgly " + isUgly(0));
		System.out.println("isUgly " + isUgly(6));
		System.out.println("isUgly " + isUgly(14));
		System.out.println("isUgly " + isUgly(905391974));
		System.out.println("isUgly " + isPrime(905391974));
	}

	public static boolean isUgly(int num) {
		// Find prime factors of given number
		for (int i = 2; i <= 5 && i <= num; i++) {
			while (num % i == 0) {
				// Only 2, 3 and 5 are accepted
				if (i != 2 && i != 3 && i != 5) {
					return false;
				}
				num /= i;
			}
		}

		if (num == 1) {
			return true;
		} else {
			return false;
		}
	}

	// Return true if number is prime, otherwise return false
	public static boolean isPrime(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}

		return true;
	}
}
