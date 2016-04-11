import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.09
 Link : https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 ==========================================================
 */
public class Solution {
	/*
	 * Given a digit string, return all possible letter combinations that the
	 * number could represent.
	 * 
	 * A mapping of digit to letters (just like on the telephone buttons) is
	 * given below.
	 * 
	 * Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf",
	 * "cd", "ce", "cf"].
	 * 
	 */
	public static void main(String[] args) {
		System.out.println(letterCombinations("23").toString());
		System.out.println(letterCombinations("9").toString());
	}

	static HashMap<Integer, String[]> map = null;

	public static void generateMappingTable() {
		map = new HashMap<Integer, String[]>();
		map.put(2, new String[] { "a", "b", "c" });
		map.put(3, new String[] { "d", "e", "f" });
		map.put(4, new String[] { "g", "h", "i" });
		map.put(5, new String[] { "j", "k", "l" });
		map.put(6, new String[] { "m", "n", "o" });
		map.put(7, new String[] { "p", "q", "r", "s" });
		map.put(8, new String[] { "t", "u", "v" });
		map.put(9, new String[] { "w", "x", "y", "z" });
	}

	public static List<String> letterCombinations(String digits) {
		List<String> list = new ArrayList<String>();
		if(digits == null || digits.length() == 0)
			return list;
		
		generateMappingTable();

		helper(digits, 0, list, new StringBuffer());
		return list;
	}

	public static void helper(String digits, int index, List<String> list, StringBuffer sb) {
		if (index == digits.length()) {
			list.add(new StringBuffer(sb.toString()).toString());
			return;
		}

		int digit = Integer.valueOf(digits.charAt(index) - '0');
		String[] letters = map.get(digit);
		for (String letter : letters) {
			sb.append(letter);
			helper(digits, index + 1, list, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
