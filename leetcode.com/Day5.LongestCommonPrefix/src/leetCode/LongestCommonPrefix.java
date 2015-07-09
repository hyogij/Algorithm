package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.09
 Question Number : 23
 Link : https://leetcode.com/problems/longest-common-prefix/
 ==========================================================
 */
public class LongestCommonPrefix {
	/*
	 * Write a function to find the longest common prefix string amongst an
	 * array of strings.
	 */
	public static void main(String[] args) {
		String[] strs = {"aabb", "aabb", "aabb", "aabb", "aabb", "aabb"};
		System.out.println("longestCommonPrefix " + longestCommonPrefix(strs));
	}

	public static String longestCommonPrefix(String[] strs) {
		int minLength = Integer.MAX_VALUE;

		// Base cases
		if (strs.length == 0) {
			return "";
		} else if (strs.length == 1) {
			return strs[0];
		}

		for (String str : strs) {
			int length = str.length();
			if (length < minLength) {
				minLength = length;
			}
		}

		int i = 0;
		for (i = 0; i < minLength; i++) {
			char c = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (c != strs[j].charAt(i)) {
					if (i == 0) {
						return "";
					}
					return strs[0].substring(0, i);
				}
			}
		}
		return strs[0].substring(0, i);
	}
}
