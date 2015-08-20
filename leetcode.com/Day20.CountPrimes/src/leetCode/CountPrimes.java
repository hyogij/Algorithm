package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.08.20
 Question Number : 79
 Link : https://leetcode.com/problems/count-primes/
 ==========================================================
 */

public class CountPrimes {
	/*
	 * Count the number of prime numbers less than a non-negative number, n.
	 */
	public static void main(String[] args) {
		System.out.println("countPrimes " + countPrimes(10));
		System.out.println("countPrimes " + countPrimes(2));
	}

	public static int countPrimes(int n) {
		int count = 0;
		boolean[] array = new boolean[n];

		for (int i = 2; i < n; i++) {
			if (array[i] == false) {
				for (int j = i + i; j < n; j += i) {
					array[j] = true;
				}
			}
		}

		for (int i = 2; i < n; i++) {
			if (array[i] == false) {
				count++;
			}
		}

		return count;
	}
}
