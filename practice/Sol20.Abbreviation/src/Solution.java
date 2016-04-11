import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.07
 Problem : http://buttercola.blogspot.kr/2015/10/leetcode-unique-word-abbreviation.html
 ==========================================================
 */
public class Solution {
	/*
	 * An abbreviation of a word follows the form <first letter><number><last
	 * letter>. Below are some examples of word abbreviations: Assume you have a
	 * dictionary and given a word, find whether its abbreviation is unique in
	 * the dictionary. A word's abbreviation is unique if no other word from the
	 * dictionary has the same abbreviation.
	 * 
	 * Example: Given dictionary = ["deer", "door", "cake", "card" ]
	 * 
	 * isUnique("dear") -> false isUnique("cart") -> true isUnique("cane") ->
	 * false isUnique("make") -> true
	 */

	private static HashMap<String, Integer> map = new HashMap<String, Integer>();
	
	public static void main(String[] args) {
		String[] dictionary = {"deer", "door", "cake", "card"};

		makeAbbreviation(dictionary);

		System.out.println(map.toString());

		System.out.println(isUnique("dear"));
		System.out.println(isUnique("cart"));
		System.out.println(isUnique("cane"));
		System.out.println(isUnique("make"));
	}

	private static void makeAbbreviation(String[] dictionary) {
		for (String word : dictionary) {
			String abbr = abbreviation(word);
			if (map.containsKey(abbr)) {
				// Increase count value
				map.put(abbr, map.get(abbr) + 1);
			} else {
				map.put(abbr, 1);
			}
		}
	}

	private static String abbreviation(String word) {
		StringBuffer sb = new StringBuffer();

		sb.append(word.charAt(0));
		sb.append(word.length() - 2);
		sb.append(word.charAt(word.length() - 1));

		return sb.toString();
	}

	private static boolean isUnique(String word) {
		String abbr = abbreviation(word);
		if (map.containsKey(abbr))
			return false;
		return true;
	}

	/*
	 * Write a function to generate the generalized abbreviations of a word.
	 * Example: Given word = "word", return the following list (order does not
	 * matter):
	 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d",
	 * "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
	 * https://leetcode.com/discuss/questions/oj/generalized-abbreviation?sort=votes
	 * https://leetcode.com/discuss/76783/java-14ms-beats-100%25
	 */
	private static ArrayList<String> generalizedAbbreviation(String word) {
		ArrayList<String> abbreviations = new ArrayList<String>();

		return abbreviations;
	}
}
