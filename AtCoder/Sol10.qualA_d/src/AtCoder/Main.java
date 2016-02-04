package AtCoder;

import java.util.Scanner;

/**
 * This is the solution for problem #1 of Asian Elite Programming Contest.
 * 
 * @author Hyogi Jung(hyogij@gmail.com)
 * @date 2015-10-26
 * @url http://asian-elite-2014-quala.contest.atcoder.jp/tasks/
 *      asian_elite_2014_qualA_d
 */
public class Main {
	public static void main(String[] args) {
		new Main().solve();
	}

	public void solve() {
		Scanner scanner = new Scanner(System.in);
		long A = scanner.nextLong();
		int K = scanner.nextInt();
		
		findClosestNumber(A, K);
		return;
	}
	
	private void findClosestNumber(long a, int k) {

	}
	/*
	 * Input Example 1
		1234 2
		Output Examle 1
		12
		In this case Dave can only use up to 2 kinds of numbers.
		He will input the closest integer 1222, so the difference is 12.
		
		Input Example 2
		800000 1
		Output Example 2
		22223
		Dave can use only 1 number, so 777777 is the closest integer.
	 */
}
