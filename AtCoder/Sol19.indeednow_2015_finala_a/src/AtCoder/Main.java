package AtCoder;

import java.util.Scanner;

/**
 * This is the solution for problem #1 of Asian Elite Programming Contest.
 * 
 * @author Hyogi Jung(hyogij@gmail.com)
 * @date 2015-10-30
 * @url http://indeednow-finala-open.contest.atcoder.jp/tasks/indeednow_2015_finala_a
 */
public class Main {
	public static void main(String[] args) {
		new Main().solve();
	}

	public void solve() {
		Scanner scanner = new Scanner(System.in);
		String str1 = scanner.nextLine();
		String str2 = scanner.nextLine();

		System.out.println(getNumberOfShift(str1, str2));
	}
}