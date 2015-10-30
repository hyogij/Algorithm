package AtCoder;

import java.util.Scanner;

/**
 * This is the solution for problem #1 of Asian Elite Programming Contest.
 * 
 * @author Hyogi Jung(hyogij@gmail.com)
 * @date 2015-10-30
 * @url http://ijpc2015.contest.atcoder.jp/tasks/ijpc2015_a
 */
public class Main {
	public static void main(String[] args) {
		new Main().solve();
	}

	public void solve() {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();

		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = scanner.nextInt();
		}
		scanner.close();

		System.out.println(getMinimumChairs(nums));
	}

	private int getMinimumChairs(int[] nums) {
		int num = 0;

		num += nums[0];
		for (int i = 1; i < nums.length; i++) {
			int max = Math.max(nums[i - 1], nums[i]);
			System.out.println(max);
			num += max;
		}
		num += nums[nums.length - 1];

		return num + nums.length;
	}
}