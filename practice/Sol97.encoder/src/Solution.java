import java.util.ArrayList;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.04
 Problem : https://leetcode.com/problems/encode-and-decode-strings/
 ==========================================================
 */
public class Solution {
	/*
	 * Design an algorithm to encode a list of strings to a string. The encoded
	 * string is then sent over the network and is decoded back to the original
	 * list of strings.
	 * 
	 * Machine 1 (sender) has the function:
	 * 
	 * string encode(vector<string> strs) { // ... your code return
	 * encoded_string; }
	 * 
	 * Machine 2 (receiver) has the function: vector<string> decode(string s) {
	 * //... your code return strs; }
	 * 
	 * So Machine 1 does: string encoded_string = encode(strs);
	 * 
	 * and Machine 2 does: vector<string> strs2 = decode(encoded_string); strs2
	 * in Machine 2 should be the same as strs in Machine 1.
	 * 
	 * Implement the encode and decode methods.
	 * 
	 * Note: The string may contain any possible characters out of 256 valid
	 * ascii characters. Your algorithm should be generalized enough to work on
	 * any possible characters. Do not use class member/global/static variables
	 * to store states. Your encode and decode algorithms should be stateless.
	 * Do not rely on any library method such as eval or serialize methods. You
	 * should implement your own encode/decode algorithm.
	 * 
	 * Tags: String Similar Problems: (E) Count and Say, (M) Serialize and
	 * Deserialize Binary Tree
	 */
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Hello World!!!");
		list.add("Big Java!!!");
		list.add("Good morning@!#:");
		list.add("GoodGoodGoodGoodGood morning@!#:");
		System.out.println(list.toString());

		String message = encoder(list);
		System.out.println(message);

		ArrayList<String> list2 = decoder(message);
		System.out.println(list2.toString());
	}

	public static String encoder(ArrayList<String> list) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			String message = list.get(i);
			// Append the length of each words with ':'
			sb.append(message.length());
			sb.append(":");
			sb.append(message);
		}
		return sb.toString();
	}

	public static ArrayList<String> decoder(String s) {
		ArrayList<String> list = new ArrayList<String>();
		int start = 0;
		while (start < s.length()) {
			int num = 0;
			for (; start < s.length(); start++) {
				char c = s.charAt(start);
				if (c == ':') {
					start++;
					break;
				}
				num *= 10;
				num += (c - '0');
			}

			list.add(s.substring(start, start + num));
			start = start + num;
		}
		return list;
	}
}
