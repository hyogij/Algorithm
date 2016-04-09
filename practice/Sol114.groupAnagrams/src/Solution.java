import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.08
 Problem : https://leetcode.com/problems/anagrams/
 http://www.geeksforgeeks.org/given-a-sequence-of-words-print-all-anagrams-together/
 ==========================================================
 */
public class Solution {
	/*
	 * Given an array of strings, group anagrams together.
	 * 
	 * For example, given: 
	 * ["eat", "tea", "tan", "ate", "nat", "bat"], 
	 * Return: 
	 * [ ["ate", "eat","tea"], 
	 * ["nat","tan"], 
	 * ["bat"] ] 
	 * Note: For the return value, each inner list's elements must follow the 
	 * lexicographic order.
	 * All inputs will be in lower-case.
	 */
	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> list = new ArrayList<List<String>>();
		list = groupAnagrams(strs);
		System.out.println(list.toString());
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> list = new ArrayList<List<String>>();
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		List<String> sub = null;

		for (String word : strs) {
			char[] chars = word.toCharArray();
			
			// Sort characters by lexicographic order
			Arrays.sort(chars);
			String alphabet = String.valueOf(chars);
			// Group by same ordered word
			if (map.containsKey(alphabet)) {
				sub = (List<String>) map.get(alphabet);
				sub.add(word);
			} else {
				sub = new ArrayList<String>();
				sub.add(word);
				map.put(alphabet, sub);
			}
		}
		System.out.println(map.toString());

		for (String alphabet : map.keySet()) {
			sub = (List<String>) map.get(alphabet);
			// Order words in the list
			Collections.sort(sub, String.CASE_INSENSITIVE_ORDER);
			list.add(sub);
		}

		return list;
	}
}
