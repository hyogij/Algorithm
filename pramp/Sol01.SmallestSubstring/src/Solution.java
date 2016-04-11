import java.util.HashMap;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.02.10
 Question Number : 1
 http://articles.leetcode.com/2010/11/finding-minimum-window-in-s-which.html
 https://tianrunhe.wordpress.com/2013/03/23/minimum-window-substring/
 ==========================================================
 */
public class Solution {
	/*
	 * Smallest Substring of All Characters
	 * 
	 * Given an array with unique characters arr and a string str, find the
	 * smallest substring of str containing all characters of arr.
	 * 
	 * Example: arr: [x,y,z], str: xyyzyzyx result: zyx
	 */
	public static void main(String[] args) {
		String[] arr = {"x", "y", "z", "z"};
		String input1 = "xyyzyzyyxxxxyzz";

		System.out.println("getSmallestSubstring "
				+ getSmallestSubstring(arr, input1));

		String target = "xyzz";
		String input2 = "xyyzyzyyxxxxy1zz";
		System.out.println("getSmallestSubstringAdvanced "
				+ getSmallestSubstringAdvanced(input2, target));
		System.out.println("getSmallestSubstringTest "
				+ getSmallestSubstringTest(input2, target));
	}

	// Use the hashmap to find smallest substring but this algorithm's time
	// complexity is O(n^2)
	public static String getSmallestSubstring(String[] arr, String str) {
		HashMap<String, Integer> hash = null;
		int smallest = Integer.MAX_VALUE;
		int length = 0;
		String smallestSubstring = null;
		for (int i = 0; i < str.length(); i++) {
			// Initializze hashmap
			hash = new HashMap<String, Integer>();
			initHashMap(hash, arr);

			String key = String.valueOf(str.charAt(i));
			if (hash.containsKey(key)) {
				hash.put(key, hash.get(key) - 1);
			}

			length = 0;
			for (int j = i + 1; j < str.length(); j++) {
				key = String.valueOf(str.charAt(j));
				if (hash.containsKey(key)) {
					hash.put(key, hash.get(key) - 1);
				}
				length = j - i + 1;
				if (isAllFound(hash) && length < smallest) {
					smallest = length;
					smallestSubstring = str.substring(i, j + 1);
				}
			}
		}

		return smallestSubstring;
	}

	private static boolean isAllFound(HashMap<String, Integer> hash) {
		if (hash == null || hash.size() == 0) {
			return false;
		}

		for (String key : hash.keySet()) {
			if (hash.get(key) > 0) {
				return false;
			}
		}

		return true;
	}

	private static void initHashMap(HashMap<String, Integer> hash, String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			String key = arr[i];
			if (hash.containsKey(key)) {
				hash.put(key, hash.get(key) + 1);
			} else {
				hash.put(key, 1);
			}
		}
	}

	public static String getSmallestSubstringAdvanced(String input,
			String target) {
		int[] needToFind = new int[256];
		int[] hasFound = new int[256];

		for (int i = 0; i < target.length(); ++i) {
			needToFind[target.charAt(i)]++;
		}

		int count = 0;
		int minWindowSize = Integer.MAX_VALUE;
		int start = 0, end = 0;
		String window = "";

		for (; end < input.length(); end++) {
			char c = input.charAt(end);
			if (needToFind[c] == 0)
				continue;

			hasFound[c]++;
			if (hasFound[c] <= needToFind[c]) {
				count++;
			}

			if (count == target.length()) {
				while (needToFind[input.charAt(start)] == 0
						|| hasFound[input.charAt(start)] > needToFind[input
								.charAt(start)]) {
					if (hasFound[input.charAt(start)] > needToFind[input
							.charAt(start)]) {
						hasFound[input.charAt(start)]--;
					}

					start++;
				}

				if (end - start + 1 < minWindowSize) {
					minWindowSize = end - start + 1;
					window = input.substring(start, end + 1);
				}
			}
		}

		return window;
	}

	public static String getSmallestSubstringTest(String input, String target) {
		int[] found = new int[256];
		int[] needed = new int[256];

		for (int i = 0; i < target.length(); i++) {
			needed[target.charAt(i)]++;
		}

		int count = 0;
		int start = 0, end = 0;
		int minLength = Integer.MAX_VALUE;
		String substring = "";
		for (; end < input.length(); end++) {
			char c = input.charAt(end);
			if (needed[c] == 0) {
				continue;
			}

			found[c]++;
			if (found[c] <= needed[c]) {
				count++;
			}

			if (count == target.length()) {
				c = input.charAt(start);
				// Increase the starting point if it includes characters that is
				// a useless
				while (needed[c] == 0 || found[c] > needed[c]) {
					if (found[c] > needed[c]) {
						found[c]--;
					}
					start++;
					c = input.charAt(start);
				}

				int currentLength = end - start + 1;
				if (currentLength < minLength) {
					minLength = currentLength;
					substring = input.substring(start, end + 1);
				}

			}
		}

		return substring;
	}
}
