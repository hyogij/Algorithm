package leetCode;

import java.util.HashSet;
import java.util.Set;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.10.06
 Question Number : 133
 Link : https://leetcode.com/problems/word-break/
 ==========================================================
 */

public class WordBreak {
	/*
	 * Given a string s and a dictionary of words dict, determine if s can be
	 * segmented into a space-separated sequence of one or more dictionary
	 * words.
	 * 
	 * For example, given s = "leetcode", dict = ["leet", "code"].
	 * 
	 * Return true because "leetcode" can be segmented as "leet code".
	 */
	public static void main(String[] args) {
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("aaaa");
		wordDict.add("aaa");
		String s = "aaaaaaa";

		System.out.println("wordBreak " + wordBreak(s, wordDict));
	}

	public static boolean wordBreak(String s, Set<String> dict) {
		if (s == null || s.length() == 0) {
			return false;
		}
		return wordBreakHelper(s, 0, dict);
	}

	private static boolean wordBreakHelper(String s, int start, Set<String> dict) {
		if (start == s.length()) {
			return true;
		}
		
		for (int i = start + 1; i <= s.length(); i++) {
			if (dict.contains(s.substring(start, i))) {
				if (wordBreakHelper(s, i, dict)) {
					return true;
				}
			}
		}
		return false;
	}
}