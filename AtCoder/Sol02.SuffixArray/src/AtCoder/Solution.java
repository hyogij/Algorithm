package AtCoder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
==========================================================
Author : Hyogi Jung(hyogij@gmail.com)
Date : 2015.10.02
Question Number : 2
Link : http://arc044.contest.atcoder.jp/tasks/arc044_d
==========================================================
*/

public class Solution {
	/*
	 * The problem is finding the minimum and maximum number in Takahasi's
	 * answers. Takahasi doesn't remember his answsers. So we have to guess the
	 * number of correct answers. The solutions of problems could be 1 to 4.
	 * Then, find the the minimum and maximum number in his answers.
	 */
	/*
	 *
Mr. Cooper, the CEO of CozyWalk Co., 
receives a report of daily sales every day since the company has been established. 
Starting from the second day since its establishment, 
on receiving the report, 
he compares it with each of the previous reports in order to calculate the number of previous days 
whose sales amounts are less than or equal to it. 
After obtaining the number of such days, he writes it in a list.
This problem can be stated more formally as follows. 
Let A = (a1, a2,..., an) denote the list of daily sales amounts. 
And let B = (b1, b2,..., bn-1) be another integer list maintained by Mr. Cooper, 
each value representing the number of such previous days. 
On the i-th day ( 2<=i<=n), he calculates bi-1, the number of ak's such that ak<=ai ( 1<=k < i).

For example, suppose that A = (20, 43, 57, 43, 20). 
For the fourth day's sales amount, a4 = 43, 
the number of previous days whose sales amounts are less than or equal to it is 2 since a1<=a4, 
a2<=a4, and a3 > a4. 
Therefore, b3 = 2. Similarly, b1, b2, and b4 can be obtained and it results in B = (1, 2, 2, 1).

Given an array of size n for the list of daily sales amounts, 
write a program that prints the sum of the n - 1 integers in the list B.

Input 

Your program is to read the input from standard input. 
The input consists of T test cases. 
The number of test cases T is given in the first line of the input. 
Each test case starts with a line containing an integer n ( 2<=n<=1, 000), 
which represents the size of the list A . 
In the following line, n integers are given, each represents the daily sales amounts 
ai ( 1<=a<=5, 000 and 1<=i<=n) for the test case.

Output 

Your program is to write to standard output. 
For each test case, print the sum of the n - 1 integers in the list B which is obtained from the list A.
The following shows sample input and output for two test cases.

Sample Input 

2
5
38 111 102 111 177
8
276 284 103 439 452 276 452 398
Sample Output 

9
20
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
