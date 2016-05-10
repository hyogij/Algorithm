/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.05.10
 Problem : http://codereview.stackexchange.com/questions/17517/reversing-every-word-in-a-string
 ==========================================================
 */
public class Solution {
	/*
	 * Reverse every word in a string, ignore the spaces.
	 * 
	 * The following is my code. The basic idea is to scan the string, when
	 * finding a word, then reverse it. The complexity of the algorithm is O(n),
	 * where n is the length of the string.
	 */
	public static void main(String[] args) {
		String text1 = "Hello There";
		String text2 = "How are you?";
		String text3 = "my nAMe is john.";
		String text4 = "my nAMe is j'ohn.";

		System.out.println(reverseSentence(text1));
		System.out.println(reverseSentence(text2));
		System.out.println(reverseSentence(text3));
		System.out.println(reverseSentence(text4));
	}

	public static String reverseSentence(String text) {
		StringBuffer sb = new StringBuffer();
		StringBuffer reverse = new StringBuffer();

		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			if (c == ' ' || c == '?' || c == '.') {
				sb.reverse();
				sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
				reverse.append(sb);
				reverse.append(c);
				sb = new StringBuffer();
			} else {
				c = Character.toLowerCase(c);
				sb.append(c);
			}
		}

		if (sb.length() != 0) {
			sb.reverse();
			reverse.append(sb);
		}

		return reverse.toString();
	}
}
