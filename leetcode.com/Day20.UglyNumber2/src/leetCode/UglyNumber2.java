package leetCode;

import java.util.PriorityQueue;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.08.20
 Question Number : 81
 Link : https://leetcode.com/problems/ugly-number-ii/
 ==========================================================
 */

public class UglyNumber2 {
	/*
	 * Write a program to find the n-th ugly number.
	 * 
	 * Ugly numbers are positive numbers whose prime factors only include 2, 3,
	 * 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the
	 * first 10 ugly numbers.
	 * 
	 * Note that 1 is typically treated as an ugly number.
	 */
	public static void main(String[] args) {
		System.out.println("nthUglyNumber 1 " + nthUglyNumberFast(1));
		System.out.println("nthUglyNumber 2 " + nthUglyNumberFast(2));
		System.out.println("nthUglyNumber 8 " + nthUglyNumberFast(7));
		System.out.println("nthUglyNumber 12 " + nthUglyNumberFast(10));
		System.out.println("nthUglyNumber 294912 " + nthUglyNumberFast(395));
		System.out
				.println("nthUglyNumber 536870912 " + nthUglyNumberFast(1407));
	}

	public static int nthUglyNumberFast(int n) {
		// Use priority queue to store multiple of 2, 3 and 5. And remove the
		// minimum value of stored number in priority queue
		// Priority queue is just adding element without checking duplication.
		// So we have to check before inserting number. We use Long type because
		// of overflow.
		PriorityQueue<Long> q = new PriorityQueue<Long>();
		Long nthUglyNumber = 1l;
		Long num = 0l;

		q.add(nthUglyNumber);
		while (n > 0 && q.isEmpty() == false) {
			nthUglyNumber = q.remove();
			n--;

			num = nthUglyNumber * 2;
			if (q.contains(num) == false) {
				q.add(num);
			}
			num = nthUglyNumber * 3;
			if (q.contains(num) == false) {
				q.add(num);
			}
			num = nthUglyNumber * 5;
			if (q.contains(num) == false) {
				q.add(num);
			}
		}

		return nthUglyNumber.intValue();
	}

	// Native approach to find nth ugly number using isUgly() method. It could
	// be time limit exceeded.
	public static int nthUglyNumber(int n) {
		int i = 1;
		for (; n > 0; i++) {
			if (isUgly(i)) {
				n--;
			}
		}

		return i - 1;
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
}