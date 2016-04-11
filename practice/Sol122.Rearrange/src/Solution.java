import java.util.TreeMap;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.09
 Link : http://www.geeksforgeeks.org/rearrange-a-string-so-that-all-same-characters-become-at-least-d-distance-away/
 ==========================================================
 */
public class Solution {
	/*
	 * Given a string and a positive integer d. Some characters may be repeated
	 * in the given string. Rearrange characters of the given string such that
	 * the same characters become d distance away from each other. Note that
	 * there can be many possible rearrangements, the output should be one of
	 * the possible rearrangements. If no such arrangement is possible, that
	 * should also be reported. Expected time complexity is O(n) where n is
	 * length of input string.
	 * 
	 * Examples: Input: "abb", d = 2 Output: "bab" Input: "aacbbc", d = 3
	 * Output: "abcabc" Input: "geeksforgeeks", d = 3 Output: egkegkesfesor
	 * Input: "aaa", d = 2 Output: Cannot be rearranged
	 * 
	 */
	public static void main(String[] args) {
		System.out.println(rearrange("abb", 2));
		System.out.println(rearrange("aacbbc", 3));
		System.out.println(rearrange("geeksforgeeks", 3));
		System.out.println(rearrange("aaa", 2));
	}

	public static String rearrange(String str, int d) {
		if (str == null || str.length() == 0)
			return "";

		TreeMap<Character, Integer> treemap = new TreeMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (treemap.containsKey(c)) {
				treemap.put(c, treemap.get(c) + 1);
			} else {
				treemap.put(c, 1);
			}
		}
		// 0, d, 2d, 3d, 4d,
		// 1, d+1, 2d+1, 3d+1, 4d+1
		// 2, d+2, 2d+2, 3d+2, 4d+2....... repeat 

		char[] text = new char[str.length()];
		System.out.println(treemap.toString());
		

		return String.valueOf(text);
	}
}
