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
	 * Write a function to generate the generalized abbreviations of a word.
	 * 
	 * Example: Given word = "word", return the following list (order does not
	 * matter): ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2",
	 * "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
	 */
	public static void main(String[] args) {
		List<String> list = generateAbbreviations("word");
		System.out.println(list.toString());
	}

	public static List<String> generateAbbreviations(String word) {
		List<String> res = new ArrayList<>();
		DFS(res, new StringBuilder(), word.toCharArray(), 0, 0);
		return res;
	}

	public static void DFS(List<String> res, StringBuilder sb, char[] c, int i, int num) {
		int len = sb.length();
		if (i == c.length) {
			if (num != 0)
				sb.append(num);
			res.add(sb.toString());
		} else {
			DFS(res, sb, c, i + 1, num + 1); // abbr c[i]
			if (num != 0)
				sb.append(num); // not abbr c[i]
			
			DFS(res, sb.append(c[i]), c, i + 1, 0);
		}
		sb.setLength(len);
	}
}
