package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.08.05
 Question Number : 54
 Link : https://leetcode.com/problems/valid-anagram/
 ==========================================================
 */

public class validAnagram {
	/*
	 * Given two strings s and t, write a function to determine if t is an
	 * anagram of s.
	 * 
	 * For example, s = "anagram", t = "nagaram", return true. s = "rat", t =
	 * "car", return false.
	 * 
	 * Note: You may assume the string contains only lowercase alphabets.
	 */

	public static void main(String[] args) {
		System.out.println("isAnagram " + isAnagram("anagram", "nagaram"));
	}

	// Validates input strings is an anagram
	public static boolean isAnagram(String s, String t) {
		// Creates array which size is number of lowercase alphabets
		int[] array = new int[26];

		for (int i = 0; i < s.length(); i++) {
			int index = (int) (s.charAt(i) - 'a'); // index of alphabet
			array[index]++;
		}
		
		for (int i = 0; i < t.length(); i++) {
			int index = (int) (t.charAt(i) - 'a'); // index of alphabet
			array[index]--;
			if (array[index] < 0) {
				return false;
			}
		}

		// Checks an array whether there is remaining alphabets
		for (int i = 0; i < array.length; i++) {
			if (array[i] > 0) {
				return false;
			}
		}

		return true;
	}
}
