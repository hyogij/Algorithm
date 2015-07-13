package leetCode;

import java.util.Stack;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.13
 Question Number : 30
 Link : https://leetcode.com/problems/length-of-last-word/
 ==========================================================
 */
public class LengthOfLastWord {

	/*
	 * Given a string s consists of upper/lower-case alphabets and empty space
	 * characters ' ', return the length of last word in the string.
	 * 
	 * If the last word does not exist, return 0.
	 * 
	 * Note: A word is defined as a character sequence consists of non-space
	 * characters only.
	 * 
	 * For example, Given s = "Hello World", return 5.
	 */
	public static void main(String[] args) {
		String s = "Today is a nice day";
		System.out.println("lengthOfLastWord " + lengthOfLastWord(s));
	}

	// Counts the number of alphabets that consists of words after empty space.
	// My first approach is finding index of empty space but it is difficult to
	// handle when there is continuous empty space such as "a bbb   "
	public static int lengthOfLastWord(String s) {
		int lastWord = 0;
		int currentWord = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				if (i - 1 >= 0 && s.charAt(i - 1) != ' ') {
					lastWord = currentWord;
					currentWord = 0;
				}
			} else {
				currentWord++;
			}
		}

		if (lastWord == 0 && currentWord == 0) {
			// ex) ""
			return 0;
		} else if (lastWord == 0 && currentWord != 0) {
			// ex) "world"
			return currentWord;
		} else if (lastWord != 0 && currentWord != 0) {
			// ex) "hello world"
			return currentWord;
		} else {
			// ex) "hello world  "
			return lastWord;
		}
	}
}
