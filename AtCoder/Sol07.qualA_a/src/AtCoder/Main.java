package AtCoder;

import java.util.Scanner;

/**
 * This is the solution for problem #1 of Asian Elite Programming Contest.
 * 
 * @author Hyogi Jung(hyogij@gmail.com)
 * @date 2015-10-26
 * @url http://code-festival-2015-quala.contest.atcoder.jp/tasks/
 *      codefestival_2015_qualA_a
 */
public class Main {
	private static final String YEAR_2015 = "2015";

	public static void main(String[] args) {
		new Main().solve();
	}

	public void solve() {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();

		StringBuffer sb = new StringBuffer(str.substring(0, str.length() - 4));
		sb.append(YEAR_2015);
		System.out.println(sb.toString());
		
		scanner.close();
	}
}
