import java.util.Arrays;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.01.25
 Question Number : 02
 Link : http://www.geeksforgeeks.org/find-all-shortest-unique-prefixes-to-represent-each-word-in-a-given-list/
http://www.careercup.com/question?id=5106806204399616
 http://www.codebytes.in/2014/10/finding-shortest-prefixes-for-strings.html
 ==========================================================
 */

public class Solution {
	/*
	 * Given an array of words, find all shortest unique prefixes to represent
	 * each word in the given array. Assume that no word is prefix of another.
	 * 
	 * Examples:
	 * 
	 * Input: arr[] = {"zebra", "dog", "duck", "dove"} 
	 * Output: dog, dov, du, z
	 * Explanation: 
	 * dog => dog 
	 * dove = dov 
	 * duck = du 
	 * z => zebra
	 * 
	 * Input: arr[] = {"geeksgeeks", "geeksquiz", "geeksforgeeks"}; 
	 * Output: {geeksf, geeksg, geeksq}
	 */
	public static void main(String[] args) {
		String[] strings1 = {"zebra", "dog", "duck", "dove"};
		uniqueprefix(strings1);
//		String[] strings2 = {"geeksgeeks", "geeksquiz", "geeksforgeeks"};
//		uniqueprefix(strings2);
//		String[] strings3 = {"bearcat", "bear"};
//		uniqueprefix(strings3);
//		String[] strings4 = {"dog","done","good","go","gogo","gold","golf","why","which","while","zebra", "duck","dot"};
//		uniqueprefix(strings4);				
	}
	
	private static void uniqueprefix(String[] words) {
		String[] prefix = new String[words.length];
		Arrays.sort(words);
		System.out.println(Arrays.toString(words));

		String prevPrefix = "";
		String nextPrefix = "";
		for (int i = 0; i < words.length; i++) {
			String current = words[i];
			if (i < words.length - 1) {
				String next = words[i + 1];
				prevPrefix = nextPrefix;
				int idx = 0;
				while (idx < current.length()
						&& current.charAt(idx) == next.charAt(idx)) {
					idx++;
				}
				if (idx == 0) {
					nextPrefix = "";
				} else {
					nextPrefix = current.substring(0, idx);
				}
				String elected = "";
				if (prevPrefix.length() > nextPrefix.length()) {
					elected = prevPrefix;
				} else {
					elected = nextPrefix;
				}

				if (elected.length() == current.length()) {
					prefix[i] = "";
					nextPrefix = nextPrefix.substring(0,
							nextPrefix.length() - 1);
				} else {
					prefix[i] = elected + current.charAt(elected.length());
				}
			} else {
				prefix[i] = nextPrefix + current.charAt(nextPrefix.length());
			}
			System.out.println(Arrays.toString(prefix));
		}
	}
}
