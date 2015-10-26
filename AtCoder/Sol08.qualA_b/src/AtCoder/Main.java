package AtCoder;

import java.util.Scanner;

/**
 * This is the solution for problem #1 of Asian Elite Programming Contest.
 * 
 * @author Hyogi Jung(hyogij@gmail.com)
 * @date 2015-10-26
 * @url http://code-festival-2015-quala.contest.atcoder.jp/tasks/
 *      codefestival_2015_qualA_b
 */
public class Main {
	public static void main(String[] args) {
		new Main().solve();
	}

	public void solve() {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		String[] str = new String[N];
		for (int i = 0; i < N; i++) {
			str[i] = scanner.next();
		}
		scanner.close();

		getSumOfStringSeries(str);
		return;
	}

	private void getSumOfStringSeries(String[] str) {
		int sum = 0;

		for (int i = 0; i < str.length; i++) {
			int num = Integer.valueOf(str[i]);
			sum = sum + num + sum;
		}

		System.out.println(sum);
	}
}
