/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.07
 Problem : http://www.crazyforcode.com/check-whether-two-strings-anagram/
 ==========================================================
 */
public class Solution {
	/*
	 * Write a function to check whether two strings are anagram of each other.
	 * Input: s - "abcde", t - "abced" Output = true Input s - "abcde", t -
	 * "abcfed" Output = false
	 */
	public static void main(String[] args) {
		System.out.println(isAnagram("abcde", "abced"));
		System.out.println(isAnagram("abcde", "abcfed"));

		System.out.println(isSubAnagram("tbackbbb", "abc"));
		System.out.println(isSubAnagram("tabbkiabc", "abc"));
		System.out.println(isSubAnagram("ttttabtttacew", "abc"));

		System.out.println(isSubAnagramAdvanced("tbackbbb", "abc"));
		System.out.println(isSubAnagramAdvanced("tabbkiabc", "abc"));
		System.out.println(isSubAnagramAdvanced("ttttabtttacew", "abc"));

	}

	private static boolean isAnagram(String str1, String str2) {
		char[] ascii = new char[256];
		for (int i = 0; i < str1.length(); i++) {
			ascii[str1.charAt(i)]++;
		}

		for (int i = 0; i < str2.length(); i++) {
			ascii[str2.charAt(i)]--;
			if (ascii[str2.charAt(i)] < 0) {
				return false;
			}
		}

		for (int i = 0; i < ascii.length; i++) {
			if (ascii[i] != 0) {
				return false;
			}
		}

		return true;
	}

	// Additional question is checking str1 is a sub anagram of str2.
	// For example, str2 is "abc"
	// tbackbbb : TRUE, tabbkiabc : TRUE, ttttabtttacew : FALSE

	// Brute force approach's time complexity is O(kn).
	private static boolean isSubAnagram(String str1, String str2) {
		for (int i = 0; i <= str1.length() - str2.length(); i++) {
			if (isAnagram(str1.substring(i, i + str2.length()), str2)) {
				return true;
			}
		}

		return false;
	}

	// Use a sliding window to traverse string from left to right
	private static String isSubAnagramAdvanced(String str1, String str2) {
		char[] requirement = new char[26];
		char[] found = new char[26];

		for (int i = 0; i < str2.length(); i++) {
			requirement[str2.charAt(i) - 'a']++;
		}

		int count = 0;
		int left = 0, right = 0;
		int min = str2.length();
		String result = "";
		for (; right < str1.length(); right++) {
			char c = str1.charAt(right);
			if (requirement[c - 'a'] == 0)
				continue;

			found[c - 'a']++;
			if (found[c - 'a'] <= requirement[c - 'a'])
				count++;

			if (count == str2.length()) {
				c = str1.charAt(left);
				while (requirement[c - 'a'] == 0
						|| requirement[c - 'a'] < found[c - 'a']) {
					if (requirement[c - 'a'] < found[c - 'a']) {
						found[c - 'a']--;
					}
					left++;
					c = str1.charAt(left);
				}

				if (right - left + 1 == min) {
					min = right - left + 1;
					result = str1.substring(left, right + 1);
				}
			}
		}
		if (result.length() == str2.length()) {
			System.out.println("str1 is a sub anagram of str2");
		} else {
			System.out.println("str1 is not a sub anagram of str2");
		}
		return result;
	}

}
