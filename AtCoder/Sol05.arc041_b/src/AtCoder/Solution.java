package AtCoder;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/*
==========================================================
Author : Hyogi Jung(hyogij@gmail.com)
Date : 2015.10.22
Question Number : 5
Link : http://arc041.contest.atcoder.jp/tasks/arc041_b
==========================================================
*/

public class Solution {
	public static void main(String args[]) {
		// Get the standard input
		Scanner scanner = new Scanner(System.in);

		int heads = 0, tails = 0, flips = 0;

		try {
			heads = scanner.nextInt();
			tails = scanner.nextInt();
			flips = scanner.nextInt();

			findSolution(heads, tails, flips);
		} catch (InputMismatchException e) {
			System.out.println(e.getMessage());
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// Find the maximum number of head coins
	private static void findSolution(int heads, int tails, int flips) {
		if (tails >= flips) {
			// Only tails coin can be flipped
			heads += flips;
		} else {
			// All tails coin is flipped so the number of head coins is
			// increased
			heads += tails;
			heads -= (flips - tails);
		}

		// Print the number of head coins
		System.out.println(heads);
	}
}
