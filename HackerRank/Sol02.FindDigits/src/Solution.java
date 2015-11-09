import java.util.Scanner;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.11.09
 Question Number : 2
 Link : https://www.hackerrank.com/challenges/find-digits
 ==========================================================
 */
public class Solution {
	/*
	 * Problem Statement
	 * You are given an integer N. Find the digits in this number that exactly
	 * divide N (division that leaves 0 as remainder) and display their count.
	 * For N=24, there are 2 digits (2 & 4). Both of these digits exactly divide
	 * 24. So our answer is 2.
	 * 
	 * Note
	 * If the same number is repeated twice at different positions, it should be
	 * counted twice, e.g., For N=122, 2 divides 122 exactly and occurs at ones'
	 * and tens' position. So for this case, our answer is 3. Division by 0 is
	 * undefined. Input Format
	 * 
	 * The first line contains T (the number of test cases), followed by T lines
	 * (each containing an integer N).
	 * 
	 * Constraints 1¡ÂT¡Â15 0<N<10^10 
	 * 
	 * Output Format
	 * For each test case, display the count of digits in N that exactly divide
	 * N in a separate line.
	 * 
	 * Sample Input
	 * 2 
	 * 12 
	 * 1012 
	 * 
	 * Sample Output
	 * 2 
	 * 3 
	 * 
	 * Explanation
	 * 2 digits in the number 12 divide it exactly. The first digit, 1, divides
	 * it exactly in twelve parts, and the second digit, 2 divides 12 equally in
	 * six parts.
	 * 
	 * 1 divides 1012 exactly (and it occurs twice), and 2 also divides it
	 * exactly. Division by 0 is undefined, therefore it will not be counted.
	 * 
	 * This challenge was part of Pragyan 12.
	 */
	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Long[] nums = new Long[n];

		for (int i = 0; i < n; i++) {
			Long num = scanner.nextLong();
			nums[i] = num;
		}

		for (int i = 0; i < n; i++) {
			System.out.println(findDigits(nums[i]));
		}
	}

	private static int findDigits(Long num) {
		int[] counts = new int[10];

		Long original = num;
		while (num != 0) {
			int remain = (int) (num % 10);
			if (remain != 0 && original % remain == 0) {
				counts[remain]++;
			}
			num /= 10;
		}

		int sum = 0;
		for (int i = 0; i < counts.length; i++) {
			sum += counts[i];
		}
		return sum;
	}
}
