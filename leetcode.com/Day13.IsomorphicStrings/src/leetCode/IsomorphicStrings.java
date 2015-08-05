package leetCode;

import java.util.HashMap;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.08.05
 Question Number : 56
 Link : https://leetcode.com/problems/max-points-on-a-line/
 ==========================================================
 */

public class IsomorphicStrings {
	/*
	 * Given two strings s and t, determine if they are isomorphic.
	 * 
	 * Two strings are isomorphic if the characters in s can be replaced to get
	 * t.
	 * 
	 * All occurrences of a character must be replaced with another character
	 * while preserving the order of characters. No two characters may map to
	 * the same character but a character may map to itself.
	 * 
	 * For example, Given "egg", "add", return true. Given "foo", "bar", return
	 * false. Given "paper", "title", return true.
	 * 
	 * Note: You may assume both s and t have the same length.
	 */

	public static void main(String[] args) {
		System.out.println("isIsomorphic " + isIsomorphic("egg", "add"));
		System.out.println("isIsomorphic " + isIsomorphic("foo", "bar"));
		System.out.println("isIsomorphic " + isIsomorphic("paper", "title"));
		System.out.println("isIsomorphic " + isIsomorphic("ab", "aa"));
	}

	public static boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		HashMap<Character, Character> map = new HashMap<Character, Character>();
		for (int i = 0; i < s.length(); i++) {
			Character s1 = s.charAt(i);
			Character t1 = t.charAt(i);
			if (map.containsKey(s1) == true) {
				if (!t1.equals(map.get(s1))) {
					return false;
				}
			} else {
				// Returns false when t1 is already existed in map
				for (Character c : map.values()) {
					if (c.equals(t1)) {
						return false;
					}
				}
				map.put(s1, t1);
			}
		}

		return true;
	}
}