import java.util.Arrays;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.06
 Problem : https://leetcode.com/problems/implement-strstr/
 ==========================================================
 */
public class Solution {
	/*
	 * Implement strStr().
	 * 
	 * Returns the index of the first occurrence of needle in haystack, or -1 if
	 * needle is not part of haystack.
	 */
	public static void main(String[] args) {
		String pattern1 = "AABAACAABAA";
		System.out.println(Arrays.toString(makeNext(pattern1.toCharArray())));
		String pattern2 = "ABCDE";
		System.out.println(Arrays.toString(makeNext(pattern2.toCharArray())));
		String pattern3 = "AAAAA";
		System.out.println(Arrays.toString(makeNext(pattern3.toCharArray())));
		String pattern4 = "AAABAAA";
		System.out.println(Arrays.toString(makeNext(pattern4.toCharArray())));
		String pattern5 = "AAACAAAAAC";
		System.out.println(Arrays.toString(makeNext(pattern5.toCharArray())));
		
	     System.out.println("strStr " + strStr("abcxabcdabcdabcy1", "abcdabcy"));
	     System.out.println("strStr " + strStrNaive("abcxabcdabcdabcy", "abcdabcy"));
	     System.out.println("strStr " + strStr("hello world", "world"));
	     System.out.println("strStr " + strStrNaive("hello world", "world"));
	}
	
	// Naive solution's time complexity is O(n^2)
	public static int strStrNaive(String text, String pattern) {
		for(int i = 0; i < text.length() - pattern.length() + 1; i++) {
			for(int j = 0; j < pattern.length(); j++) {
				char c1 = text.charAt(i + j);
				char c2 = pattern.charAt(j);
				if(c1 != c2) {
					break;
				}
				// Reach to the last character of pattern
				if(j == pattern.length() - 1)
					return i;
			}
		}
		return -1;
	}

	public static int strStr(String haystack, String needle) {
		if (haystack == null || needle == null)
			return -1;
		if (haystack.length() < needle.length())
			return -1;
		if (haystack.length() == 0 && needle.length() == 0)
			return 0;
		if (needle.length() == 0)
			return 0;
		
		int i = 0, j = 0;
		int next[] = makeNext(needle.toCharArray());
		while (i < haystack.length()) {
			if (haystack.charAt(i) == needle.charAt(j)) {
				i++;
				j++;
			} else {
				if (j == 0) {
					i++;
				} else {
					j = next[j - 1];
				}
			}

			if (j == needle.length()) {
				return i - j;
			}
		}

		return -1;
	}

	/**
     * Compute temporary array to maintain size of suffix which is same as prefix
     * Time/space complexity is O(size of pattern)
	 * For the pattern ¡°AABAACAABAA¡±, lps[] is [0, 1, 0, 1, 2, 0, 1, 2, 3, 4, 5]
	 * For the pattern ¡°ABCDE¡±, lps[] is [0, 0, 0, 0, 0]
	 * For the pattern ¡°AAAAA¡±, lps[] is [0, 1, 2, 3, 4]
	 * For the pattern ¡°AAABAAA¡±, lps[] is [0, 1, 2, 0, 1, 2, 3]
	 * For the pattern ¡°AAACAAAAAC¡±, lps[] is [0, 1, 2, 0, 1, 2, 3, 3, 3, 4]
	 */
	private static int[] makeNext(char pattern[]) {
		int[] next = new int[pattern.length];

		int index = 0;
		for (int i = 1; i < pattern.length;) {
			if (pattern[index] == pattern[i]) {
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
