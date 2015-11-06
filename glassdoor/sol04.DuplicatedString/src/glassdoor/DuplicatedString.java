package glassdoor;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.11.06
 Link : http://ideone.com/zbN6j0
 ==========================================================
 */
public class DuplicatedString {
	/*
	 * Find the first alphabet that is not duplicated in input string
	 */
	public static void main(String[] args) {
		String input = "I am going to watch a movie";
		System.out.println("findFirstAlphabet: " + findFirstAlphabet(input));
	}

	private static char findFirstAlphabet(String input) {
		char first = ' ';
		int[] alphabets = new int[26];

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);

			// Accepts the lower and upper alphabets, ignores the other
			// characters
			if (c >= 'a' && c <= 'z') {
				alphabets[c - 'a']++;
			} else if (c >= 'A' && c <= 'Z') {
				alphabets[c - 'A']++;
			}
		}

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			int index = -1;
			if (c >= 'a' && c <= 'z') {
				index = c - 'a';
			} else if (c >= 'A' && c <= 'Z') {
				index = c - 'A';
			}

			if (index != -1 && alphabets[index] == 1) {
				return c;
			}
		}

		return first;
	}
}