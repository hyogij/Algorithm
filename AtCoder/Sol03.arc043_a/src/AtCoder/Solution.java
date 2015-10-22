package AtCoder;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.10.22
 Question Number : 3
 Link : http://arc043.contest.atcoder.jp/tasks/arc043_a
 ==========================================================
 */

public class Solution {
	public static void main(String args[]) {
		// 자바 표준 입력
		Scanner scanner = new Scanner(System.in);

		int loop = 0, average = 0, difference = 0;
		int[] nums = null;

		try {
			loop = scanner.nextInt();
			average = scanner.nextInt();
			difference = scanner.nextInt();

			nums = new int[loop];
			for (int i = 0; i < loop; i++) {
				nums[i] = scanner.nextInt();
			}

			findSolution(nums, average, difference);
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

	private static void findSolution(int[] nums, int average, int difference) {
		// P×Si+Q
		int p = 0, q = 0;
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		int total1 = average * nums.length;
		int[] convertedNums = new int[nums.length];

		int total2 = 0;
		for (int num : nums) {
			total2 += num;
		}

		total1 = total2 * p + nums.length * q;
	}
}