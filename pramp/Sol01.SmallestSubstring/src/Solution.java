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
		String[] arr = {"x", "y", "z", "y"};
		String target1 = "xyyzyzyx";

		System.out.println("getSmallestSubstring "
				+ getSmallestSubstring(arr, target1));
		System.out.println("getSmallestSubstringAdvanced "
				+ getSmallestSubstringAdvanced(arr, target1));

		String str = "xyz";
		String target2 = "xyyzyzyx";
		System.out.println("minWindow " + minWindow(str, target2));
	}

	private static String getSmallestSubstringAdvanced(String[] arr, String str) {
		String result = "";

		if (arr.length == 0 || str == null || str.length() == 0) {
			return result;
		}

		int[] targets = new int[26];
		int[] values = new int[26];
		for (int i = 0; i < arr.length; i++) {
			targets[arr[i].charAt(0) - 'a']++;
		}

		int min = Integer.MAX_VALUE;
		int left = 0, right = 0;
		for (; right < str.length(); right++) {
			int index = str.charAt(right) - 'a';
			values[index]++;

			if (targets[index] == 0) {
				continue;
			}

			if (targets[index] < values[index]) {
				for (; left <= right;) {
					// Move the sliding window from left to right
					values[str.charAt(left++) - 'a']--;
					if (targets[index] == values[index]) {
						break;
					}
				}
			}

			int length = right - left + 1;
			// Check equality of two arrays
			if (isEqual(targets, values) && length < min) {
				min = length;
				result = str.substring(left, right + 1);
			}
		}

		return result;
	}

	private static boolean isEqual(int[] targets, int[] values) {
		for (int i = 0; i < targets.length; i++) {
			if (targets[i] != 0 && targets[i] != values[i]) {
				return false;
			}
		}
		return true;
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

	public static String minWindow(String S, String T) {
		int[] needToFind = new int[256];
		int[] hasFound = new int[256];

		for (int i = 0; i < T.length(); ++i) {
			needToFind[T.charAt(i)]++;
		}

		int count = 0;
		int minWindowSize = Integer.MAX_VALUE;
		int start = 0, end = 0;
		String window = "";

		for (; end < S.length(); end++) {
			if (needToFind[S.charAt(end)] == 0)
				continue;
			char c = S.charAt(end);
			hasFound[c]++;

			if (hasFound[c] <= needToFind[c]) {
				count++;
			}

			if (count == T.length()) {
				while (needToFind[S.charAt(start)] == 0
						|| hasFound[S.charAt(start)] > needToFind[S
								.charAt(start)]) {
					if (hasFound[S.charAt(start)] > needToFind[S.charAt(start)])
						hasFound[S.charAt(start)]--;
					start++;
				}

				if (end - start + 1 < minWindowSize) {
					minWindowSize = end - start + 1;
					window = S.substring(start, end + 1);
				}
			}
		}

		return window;
	}
}
