import java.util.HashMap;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.08
 Problem : http://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/
 ==========================================================
 */
public class Solution {
	/*
	 * Given a string you need to print longest possible substring that has
	 * exactly M unique characters. If there are more than one substring of
	 * longest possible length, then print any one of them.
	 * 
	 * Examples:
	 * 
	 * "aabbcc", k = 1 
	 * Max substring can be any one from {"aa" , "bb" , "cc"}.
	 * 
	 * "aabbcc", k = 2 
	 * Max substring can be any one from {"aabb" , "bbcc"}.
	 * 
	 * "aabbcc", k = 3 
	 * There are substrings with exactly 3 unique characters
	 * {"aabbcc" , "abbcc" , "aabbc" , "abbc" } 
	 * Max is "aabbcc" with length 6.
	 * 
	 * "aaabbb", k = 3 
	 * There are only two unique characters, thus show error message.
	 */
	public static void main(String[] args) {
		System.out.println(nUniques("aabbcc", 1));
		System.out.println(nUniques("aabbcc", 2));
		System.out.println(nUniques("aabbcc", 3));
		System.out.println(nUniques("aaabbb", 3));
	}

	public static int nUniques(String txt, int k) {
		if (txt == null || txt.length() == 0 || k <= 0)
			return 0;

		int max = Integer.MIN_VALUE;
		int left = 0, right = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (; right < txt.length(); right++) {
			char c1 = txt.charAt(right);
			if (map.containsKey(c1)) {
				map.put(c1, map.get(c1) + 1);
			} else {
				map.put(c1, 1);
			}

			if (map.size() == k) {
				max = Math.max(max, right - left + 1);
			}

			while (map.size() > k) {
				char c2 = txt.charAt(left);
				int count = map.get(c2) - 1;
				if (count == 0)
					map.remove(c2);
				else
					map.put(c2, count);
				left++;
			}
		}
		return max;
	}

}
