/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.02.17
 Problem : http://www.geeksforgeeks.org/anagram-substring-search-search-permutations/
 ==========================================================
 */
public class Solution {
	/*
	 * Anagram Substring Search (Or Search for all permutations) Given a text
	 * txt[0..n-1] and a pattern pat[0..m-1], write a function search(char
	 * pat[], char txt[]) that prints all occurrences of pat[] and its
	 * permutations (or anagrams) in txt[].
	 * 
	 * You may assume that n > m. Expected time complexity is O(n)
	 * 
	 * Examples:
	 * 
	 * 1) Input: txt[] = "BACDGABCDA" pat[] = "ABCD" Output: Found at Index 0
	 * Found at Index 5 Found at Index 6
	 * 
	 * 2) Input: txt[] = "AAABABAA" pat[] = "AABA" Output: Found at Index 0
	 * Found at Index 1 Found at Index 4
	 */
	public static void main(String[] args) {
		searchBasic("BACDGABCDA", "ABCD");
		searchAdvanced("BACDGABCDA", "ABCD");
		searchBasic("AAAKBCABAAZEABAAKE", "AABA");
		searchAdvanced("AAAKBCABAAZEAAABKE", "AABA");
	}

	// Simple algorithm that compares all substring. The time complexity is O(n)
	private static void searchBasic(String txt, String pat) {
		System.out.print("Index : ");
		for (int i = 0; i <= txt.length() - pat.length(); i++) {
			char c = txt.charAt(i);
			String str = txt.substring(i, i + pat.length());
			if (pat.indexOf(c) != -1 && isAnagram(str, pat) == true) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}

	private static boolean isAnagram(String str, String pat) {
		int[] alphabet = new int[26];
		for (int i = 0; i < pat.length(); i++) {
			int index = pat.charAt(i) - 'A';
			alphabet[index]++;
		}

		for (int i = 0; i < str.length(); i++) {
			int index = str.charAt(i) - 'A';
			alphabet[index]--;

			if (alphabet[index] < 0)
				return false;
		}

		for (int i = 0; i < 26; i++) {
			if (alphabet[i] != 0)
				return false;
		}
		return true;
	}

	private static void searchAdvanced(String input, String target) {
		int[] found = new int[26];
		int[] needed = new int[26];

		for (int i = 0; i < target.length(); i++) {
			needed[target.charAt(i) - 'A']++;
		}

		int start = 0, end = 0;
		for (; end < input.length(); end++) {
			int index = input.charAt(end) - 'A';
			if (needed[index] == 0) {
				continue;
			}
			found[index]++;

			// Increase the starting point if it includes characters that is a
			// useless
			index = input.charAt(start) - 'A';
			while (needed[index] == 0 || found[index] > needed[index]) {
				if (found[index] > needed[index]) {
					found[index]--;
				}
				start++;
				index = input.charAt(start) - 'A';
			}

			int currentLength = end - start + 1;
			if (currentLength == target.length()) {
				System.out.println(start + " : "
						+ input.substring(start, end + 1));
			}
		}

		return;
	}
}
