import java.util.Arrays;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.06
 Problem : https://leetcode.com/problems/shortest-palindrome/
 ==========================================================
 */
public class Solution {
	/*
	 * Given a string S, you are allowed to convert it to a palindrome by adding
	 * characters in front of it. Find and return the shortest palindrome you
	 * can find by performing this transformation.
	 * 
	 * For example:
	 * 
	 * Given "aacecaaa", return "aaacecaaa". 
	 * Given "abcd", return "dcbabcd".
	 */
	public static void main(String[] args) {
		System.out.println(shortestPalindrome("aacecaaa"));
		System.out.println(shortestPalindrome("abcd"));
		System.out.println(shortestPalindrome("aaaaa"));
		System.out.println(shortestPalindrome("aaaa"));
	}

	public static String shortestPalindrome(String s) {
		if(s == null || s.length() == 0)
			return "";
		
		String temp = s + "#" +new StringBuilder(s).reverse().toString();
		int[] table = makeNext(temp);

//		System.out.println(temp);
//		System.out.println(Arrays.toString(table));

		// Get the maximum palin part in s starts from 0
		return new StringBuilder(s.substring(table[table.length - 1]))
				.reverse().toString() + s;
	}

	public static int[] makeNext(String s) {
		int[] next = new int[s.length()];
		
		int index = 0;
		for (int i = 1; i < s.length();) {
			if (s.charAt(index) == s.charAt(i)) {
				next[i] = index + 1;
				index++;
				i++;
			} else {
				if (index != 0) {
					index = next[index - 1];
				} else {
					next[i] = 0;
					i++;
				}
			}
		}
		return next;
	}
}
