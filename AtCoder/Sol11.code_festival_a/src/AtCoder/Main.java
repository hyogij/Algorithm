package AtCoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * This is the solution for problem #1 of Asian Elite Programming Contest.
 * 
 * @author Hyogi Jung(hyogij@gmail.com)
 * @date 2015-10-26
 * @url http://code-festival-2014-china-open.contest.atcoder.jp/tasks/
 *      code_festival_china_a
 */
public class Main {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		int[] number = new int[n];
		Arrays.fill(number, 0);
		int total = (int) Math.pow(10, n);
		System.out.println(total - 1);
		getPassCode(number, 0);
	}

	// Recursive function to find all pass codes
	private static void getPassCode(int[] number, int index) {
		if (index == number.length) {
			printNumber(number);
			return;
		}

		if (number[index] % 2 == 0) {
			for (int i = 0; i < 10; i++) {
				number[index] = i;
				getPassCode(number, index + 1);
			}
		} else {
			for (int i = 9; i >= 0; i--) {
				number[index] = i;
				getPassCode(number, index + 1);
			}
		}
	}

	private static void printNumber(int[] number) {
		for (int i = 0; i < number.length; i++) {
			System.out.print(number[i]);
		}
		System.out.println();
	}
}
