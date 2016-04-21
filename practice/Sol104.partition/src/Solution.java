import java.util.ArrayList;
import java.util.List;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.06
 Problem : https://leetcode.com/problems/palindrome-partitioning/
 ==========================================================
 */
public class Solution {
	/*
	 * Given a string s, partition s such that every substring of the partition
	 * is a palindrome.
	 * 
	 * Return all possible palindrome partitioning of s.
	 * 
	 * For example, given s = "aab", Return
	 * 
	 * [ ["aa","b"], ["a","a","b"] ]
	 */
	public static void main(String[] args) {
		List<List<String>> list = partition("aab");
		System.out.println(list.toString());
	}

	// Make all combinations that are palindrome words
	public static List<List<String>> partition(String s) {
		List<List<String>> list = new ArrayList<List<String>>();
		helper(s, 0, list, new ArrayList<String>());
		return list;
	}

	public static void helper(String s, int index, List<List<String>> list,
			List<String> sub) {
		if (index == s.length()) {
			list.add(new ArrayList<String>(sub));
			return;
		}

		for (int i = index + 1; i <= s.length(); i++) {
			String str = s.substring(index, i);
			if (isPalindrome(str)) {
				sub.add(str);
				helper(s, i, list, sub);
				sub.remove(sub.size() - 1);
			}
		}
	}

	public static boolean isPalindrome(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - i - 1))
				return false;
		}
		return true;
	}
}
