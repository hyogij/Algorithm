package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.09.11
 Question Number : 112
 Link : https://leetcode.com/problems/reverse-words-in-a-string/
 ==========================================================
 */

public class ReverseString {
	/*
	 * Given an input string, reverse the string word by word.
	 * 
	 * For example, Given s = "the sky is blue", return "blue is sky the".
	 * 
	 * Update (2015-02-12): For C programmers: Try to solve it in-place in O(1)
	 * space.
	 * 
	 * click to show clarification.
	 * 
	 * Clarification: What constitutes a word? A sequence of non-space
	 * characters constitutes a word. Could the input string contain leading or
	 * trailing spaces? Yes. However, your reversed string should not contain
	 * leading or trailing spaces. How about multiple spaces between two words?
	 * Reduce them to a single space in the reversed string.
	 */
	public static void main(String[] args) {
		System.out.println("reverseWords " + reverseWords("the sky is blue"));
		System.out.println("reverseWords "
				+ reverseWords("		split to words by space"));

	}

	public static String reverseWords(String s) {
		// First, reverse entire string. After that, split reversed string with
		// trailing spaces and then reverse each word.
		StringBuffer result = new StringBuffer();
		StringBuffer sb = new StringBuffer(s);
		sb.reverse();
		String[] words = sb.toString().split(" ");
		for (int i = 0; i < words.length; i++) {
			result.append(new StringBuffer(words[i]).reverse());
			if (i != words.length - 1) {
				result.append(" ");
			}
		}
		return result.toString();
	}
}
