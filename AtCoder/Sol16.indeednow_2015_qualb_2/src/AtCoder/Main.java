package AtCoder;

import java.util.Scanner;

/**
 * This is the solution for problem #1 of Asian Elite Programming Contest.
 * 
 * @author Hyogi Jung(hyogij@gmail.com)
 * @date 2015-10-29
 * @url http://indeednow-qualb.contest.atcoder.jp/tasks/indeednow_2015_qualb_2
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

	private int getNumberOfShift(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return -1;
		}

		if (str1.equals(str2)) {
			return 0;
		}

		// Shift 1 char from end of string to front of string
		for (int i = 0; i < str1.length(); i++) {
			StringBuffer sb = new StringBuffer();
			sb.append(str1.charAt(str1.length() - 1));
			sb.append(str1.substring(0, str1.length() - 1));
			str1 = sb.toString();
			System.out.println(str1);
			if (sb.toString().equals(str2)) {
				return i + 1;
			}
		}

		return -1;
	}
}