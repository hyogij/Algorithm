import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This is the solution for problem #4 of Asian Elite Programming Contest.
 * 
 * @author Hyogi Jung(hyogij@gmail.com)
 * @date 2015-10-31
 */
public class Main {
	public static void main(String[] args) {
		new Main().solve();
	}

	ArrayList<String> arrayList = new ArrayList<String>();

	private void solve() {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		scanner.close();

		char strArray[] = str.toCharArray();
		Arrays.sort(strArray);

		permute(strArray, strArray.length, "");
		if (arrayList.size() != 0) {
			System.out.println(arrayList.get(0));
		} else {
			System.out.println("-1");
		}
	}

	private void permute(char[] s, int level, String prefix) {
		if (arrayList.size() != 0) {
			return;
		}

		if (level == 0) {
			if (isPossibleWord(prefix)) {
				arrayList.add(prefix);
			}
			return;
		}

		for (int i = 0; i < s.length; i++) {
			char c = s[i];
			if (isPossiblePermute(String.valueOf(s), c, prefix)) {
				permute(s, level - 1, prefix + c);
			}
		}
	}

	private static boolean isPossibleWord(String original) {
		if (original.length() == 0) {
			return true;
		}

		char c = original.charAt(0);
		for (int i = 1; i < original.length(); i++) {
			if (c == original.charAt(i)) {
				return false;
			}
			c = original.charAt(i);
		}
		return true;
	}

	private static boolean isPossiblePermute(String original, char c,
			String word) {
		int num = 0;
		for (int i = 0; i < original.length(); i++) {
			if (original.charAt(i) == c) {
				num++;
			}
		}

		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == c) {
				num--;
			}
		}

		if (num >= 1) {
			return true;
		} else {
			return false;
		}
	}
}