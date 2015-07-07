package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.03
 Question Number : 9
 Link : https://leetcode.com/problems/shortest-palindrome/
 ==========================================================
 */
public class ShortestPalindrome {

	/*
	 * Given a string S, you are allowed to convert it to a palindrome by adding
	 * characters in front of it. Find and return the shortest palindrome you
	 * can find by performing this transformation.
	 * 
	 * For example: Given "aacecaaa", return "aaacecaaa". Given "abcd", return
	 * "dcbabcd".
	 */
	public static void main(String[] args) {
		String s = "aabba";
		System.out.println("shortestPalindrome = " + shortestPalindrome(s));
	}

	// FIXME(hyogij): Below function couldn't solve all possible inputs, so I
	// have to modify algorithm.
	public static String shortestPalindrome(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			char last = s.charAt(s.length() - 1 - i);
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				s = s.substring(0, i) + last + s.substring(i, s.length());
			}
		}
		return s;
	}
}