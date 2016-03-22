import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.22
 Problem : http://www.geeksforgeeks.org/remove-nodes-root-leaf-paths-length-k/
 ==========================================================
 */
public class Solution {
	/*
	 * Given a string s and a dictionary of words dict, determine if s can be
	 * segmented into a space-separated sequence of one or more dictionary
	 * words.
	 * 
	 * For example, given s = "leetcode", dict = ["leet", "code"].
	 * 
	 * Return true because "leetcode" can be segmented as "leet code".
	 */
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("leet");
		set.add("code");
		set.add("a");
		set.add("a1");

		System.out.println("wordBreak " + wordBreak("aleetcode1", set));
		System.out.println("wordBreak " + wordBreak("a1leetcode", set));
		System.out.println("wordBreak " + wordBreak("aleetcode", set));

		System.out.println("wordBreak " + wordBreakDP("aleetcode1", set));
		System.out.println("wordBreak " + wordBreakDP("a1leetcode", set));
		System.out.println("wordBreak " + wordBreakDP("aleetcode", set));
	}

	public static boolean wordBreak(String s, Set<String> dict) {
		if (s == null || s.length() == 0 || dict == null || dict.size() == 0)
			return false;

		return wordBreakHelper(s, 0, dict);
	}

	public static boolean wordBreakHelper(String s, int index, Set<String> dict) {
		if (index == s.length()) {
			return true;
		}

		boolean isSegemented = false;

		for (int j = 0; j < s.length() - index; j++) {
			String sub = s.substring(index, index + j + 1);
			if (dict.contains(sub)) {
				isSegemented = wordBreakHelper(s, index + j + 1, dict);
			}
		}
		return isSegemented;
	}

	public boolean wordBreak1D(String s, Set<String> dict) {
		if (s == null || s.length() == 0)
			return false;

		int n = s.length();
		// dp[i] represents whether s[0...i] can be formed by dict
		boolean[] dp = new boolean[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				String sub = s.substring(j, i + 1);

				if (dict.contains(sub) && (j == 0 || dp[j - 1])) {
					dp[i] = true;
					break;
				}
			}
		}

		return dp[n - 1];
	}

	// https://github.com/mission-peace/interview/blob/34e4e5e29302feef07b90166b16eae2edcd466d4/src/com/interview/dynamic/BreakMultipleWordsWithNoSpaceIntoSpace.java
	public static boolean wordBreakDP(String s, Set<String> dict) {
		if (s == null || s.length() == 0 || dict == null || dict.size() == 0)
			return false;

		int row = s.length(), col = s.length();
		boolean[][] mat = new boolean[row][col];
		for (int len = 1; len <= s.length(); len++) {
			for (int i = 0; i < s.length() - len + 1; i++) {
				int j = i + len - 1;
				String str = s.substring(i, j + 1);
				if (dict.contains(str)) {
					mat[i][j] = true;
				} else {
					// aleet --> a leet
					for (int k = i + 1; k < j; k++) {
						String left = s.substring(i, k + 1);
						String right = s.substring(k + 1, j + 1);
						if (mat[i][k - 1] && mat[k][j]) {
							mat[i][j] = true;
							break;
						}
					}
				}
			}
		}
		return mat[0][col - 1];
	}
}
