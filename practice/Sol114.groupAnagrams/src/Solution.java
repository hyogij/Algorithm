import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

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
	
	// word break 
	// 재귀적으로는 어떻게 할 수 있는가?
	// 존재하는 경우 재귀적으로 호출 한다, 이 때의 시간복잡도는 어떻게 되나? 
	public static boolean wordBreak(String s, Set<String> dict) {
		return helper(s, 0, dict);
	}
	
	public static boolean helper(String s, int index, Set<String> dict) {
		if(index == s.length())
			return true;
		
		for(int i = index + 1; i < s.length(); i++) {
			String word = s.substring(index, i);
			if(dict.contains(word)) {
				return helper(s, i, dict);
			}
		}
		return false;
	}
	// DP를 이용해서 이런 코드를 작성 할 수 있어야 한다.
}
