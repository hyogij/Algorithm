package AtCoder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.10.02
 Question Number : 1
 Link : http://arc001.contest.atcoder.jp/tasks/arc001_1
 ==========================================================
 */
	
public class Solution {
	/*
	 * The problem is finding the minimum and maximum number in Takahasi's
	 * answers. Takahasi doesn't remember his answsers. So we have to guess the
	 * number of correct answers. The solutions of problems could be 1 to 4.
	 * Then, find the the minimum and maximum number in his answers.
	 */
	private static final String FILE_NAME = "input.txt";
	private static final int NUMBER_OF_SOLUTIONS = 4;
	
	public static void main(String args[]) {
		int problems = 0;
		String solutions = null;

		try {
			BufferedReader in = new BufferedReader(new FileReader(FILE_NAME));

			// First line means the number of problems
			problems = Integer.valueOf(in.readLine());
			// Second line means the solutions of problems
			solutions = in.readLine();

			in.close();
		} catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}
		printMinMax(problems, solutions);
	}

	private static void printMinMax(int problems, String solutions) {
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		int[] counts = new int[NUMBER_OF_SOLUTIONS];
		for (int i = 0; i < solutions.length(); i++) {
			int num = Character.getNumericValue(solutions.charAt(i)) - 1;
			counts[num]++;
		}

		// Find the min and max value in counts array and print the values
		for (int i = 0; i < NUMBER_OF_SOLUTIONS; i++) {
			if (counts[i] > max) {
				max = counts[i];
			}
			if (counts[i] < min) {
				min = counts[i];
			}
		}

		System.out.print(max);
		System.out.print(" ");
		System.out.println(min);
	}
}
