package AtCoder;

import java.util.Scanner;

/**
 * This is the solution for problem #1 of Asian Elite Programming Contest.
 * 
 * @author Hyogi Jung(hyogij@gmail.com)
 * @date 2015-10-29
 * @url http://indeednow-qualb.contest.atcoder.jp/tasks/indeednow_2015_qualb_1
 */
public class Main {
	public static void main(String[] args) {
		new Main().solve();
	}

	public void solve() {
		Scanner scanner = new Scanner(System.in);
		int x1 = scanner.nextInt();
		int y1 = scanner.nextInt();
		int x2 = scanner.nextInt();
		int y2 = scanner.nextInt();

		System.out.println(getManhatanDistance(x1, y1, x2, y2));
	}

	private int getManhatanDistance(int x1, int y1, int x2, int y2) {
		int distance = 1;

		// Move the position from x2 to x1
		while (x1 != x2) {
			if (x2 > x1) {
				x2--;
			} else {
				x2++;
			}
			distance++;
		}

		// Move the position from y2 to y1
		while (y1 != y2) {
			if (y2 > y1) {
				y2--;
			} else {
				y2++;
			}
			distance++;
		}

		return distance;
	}
}