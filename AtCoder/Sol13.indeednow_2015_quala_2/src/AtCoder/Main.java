package AtCoder;

import java.util.HashMap;
import java.util.Scanner;

/**
 * This is the solution for problem #1 of Asian Elite Programming Contest.
 * 
 * @author Hyogi Jung(hyogij@gmail.com)
 * @date 2015-10-29
 * @url http://indeednow-quala.contest.atcoder.jp/tasks/indeednow_2015_quala_2
 */
public class Main {
	private static final String INDEEDNOW = "indeednow";
	public static void main(String[] args) {
		new Main().solve();
	}

	public void solve() {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.valueOf(scanner.nextLine());

		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
		HashMap<Character, Integer> copyMap = null;

		// Make the hashmap that includes each alphabets and its frequency
		for (int i = 0; i < INDEEDNOW.length(); i++) {
			Character c = INDEEDNOW.charAt(i);
			if (hashMap.containsKey(c)) {
				int count = hashMap.get(c);
				hashMap.put(c, count + 1);
			} else {
				hashMap.put(c, 1);
			}
		}

		String[] strings = new String[n];
		for (int i = 0; i < n; i++) {
			strings[i] = scanner.nextLine();
		}

		for (int i = 0; i < n; i++) {
			copyMap = new HashMap<Character, Integer>(hashMap);
			// Compare input string with hashmap
			checkString(copyMap, INDEEDNOW, strings[i]);
		}
		return;
	}

	private void checkString(HashMap<Character, Integer> hashMap, String match,
			String s) {
		if (match.length() != s.length()) {
			System.out.println("NO");
			return;
		}

		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (hashMap.containsKey(c)) {
				int count = hashMap.get(c);
				count--;
				if (count == 0) {
					hashMap.remove(c);
				} else {
					hashMap.put(c, count);
				}
			} else {
				System.out.println("NO");
				return;
			}
		}

		if (hashMap.isEmpty() == true) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}