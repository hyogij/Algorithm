package leetCode;

import java.util.HashMap;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.10.12
 Question Number : 139
 Link : https://leetcode.com/problems/word-pattern/
 ==========================================================
 */

public class WordPattern {
	/*
	 * Given a pattern and a string str, find if str follows the same pattern.
	 * 
	 * Here follow means a full match, such that there is a bijection between a
	 * letter in pattern and a non-empty word in str.
	 * 
	 * Examples: 
	 * pattern = "abba", str = "dog cat cat dog" should return true.
	 * pattern = "abba", str = "dog cat cat fish" should return false. 
	 * pattern = "aaaa", str = "dog cat cat dog" should return false. 
	 * pattern = "abba", str = "dog dog dog dog" should return false. 
	 * 
	 * Notes: You may assume pattern contains only lowercase letters, and str 
	 * contains lowercase letters separated by a single space.
	 */

	public static void main(String[] args) {
		System.out.println("wordPattern "
				+ wordPattern("abba", "dog cat cat dog"));
		System.out.println("wordPattern "
				+ wordPattern("abba", "dog cat cat fish"));
		System.out.println("wordPattern "
				+ wordPattern("aaaa", "dog cat cat dog"));
		System.out.println("wordPattern "
				+ wordPattern("abba", "dog dog dog dog"));
	}

	public static boolean wordPattern(String pattern, String str) {
		String[] words = str.split(" ");

		// Compares the length of pattern with the number of words in str
		// separated by a single space. If the length are not equal, return
		// false.
		if (pattern.length() != words.length) {
			return false;
		}

		// Use a HashMap to store pattern and word
		HashMap<String, String> hashMap = new HashMap<String, String>();
		for (int i = 0; i < pattern.length(); i++) {
			String key = String.valueOf(pattern.charAt(i));
			if (hashMap.containsKey(key)) {
				String word = hashMap.get(key);
				if (!word.equals(words[i])) {
					return false;
				}
			} else {
				// If the word already exist in hashmap, return false
				if (hashMap.containsValue(words[i])) {
					return false;
				}
				hashMap.put(key, words[i]);
			}
		}
		return true;
	}
}
