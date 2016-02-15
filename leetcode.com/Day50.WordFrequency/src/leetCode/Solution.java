package leetCode;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.02.15
 Question Number : 164
 Link : https://leetcode.com/problems/word-frequency/
 ==========================================================
 */
public class Solution {
	/*
	 * Write a bash script to calculate the frequency of each word in a text
	 * file words.txt.
	 * 
	 * For simplicity sake, you may assume:
	 * 
	 * words.txt contains only lowercase characters and space ' ' characters.
	 * Each word must consist of lowercase characters only. Words are separated
	 * by one or more whitespace characters. For example, assume that words.txt
	 * has the following content:
	 * 
	 * the day is sunny the the the sunny is is
	 * 
	 * Your script should output the following, sorted by descending frequency:
	 * the 4 is 3 sunny 2 day 1
	 */

	public static void main(String[] args) {
		String file = "the day is sunny the the the sunny is is ";
		wordFrequency(file);
	}

	private static void wordFrequency(String file) {
		TreeMap<String, Integer> words = new TreeMap<String, Integer>();
		String[] inputs = file.split("\\s+");

		for (String input : inputs) {
			if (words.containsKey(input)) {
				words.put(input, words.get(input) + 1);
			} else {
				words.put(input, 1);
			}
		}
		words = (TreeMap<String, Integer>) sortByValues(words);
		System.out.println(words.toString());
	}

	public static <K, V extends Comparable<V>> Map<K, V> sortByValues(
			final Map<K, V> map) {
		Comparator<K> valueComparator = new Comparator<K>() {
			public int compare(K k1, K k2) {
				int compare = map.get(k2).compareTo(map.get(k1));
				if (compare == 0)
					return 1;
				else
					return compare;
			}
		};
		Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
		sortedByValues.putAll(map);
		return sortedByValues;
	}
}
