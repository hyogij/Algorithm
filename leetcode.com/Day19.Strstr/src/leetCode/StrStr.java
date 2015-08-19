package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.08.19
 Question Number : 77
 Link : https://leetcode.com/problems/implement-strstr/
 ==========================================================
 */

public class StrStr {
	/*
	 * Implement strStr().
	 * 
	 * Returns the index of the first occurrence of needle in haystack, or -1 if
	 * needle is not part of haystack.
	 * 
	 * Update (2014-11-02): The signature of the function had been updated to
	 * return the index instead of the pointer. If you still see your function
	 * signature returns a char or String, please click the reload button to
	 * reset your code definition.
	 */
	public static void main(String[] args) {
		System.out.println("strStr " + strStr("testtest", "tes"));
		System.out.println("strStr " + strStr("testtest", "es"));
		System.out.println("strStr " + strStr("testtest", "et"));
		System.out.println("strStr " + strStr("mississippi", "issipi"));
		System.out.println("strStr " + strStr("", ""));
		System.out.println("strStr " + strStr("ab", ""));
		System.out.println("strStr " + strStr("a", "a"));
	}

	public static int strStr(String haystack, String needle) {
		if (haystack.length() < needle.length()) {
			return -1;
		}
		
		if (needle.length() == 0) {
			return 0;
		}

		for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
			for (int j = 0; j < needle.length(); j++) {
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					break;
				}

				// Return the index of the first occurrence of needle in
				// haystack
				if (j == needle.length() - 1) {
					return i;
				}
			}
		}

		return -1;
	}
}
