package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.08.20
 Question Number : 79
 Link : https://leetcode.com/problems/count-primes/
 ==========================================================
 */

public class CountPrimesPractice {
	/*
	 * Count the number of prime numbers less than a non-negative number, n.
	 */
	public static void main(String[] args) {
		System.out.println("countPrimes " + countPrimes(10));
		System.out.println("countPrimes " + countPrimes(2));
		System.out.println("countPrimes " + countPrimes(3));
	}

	public static int countPrimes(int n) {
		// Initialize all number are not a prime number
		boolean array[] = new boolean[n];

		for (int i = 2; i < n; i++) {
			if (array[i] == false) {
				for (int j = i * 2; j < n; j += i) {
					array[j] = true;
				}
			}
		}

		int count = 0;
		for (int i = 2; i < n; i++) {
			if (array[i] == false) {
				count++;
			}
		}

		return count;
	}
}
