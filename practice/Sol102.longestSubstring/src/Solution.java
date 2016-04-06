import java.util.Arrays;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.06
 Problem : http://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
 ==========================================================
 */
public class Solution {
	/*
	 * Given a string, find the length of the longest substring without
	 * repeating characters. For example, the longest substrings without
	 * repeating characters for ¡°ABDEFGABEF¡± are ¡°BDEFGA¡± and ¡°DEFGAB¡±, with
	 * length 6. For ¡°BBBB¡± the longest substring is ¡°B¡±, with length 1. For
	 * ¡°GEEKSFORGEEKS¡±, there are two longest substrings shown in the below
	 * diagrams, with length 7.
	 * 
	 * The desired time complexity is O(n) where n is the length of the string.
	 */
	public static void main(String[] args) {
		System.out.println("getLongestSubstringWORepeat "
				+ getLongestSubstringWORepeat("ABDEFGABEF"));
		System.out.println("getLongestSubstringWORepeat "
				+ getLongestSubstringWORepeat("BBBB"));
		System.out.println("getLongestSubstringWORepeat "
				+ getLongestSubstringWORepeat("GEEKSFORGEEKS"));
	}

	public static int getLongestSubstringWORepeat(String str) {
		if (str == null || str.length() == 0)
			return -1;

		String longest = null;
		int max = Integer.MIN_VALUE;

		int[] visited = new int[26];
		for (int i = 0; i < visited.length; i++)
			visited[i] = Integer.MIN_VALUE;

		int left = 0, right = 0;
		for (; left <= right && right < str.length(); right++) {
			int index = str.charAt(right) - 'A';
			if (visited[index] != Integer.MIN_VALUE) {
				int current = right - left;
				if (current > max) {
					max = current;
					longest = str.substring(left, right);
				}

				int start = left;
				left = visited[index] + 1;
				for (; start < visited[index]; start++)
					visited[str.charAt(start) - 'A'] = Integer.MIN_VALUE; // Clear
			}
			visited[index] = right;
		}

		System.out.println(longest);
		return max;
	}
}
